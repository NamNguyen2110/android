package com.assignment.android.common.utils;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class SenderEmailUtils {
    private final TemplateEngine templateEngine;

    public SenderEmailUtils(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    private final Logger logger = (Logger) LoggerFactory.getLogger(SenderEmailUtils.class);
    @Value("${spring.mail.username}")
    private String appEmail;
    @Value("${spring.mail.password}")
    private String appPassword;
    @Value("${spring.mail.host}")
    private String hostName;
    @Value("${ssl.port}")
    private String sllPort;

    public void sendForgetEmail(String resetCode, String email,String urlForgetPassword) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", hostName);
        props.put("mail.smtp.socketFactory.port", sllPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", sllPort);
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(appEmail, appPassword);
            }
        });
        Context context = new Context();
        context.setVariable("title", "Forget your password");
        context.setVariable("link", urlForgetPassword + resetCode);
        try {
            String body = templateEngine.process("ForgetPassword", context);
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            MimeMessageHelper helper = null;
            helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setSubject("Email Reset Password");
            helper.setFrom(appEmail);
            helper.setText("", body);
            Transport.send(message);
        } catch (MessagingException e) {
            logger.info("SENDER EMAIL EXCEPTION");
            e.printStackTrace();
        }
    }
}
