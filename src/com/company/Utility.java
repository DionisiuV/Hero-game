package com.company;

import java.util.Random;

public class Utility {

    public static int random(int min,int max) {
        Random random = new Random();

        int diff = (max - min) + 1;

        int x = random.nextInt(diff) + min;

        return x;
    }

    public static Boolean chance(double chance) {
        return Math.random() <= chance;
    }
}
