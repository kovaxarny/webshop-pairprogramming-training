package com.pptraining.webshop.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping (path = "/api/v1/echo")
public class EchoController {

    @GetMapping(path = "/greeting")
    public ResponseEntity<String> greeting(@RequestParam final String name){
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

}
