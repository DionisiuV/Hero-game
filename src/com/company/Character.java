package com.company;

import java.util.Random;

public class Character {
    private double health;
    private int strength;
    private int defence;
    private int speed;
    private int luck;


    public Character(double health, int strength, int defence, int speed, int luck) {
        this.health = health;
        this.strength = strength;
        this.defence = defence;
        this.speed = speed;
        this.luck = luck;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefence() {
        return defence;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLuck() {
        return luck;
    }

    public static int attack(int attackerStr, int defenderDef){

        return attackerStr - defenderDef;

    }
}
