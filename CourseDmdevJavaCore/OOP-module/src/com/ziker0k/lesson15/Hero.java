package com.ziker0k.lesson15;

public abstract class Hero {

    private final String name;
    private final int damage;
    private int health;


    public Hero(String name, int damage, int health) {
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public abstract void attackEnemy(Enemy enemy);

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    @Deprecated
    public int getHealth() {
        return health;
    }

    @Deprecated
    public void setHealth(int health) {
        this.health = health;
    }
}
