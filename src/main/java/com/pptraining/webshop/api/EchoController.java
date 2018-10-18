package com.pptraining.webshop.api;

import com.pptraining.webshop.WebshopApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class for testing purposes.
 */
//TODO remove this class later.

@Controller
@RequestMapping(path = "/api/v1/echo")
public class EchoController {

    private static final Logger LOGGER = LogManager.getLogger(WebshopApplication.class);

    @GetMapping(path = "/greeting")
    public ResponseEntity<String> greeting(@RequestParam final String name) {
        LOGGER.info("Greeting sent to " + name);
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

}
