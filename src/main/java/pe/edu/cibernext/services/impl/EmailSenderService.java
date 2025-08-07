package pe.edu.cibernext.services.impl;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    public void enviarEmail(String emailDestino, String mensaje,String nombreUsuario,String pass) {
        try {
            final String asunto = "Bienvenido a SecurityApp";
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(emailDestino);
            helper.setSubject(asunto);

            Context context = new Context();
            context.setVariable("subject", asunto);
            context.setVariable("message", mensaje);
            context.setVariable("email",emailDestino);
            context.setVariable("username", nombreUsuario);
            context.setVariable("pass", pass);

            String htmlContent = templateEngine.process("email-template", context);
            helper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Error enviando el correo", e);
        }
    }
}