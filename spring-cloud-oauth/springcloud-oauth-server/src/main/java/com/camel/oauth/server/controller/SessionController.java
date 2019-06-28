package com.camel.oauth.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/logout")
    public String logout(Principal principal){

        System.out.println(principal);
        return "ok";
    }
}
