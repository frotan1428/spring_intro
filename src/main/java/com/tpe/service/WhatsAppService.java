package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("whatsAppService")
@Scope("prototype")
public class WhatsAppService implements MessageService{
    @Autowired
    @Qualifier("fileRepository")
    private Repository repository;
    public void sendMessage(Message message){
        System.out.println("I am a WhatsApp Service, and I am sending you this message:"+message.getMessage());
        repository.saveMessage(message);

    }
}
