package com.tpe;

import org.springframework.context.annotation.*;

import java.awt.*;

@Configuration //this will be our configuration class
@ComponentScan("com.tpe")  //it will scan all sub packages starting from "com.tpe"
@PropertySource("classpath:application.properties")//Load Properties file in Spring config
public class AppConfiguration {

    @Bean
    public Point point(){
        return new Point(45, 33);
    }

}
