package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("smsService")
public class SmsService implements MessageService{


    // 3 round
    @Value("${app.email}")
    private String email;

    // 2nd round
    @Autowired
    @Qualifier("fileRepository")
    private Repository repository;
    @Override
    public void sendMessage(Message message){
        System.out.println("I am a SMS Service, and I am sending you this message:"+message.getMessage());
        repository.saveMessage(message);

       System.out.println(email);


    }
}
