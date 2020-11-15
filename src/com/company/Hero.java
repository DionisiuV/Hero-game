package com.company;

public class Hero extends Character {
   private String name;

    public Hero(String name) {
        super(Utility.random(70, 100), Utility.random(70, 80), Utility.random(45, 55), Utility.random(40, 50), Utility.random(10, 30));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
