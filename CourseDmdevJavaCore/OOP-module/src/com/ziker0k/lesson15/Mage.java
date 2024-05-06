package com.ziker0k.lesson15;

public class Mage extends Hero {
    public Mage(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(this.getName() + " throw the fireball into enemy " + enemy.getName() + ".");
        enemy.takeDamage(getDamage());
    }
}