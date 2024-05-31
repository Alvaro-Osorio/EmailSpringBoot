package com.ao.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface IEmailService {

    void sendEmail(String[] toUser, String subject, String message);

    void sendEmailWithFile(String[] toUser, String subject, String message, File  file);

}
