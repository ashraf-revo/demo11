package com.example.Service.Impl;

import ch.qos.logback.core.Context;
import com.example.Domain.User;
import org.springframework.stereotype.Service;
import com.example.Service.MailService ;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
/**
 *
 * @author Ashraf Atef
 */
@Service
class MailServiceimpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;
//    @Autowired
//   private SpringTemplateEngine templateEngine;

    @Override
    public void Send(String to, String subject, String text, boolean isHtml) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, isHtml);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(MailServiceimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
   public void SendVerification(User user) {
//        Context context = new Context() {};
//        context.setVariable("name",user.getEmail()) ;
//        context.setVariable("password", user.getPassword()) ;
//        Send(user.getEmail(), "Activation Message", templateEngine.process("activationEmail", context), true)

        Send(user.getEmail(),"Verification Code From Glass World App","Hello "+user.getUsername()+" ,\n"+"Your Verification Code is :"+user.getVerificationCode(),false);
    }

   
}