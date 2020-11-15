package com.company;

public class Monster extends Character {
    private String name;

    public Monster(String name) {
        super(Utility.random(60, 90), Utility.random(60, 90), Utility.random(40, 60), Utility.random(40, 60), Utility.random(25, 40));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
