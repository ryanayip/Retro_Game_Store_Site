package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showAbout")
    public String showAbout(Model theModel) {

        return "about";
    }


}
