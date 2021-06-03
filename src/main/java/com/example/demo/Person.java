package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired
    public Outfit outfit;
    public Person(){

    }
    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public Person(Outfit outfit) {
        this.outfit = outfit;
    }
}
