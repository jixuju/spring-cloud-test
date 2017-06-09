package com.superwind.config;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiangxj on 2017/6/7.
 */
@Configuration
public class FooConfiguration {
    @Bean
    public Request.Options options() {
        return new Request.Options(10 * 1000, 10 * 1000);
    }

    @Bean
    Retryer feignRetryer() {
        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(1L),2);
    }
}
