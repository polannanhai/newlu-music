package com.newlu.newlumusic.controller;

import com.newlu.newlumusic.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class DefaultController {

    @GetMapping
    public String sayHello(){
        User user = new User();
        user.getId();
        return "欢迎绿芦音乐会";
    }
}
