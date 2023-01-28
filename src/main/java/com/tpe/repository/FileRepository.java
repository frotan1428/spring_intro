package com.tpe.repository;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component("fileRepository")
public class FileRepository implements Repository {

    @Override
    public void saveMessage(Message message) {
        System.out.println("Your message has been saved to FILE: "+message.getMessage());
    }
}
