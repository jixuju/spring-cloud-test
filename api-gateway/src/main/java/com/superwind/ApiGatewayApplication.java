package com.superwind;

import com.superwind.conf.AddResponseHeaderFilter;
import com.superwind.conf.AuthPreFilter;
import com.superwind.conf.ErrorFilter;
import com.superwind.conf.QueryParamPreFilter;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	/*@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				Ssl ssl = new Ssl();
				//Server.jks中包含服务器私钥和证书
				ssl.setKeyStore("classpath:server.keystore");
				ssl.setKeyStorePassword("123456");
				container.setSsl(ssl);
				container.setPort(50001);
			}
		};
	}*/

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {

		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {

			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addMethod("GET");
				collection.addMethod("POST");
				collection.addPattern("/feign/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(50001);
		return connector;
	}

	@Bean
	public AddResponseHeaderFilter addResponseHeaderFilter(){
		return new AddResponseHeaderFilter();
	}

	@Bean
	public AuthPreFilter authFilter(){
		return new AuthPreFilter();
	}

	@Bean
	public QueryParamPreFilter queryParamPreFilter(){
		return new QueryParamPreFilter();
	}

	@Bean
	public ErrorFilter errorFilter(){
		return new ErrorFilter();
	}
}
