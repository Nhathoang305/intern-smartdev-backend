package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext context =SpringApplication.run(DemoApplication.class, args);
        Person person = context.getBean(Person.class);
        System.out.println("Instance Person: "+person);
        System.out.println("wear of Person: "+person.outfit);
        person.outfit.wear();

    }

}
