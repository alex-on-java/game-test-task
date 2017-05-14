package ru.buyanov.interview.rpg.domain;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class Hero extends GameCharacter{
    public static final int EXPERIENCE_POINTS_PER_LEVEL = 50;
    private int experiencePoints;
    private int level;

    public Hero(String name, int initialHealthPoints, int damagePoints) {
        super(name, initialHealthPoints, damagePoints);
    }

    public Hero(HeroState state) {
        super(state.name, state.initialHealthPoints, state.damagePoints);
        this.experiencePoints = state.experiencePoints;
        this.level = state.level;
        this.healthPoints = state.healthPoints;
    }

    public HeroState getCurrentState() {
        return new HeroState(name, experiencePoints, level, initialHealthPoints, healthPoints, damagePoints);
    }

    public void gainExperiencePoints(int points) {
        if (points > 0) {
            experiencePoints += points;
        }
        while (experiencePoints / EXPERIENCE_POINTS_PER_LEVEL > level) {
            level++;
            healthPoints = getMaximumHealthPoints();
        }
    }

    public int getMaximumHealthPoints() {
        return initialHealthPoints * (level + 1);
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public int getDamagePoints() {
        return damagePoints * (level + 1);
    }

    public int getLevel() {
        return level;
    }
}
