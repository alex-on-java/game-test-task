package ru.buyanov.interview.rpg.domain;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class GameCharacter {
    protected final String name;
    protected final int initialHealthPoints;
    protected int healthPoints;
    protected final int damagePoints;

    public GameCharacter(String name, int initialHealthPoints, int damagePoints) {
        this.name = name;
        this.damagePoints = damagePoints > 0 ? damagePoints : 1;
        this.initialHealthPoints = initialHealthPoints > 0 ? initialHealthPoints : 1;
        this.healthPoints = this.initialHealthPoints;
    }

    public void causeDamage(final int damagePoints) {
        if (damagePoints < 0) {
            return;
        }
        healthPoints -= damagePoints;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public String getName() {
        return name;
    }

    public int getInitialHealthPoints() {
        return initialHealthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }
}
