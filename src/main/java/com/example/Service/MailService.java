/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Service;


import com.example.Domain.User;
import org.springframework.scheduling.annotation.Async ;

/**
 * Created by ashraf on 1/27/2016.
 */
public interface MailService {
    @Async
    void Send(String to, String subject, String text, boolean isHtml) ;

    @Async
    void SendVerification(User user) ;

}
