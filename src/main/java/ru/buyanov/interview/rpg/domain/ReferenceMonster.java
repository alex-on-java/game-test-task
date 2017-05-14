package ru.buyanov.interview.rpg.domain;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class ReferenceMonster {
    protected final String name;
    protected final int damagePoints;
    protected final int experiencePointsReward;
    protected final boolean finalMonster;
    protected int healthPoints;

    public ReferenceMonster(String name, int damagePoints, int experiencePointsReward, boolean finalMonster, int healthPoints) {
        this.name = name;
        this.damagePoints = damagePoints;
        this.experiencePointsReward = experiencePointsReward;
        this.finalMonster = finalMonster;
        this.healthPoints = healthPoints;
    }

    public Monster createNew() {
        return new Monster(name, healthPoints, damagePoints, experiencePointsReward, finalMonster);
    }


}
