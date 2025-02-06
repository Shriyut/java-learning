package org.example.oop;

public class PlayerEncapsulated {

    private String name;
    private int health;
    private String weapon;

    public PlayerEncapsulated(String name, int health, String weapon) {
        this.name = name;
        if (health <= 0) {
            this.health = 1;
        }else if ( health > 100) {
            this.health = 100;
        }else {
            this.health = health;
        }
        this.weapon = weapon;
    }

    public PlayerEncapsulated(String name) {
        this(name, 100, "Sword");
    }

    public void loseHealth(int damage) {
        health = health - damage;
        if ( health < 0) {
            System.out.println("Player knocked out");
        }
    }

    public int healthRemaining() {
        return health;
    }

    public void restoreHealth(int extraHealth) {
        health = health + extraHealth;
        if (health > 100) {
            System.out.println("Player restored to 100%");
            health = 100;
        }
    }
}
