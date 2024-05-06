package com.ziker0k.lesson15;

public class Archer extends Hero {
    public Archer(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(this.getName() + " attack enemy " + enemy.getName() + " by arrow.");
        enemy.takeDamage(getDamage());
    }
}
