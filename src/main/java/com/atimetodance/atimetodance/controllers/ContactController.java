package com.atimetodance.atimetodance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class ContactController {

    @GetMapping("/contactus")
    @ResponseBody
    public String contactUs() {
        return "Contact Us Page";
    }
}