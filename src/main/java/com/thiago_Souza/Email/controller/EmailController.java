package com.thiago_Souza.Email.controller;

import com.thiago_Souza.Email.model.EmailModel;
import com.thiago_Souza.Email.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/email")
public class EmailController {

    private EmailService emailService;

    @PostMapping("/")
    public void enviarEmail(@RequestBody EmailModel emailModel) throws MessagingException {
        emailService.enviarEmail(emailModel);
    }
}
