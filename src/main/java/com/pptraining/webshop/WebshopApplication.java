package com.pptraining.webshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebshopApplication {

    private static final Logger LOGGER = LogManager.getLogger(WebshopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }
}