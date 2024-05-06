package com.ziker0k.lesson15;

public class Archer extends Hero {

    private final Wolf wolf;

    public Archer(String name, int damage, int health) {
        super(name, damage, health);
        this.wolf = new Wolf("Bars", 7);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(this.getName() + " attack enemy " + enemy.getName() + " by arrow.");
        wolf.attackEnemy(enemy);
    }

    private class Wolf {
        private final String name;
        private final int damage;

        public Wolf(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public void attackEnemy(Enemy enemy) {
            System.out.println(name + " and " + Archer.this.getName() + " deal damage " + (damage + Archer.this.getDamage()));
            enemy.takeDamage(damage + Archer.this.getDamage());
        }
    }
}
