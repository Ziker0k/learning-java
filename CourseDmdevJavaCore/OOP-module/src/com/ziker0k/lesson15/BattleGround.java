package com.ziker0k.lesson15;

public class BattleGround {
    public static void main(String[] args) {
        Hero gatz = new Warrior("Gatz", 20, 100);
        Enemy giant = new Enemy("Giant", 200);
        startBattle(gatz, giant);
    }

    public static void startBattle(Hero hero, Enemy enemy) {
        while (enemy.isAlive()) {
            hero.attackEnemy(enemy);
        }
    }
}
