package com.superwind.conf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix="common")
public class ProviderProperties {
    private String testA;
    private String testB;
    private Ops ops;

    @Data
    @NoArgsConstructor
    public static class Ops{
        private String accessLog;
        private String errorLog;
    }
}
