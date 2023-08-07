package com.atimetodance.atimetodance.controllers;

import models.Submission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.atimetodance.atimetodance.services.EmailService;



@Controller
class ContactController {
    private final EmailService emailService;

    ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/contact")
    public String contactUs(Model model) {
        model.addAttribute("submission", new Submission());
        return "pages/contact";
    }

    @PostMapping("/contact")
    public String createGameSession(@ModelAttribute Submission submission) {
        emailService.sendSubmission(submission);
        emailService.receipt(submission);
        return "redirect:/submitted";
    }
    @GetMapping("/submitted")
    public String contactUs(@ModelAttribute Submission submission) {
//        ADD IN MODEL TO PASS IN FIRST NAME
//        ADD LOGIC TO REDIRECT TO CONTACT IF NOT SUBMITTED IN SESSION ALREADY - COOKIE?
        System.out.println(submission.getFirstName());
        return "pages/submitted";
    }
}