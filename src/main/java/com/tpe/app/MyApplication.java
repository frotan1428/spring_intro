package com.tpe.app;


import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.awt.*;


public class MyApplication {
    public static void main(String[] args) {


         Message message = new Message();
         message.setMessage("You orders have been received...");


        // 1st round
        //Read Spring Java configuration class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        //Retrieve bean from Spring container
       // MailService service = context.getBean(MailService.class);


        // parpemeter component();
        MessageService service= context.getBean("mailService", MessageService.class);
        //--------this is part come after injection type.
//        // let s check if we are using the same object scope prototype
        MessageService service2 = context.getBean("mailService", MessageService.class);

        if(service2 == service){
            System.out.println("They are the same Object");
        }else {
            System.out.println("They are different object");
        }



        service.sendMessage(message);


        //bean round
        //call Point from container
        Point point = context.getBean("point",Point.class);
        System.out.println("X coordinate: "+point.getX());


        context.close();//life cycle of created beans will be ended

    }
}
