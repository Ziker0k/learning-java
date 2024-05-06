package com.ziker0k.lesson15;

public class Warrior extends Hero {
    public Warrior(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(this.getName() + " attack the enemy " + enemy.getName() + " by sword.");
        enemy.takeDamage(getDamage());
    }
}
