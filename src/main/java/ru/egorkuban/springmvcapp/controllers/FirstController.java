package ru.egorkuban.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage (){
        return "first/hello";
    }
    @GetMapping("/bye")
    public String goodByePage(){
        return "first/bye";
    }
}
