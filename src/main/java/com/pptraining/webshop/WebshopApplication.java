package com.pptraining.webshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
public class WebshopApplication {

    private static final Logger LOGGER = LogManager.getLogger(WebshopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }
}
