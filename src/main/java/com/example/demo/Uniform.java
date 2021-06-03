package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Uniform implements Outfit{

    @Override
    public void wear() {
        System.out.println("Dang Mac Dong Phuc");
    }
}
