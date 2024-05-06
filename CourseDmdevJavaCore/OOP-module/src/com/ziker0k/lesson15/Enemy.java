package com.ziker0k.lesson15;

public class Enemy implements Mortal, TakeDamage {
    private final String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    @Override
    public void takeDamage(int damage) {
        if (isAlive() && health <= damage) {
            health = 0;
            System.out.println(getName() + " died.");
        } else {
            setHealth(Math.max(getHealth() - damage, 0));
            System.out.println("Enemy " + getName() + " get damage " + damage + ". Health: " + health + ".");
        }
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
