package com.example.springboot_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HomePageController {

    @GetMapping("home")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
