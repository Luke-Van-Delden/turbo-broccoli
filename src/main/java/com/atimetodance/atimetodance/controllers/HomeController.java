package com.atimetodance.atimetodance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "pages/home";
    }

    @GetMapping("/about")
    public String about() {
        return "pages/about";
    }

    @GetMapping("/gallery")
    public String gallery() {
        return "pages/gallery";
    }

    @GetMapping("/rates")
    public String rates() {
        return "pages/rates";
    }

    @GetMapping("/faq")
    public String faq() {
        return "pages/faq";
    }
}
