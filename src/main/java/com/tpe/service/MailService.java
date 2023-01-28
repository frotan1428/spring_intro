package com.tpe.service;

import com.tpe.domain.Message;

import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mailService") //instance of this class will be created, and waiting in IoC container
//@Scope(value = "singleton") //it is the default value
//@Scope(value="prototype")
public class MailService implements MessageService{

   // Reference Values from Properties File -- final round
    @Value("${app.email}")
    private String email;

    //Repository repository = new FileRepository();

    //Field Injection
//    @Autowired // dependency injection
//    @Qualifier("dbRepository") // @Qualifier annotation is used after @Autowired, if
//    // there are more than one concrete child class
//    private Repository repository;


    //Setter Injection

//    private Repository repository;
//    @Autowired
//    @Qualifier("dbRepository")
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }

    //Constructor Injection

    private Repository repository;

    @Autowired// if you have inside a class one constructor  no need to use Autowired annotation.
    public MailService(@Qualifier("fileRepository") Repository repository) {
        this.repository = repository;
    }

    public void sendMessage(Message message){// 1 st round
        System.out.println("I am a Mail Service," +
                " and I am sending you this message:"+message.getMessage());

        repository.saveMessage(message);//// second  round
       // System.out.println(email); final round

    }
}
