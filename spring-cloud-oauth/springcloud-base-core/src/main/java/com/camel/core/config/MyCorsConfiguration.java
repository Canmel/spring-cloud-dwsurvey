package com.camel.core.config;

import org.springframework.web.cors.CorsConfiguration;

public class MyCorsConfiguration {
    public static CorsConfiguration buildConfig() {
        org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
        config.addAllowedOrigin("*"); // 1允许任何域名使用
        config.addAllowedHeader("*"); // 2允许任何头
        config.addAllowedMethod("*"); // 3允许任何方法（post、get等）
        return config;
    }
}
