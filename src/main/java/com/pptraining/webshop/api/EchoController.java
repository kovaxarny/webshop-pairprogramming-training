package com.pptraining.webshop.api;

import com.pptraining.webshop.WebshopApplication;
import com.pptraining.webshop.service.UserAddressDO;
import com.pptraining.webshop.service.UserDO;
import com.pptraining.webshop.service.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private final UserRepository userRepository;

    public EchoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/greeting")
    public ResponseEntity<String> greeting(@RequestParam final String name) {
        LOGGER.info("Greeting sent to " + name);

        UserDO laci = UserDO.builder()
                .username("lacifasza")
                .firstName("Laszlo")
                .lastName("Preznyak")
                .username("laciusername")
                .email("laci@gmail.com")
                .address(UserAddressDO.builder()
                        .country("Magyarorszag")
                        .city("Debrecen")
                        .street("Derek")
                        .houseNumber("56")
                        .zipCode("4031")
                        .build())
                .phoneNumber("0040743485349")
                .build();
        userRepository.save(laci);

        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

}
