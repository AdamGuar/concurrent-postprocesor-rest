package com.postprocesor.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	@Autowired
    public JavaMailSender emailSender;
 
    public boolean sendSimpleMessage(
      List<String> to, String from, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        String[] toArr = new String[to.size()];
        toArr = to.toArray(toArr);
        message.setTo(toArr);
        message.setSubject(subject);
        String messageHeader = from + " is sending you a message: ";
        message.setText(messageHeader + text);
        emailSender.send(message);
        return true;
    }
	
}
