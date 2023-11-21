package com.thiago_Souza.Email.service;

import com.thiago_Souza.Email.model.EmailModel;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender javaMailSender;

    public void enviarEmail(EmailModel emailModel) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);

        mimeMessageHelper.setFrom(emailModel.getFrom());
        mimeMessageHelper.setTo(emailModel.getTo());
        mimeMessageHelper.setSubject(emailModel.getSebject());
        mimeMessageHelper.setText(emailModel.getText());

        javaMailSender.send(message);
    }


}
