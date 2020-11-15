package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hero hero = new Hero("Orderus");
        Monster monster = new Monster("Wild Beast");

        System.out.println("Here is a little game with 2 character, a HERO and a MONSTER, choose your favorite!");
        System.out.println("1 - MONSTER\n2 - HERO");
        int choice = scanner.nextInt();

        System.out.println("Good choice, here is some stats:");
        System.out.println("MONSTER: \nHP: "+monster.getHealth()+ "\nSTR: " +monster.getStrength()+
                                    "\nDEF: "+monster.getDefence()+"\nSPEED: "+monster.getSpeed()+"\nLUCK: "+monster.getLuck());
        System.out.println("---------------------------------------");
        System.out.println("HERO: \nHP: "+hero.getHealth()+ "\nSTR: " +hero.getStrength()+
                "\nDEF: "+hero.getDefence()+"\nSPEED: "+hero.getSpeed()+"\nLUCK: "+hero.getLuck());

        System.out.println("Enter 1 to start the battle");
        scanner.nextInt();



    int rounds = 1;
    boolean heroTurn = true;

    if(monster.getSpeed() > hero.getSpeed()){
        heroTurn = false;
    } else if(monster.getSpeed() == hero.getSpeed()){
        if(monster.getLuck() > hero.getLuck()){
            heroTurn = false;
        }
    }

    while(rounds <21){
        System.out.println("----------------------------------------------------------");
        System.out.println("\t\tROUND NO " + rounds +"");


        if(heroTurn){
            System.out.println("----------------------------------------------------------");
            System.out.println("\t\t!!!HERO TURN!!!");
            //using skills?
            boolean skillUse = Utility.chance(0.1);

            //is monster lucky?
            boolean isLucky = Utility.chance( (double) monster.getLuck() / 100 );


            //calculate damage
            if(!isLucky) {
                double damage = hero.attack(hero.getStrength(), monster.getDefence());
                if(skillUse){
                    damage *= 2;
                }
                monster.setHealth(monster.getHealth() - damage);
                //hp left?
                if(monster.getHealth() <=0){
                    if(choice == 2){
                        System.out.println("!!YOU WON!!");
                    }else{
                        System.out.println("You lose!");
                    }
                    System.out.println(hero.getName() +" hit monster with "+ damage +" and killed it!");
                    System.out.println(hero.getName() + " hero is the winner and was left with: " +hero.getHealth()+ "hp.");
                    System.out.println("THE BATTLE IS OVER!");
                    break;
                }else {

                    System.out.println("\t\t" + hero.getName() + " attacked monster!");
                    if (skillUse) System.out.println("\t\tSkill used -> Rapid strike");
                    System.out.println("\t\tDamage was: " + damage + ", monster having " + monster.getHealth() + "hp left.");
                }
            } else{
                System.out.println("\t\tMonster had luck.");
            }



            heroTurn = false;
        } else {
            System.out.println("----------------------------------------------------------");
            System.out.println("\t\t!!!MONSTER TURN!!!");

            //hero use skills?
            boolean skillUse = Utility.chance(0.2);

            //is hero lucky?
            boolean isLucky = Utility.chance( (double) hero.getLuck() / 100 );

            //calculate damage
            if(!isLucky) {
                double damage = monster.attack(monster.getStrength(), hero.getDefence());

                if(skillUse){
                    damage /= 2;
                }
                hero.setHealth(hero.getHealth() - damage);

                //hp left?
                if(hero.getHealth() <=0) {
                    if(choice == 1){
                        System.out.println("!!YOU WON!!");
                    }else{
                        System.out.println("You lose!");
                    }
                    System.out.println(monster.getName() +" hit hero with "+ damage +" and killed it!");
                    System.out.println(monster.getName() + " monster is the winner and was left with: " + monster.getHealth() + "hp.");
                    System.out.println("THE BATTLE IS OVER!");
                    break;
                }else {
                    System.out.println("\t\t" + monster.getName() + " attacked hero!");
                    if (skillUse) System.out.println("\t\tSkill used by hero -> Magic shield");
                    System.out.println("\t\tDamage was: " + damage + ", hero having " + hero.getHealth() + "hp left.");
                }

            }else{
                System.out.println("\t\tHero had luck!");
            }
                heroTurn = true;
        }

        rounds++;
    }


    }


}
