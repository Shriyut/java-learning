package org.example.oop;

public class EncapsulationMain {

    public static void main(String[] args) {

        Player player = new Player();
        player.name = "Tim";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health " + player.healthRemaining());

//        player.health = 200;
        // Above line takes away control from the Player class (we have a limiter at 100 in Player class but it can be overridden from here) and can lead to bugs
        player.loseHealth(11);
        System.out.println("Remaining health " + player.healthRemaining()); // -1

        PlayerEncapsulated p = new PlayerEncapsulated("Tim", 200, "Sword");
        System.out.println("Remaining health " + p.healthRemaining()); // 100
    }
}
