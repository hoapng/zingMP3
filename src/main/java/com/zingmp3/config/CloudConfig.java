package com.zingmp3.config;

import com.cloudinary.Cloudinary;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@SpringBootApplication
public class CloudConfig {

    @Bean
    public Cloudinary cloudinaryConfigs() {
        Cloudinary cloudinary = null;
        Map config = new HashMap();
        config.put("cloud_name", "duqqesvgq");
        config.put("api_key", "314974995166968");
        config.put("api_secret", "vjP-Q1_hMhfQJBQeQtcc9hsDXsM");
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

}
