package com.api.Specialization.controllers;

import com.api.Specialization.models.Doctor;
import com.api.Specialization.models.User;
import com.api.Specialization.models.Speciality;
import com.api.Specialization.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;


@Controller
public class MailController {
    private List<User> users;

    public MailController() {

    }

    public MailController(List<User> users) {
        this.users = users;
    }
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/sendmail")
    public String sendmail() {

        emailService.sendMail("kate@example.com", "Test Subject", "Test mail");
        return "emailsent";
    }

    public void sendMailNotification(Doctor doctor) {
        emailService.sendMail("pantarubianca1@gmail.com", "New Doctor", "Test");
        for(User user : users) {
            for (String preferedSpeciality : user.getSpecialityPreferences()) {
                for (String doctorSpeciality : doctor.getSpeciality()) {
                    if (doctorSpeciality == preferedSpeciality) {
                        String mail = "A new doctor in your area with the specialization " + preferedSpeciality + " has registered.";
                        emailService.sendMail("pantarubianca1@gmail.com", "New Doctor", mail);
                    }
                }
            }
        }
    }
}