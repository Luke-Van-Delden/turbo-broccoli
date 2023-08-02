package com.atimetodance.atimetodance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ContactController {

    @GetMapping("/contact")
    public String contactUs() {
        return "pages/contact";
    }
}