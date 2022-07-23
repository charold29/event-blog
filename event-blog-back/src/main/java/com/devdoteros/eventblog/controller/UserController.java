package com.devdoteros.eventblog.controller;

import com.devdoteros.eventblog.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/hi")
    public String hello(){
        return "Hola";
    }
}
