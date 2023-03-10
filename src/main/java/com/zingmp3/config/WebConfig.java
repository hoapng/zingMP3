package com.zingmp3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*")
//                .allowCredentials(false)
//                .allowedOriginPatterns("http://*")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .maxAge(1800).exposedHeaders("Authorization,Link,X-Total-Count,X-${jhipster.clientApp.name}-alert,X-${jhipster.clientApp.name}-error,X-${jhipster.clientApp.name}-params");
//
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/resources/**")
////                .addResourceLocations("file:///D:/zingmp3/src/main/resources/static/images");
//        registry.addResourceHandler("/uploads/**").addResourceLocations("file:///D:/zìnmp3/uploads");
//    }

}
