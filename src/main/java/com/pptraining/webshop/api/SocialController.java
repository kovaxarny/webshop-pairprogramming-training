package com.pptraining.webshop.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SocialController {

    @RequestMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }
}
