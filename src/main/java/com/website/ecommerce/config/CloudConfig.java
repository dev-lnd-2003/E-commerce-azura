package com.website.ecommerce.config;

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
        config.put("cloud_name", "dlltmgvna");
        config.put("api_key", "535579483755739");
        config.put("api_secret", "aftAJ3dNPPRpnD0UKC8FPVWo4gQ");
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }
}
