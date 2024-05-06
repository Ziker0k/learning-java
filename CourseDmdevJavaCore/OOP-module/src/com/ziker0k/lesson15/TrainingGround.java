package com.ziker0k.lesson15;

public class TrainingGround {
    public static void main(String[] args) {
        Hero warrior = new Warrior("Sam", 5, 10);
        Hero mage = new Mage("Bob", 2, 10);
        Hero archer = new Archer("Tom", 1, 10);

        Enemy giant = new Enemy("Giant", 50);

        attackEnemy(giant, warrior, mage, archer);
    }

    public static void attackEnemy(Enemy enemy, Hero... heroes) {
        while (enemy.isAlive()) {
            for (Hero hero : heroes) {
                if (enemy.isAlive())
                    hero.attackEnemy(enemy);
            }
        }
    }
}
