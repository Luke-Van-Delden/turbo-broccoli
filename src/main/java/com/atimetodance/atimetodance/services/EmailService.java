package com.atimetodance.atimetodance.services;

import models.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("no-reply@atimetodance.org")
    private String from;

//    @Value("${bgaKey}")
//    private String bgaKey;

    public void receipt(Submission submission) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(submission.getEmail());
        msg.setSubject("Thank you for contacting us!");
        msg.setText("Thank you for reaching out to A Time to Dance. We appreciate your interest, and will contact you within 1-2 business days!");


        try{
            this.emailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
    public void sendSubmission(Submission submission) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo("lukevd90@gmail.com");
        msg.setSubject("A potential client has reached out");
        msg.setText("First Name: " + submission.getFirstName() + "\nLast Name: " + submission.getLastName() + "\nEmail: " + submission.getEmail() + "\nPhone Number: " + submission.getPhoneNumber() + "\nDescription: " + submission.getDescription());



        try{
            this.emailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}
