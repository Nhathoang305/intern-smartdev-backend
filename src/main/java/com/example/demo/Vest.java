package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Vest implements Outfit{

    @Override
    public void wear() {
        System.out.println("Dang Mac Vest");
    }
}
