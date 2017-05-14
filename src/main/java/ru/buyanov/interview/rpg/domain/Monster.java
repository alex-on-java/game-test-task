package ru.buyanov.interview.rpg.domain;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class Monster extends GameCharacter{
    private final int experiencePointsReward;
    private final boolean finalMonster;

    public Monster(String name, int healthPoints, int damagePoints, int experiencePointsReward, boolean finalMonster) {
        super(name, healthPoints, damagePoints);
        this.experiencePointsReward = experiencePointsReward;
        this.finalMonster = finalMonster;
    }

    public int getExperiencePointsReward() {
        return experiencePointsReward;
    }

    public boolean isFinalMonster() {
        return finalMonster;
    }

}
