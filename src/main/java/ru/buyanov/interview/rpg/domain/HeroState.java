package ru.buyanov.interview.rpg.domain;

import java.io.Serializable;

/**
 * @author A.Buyanov 14.05.2017.
 */
public final class HeroState implements Serializable {
    static final long serialVersionUID = 42L;

    public final String name;
    public final int experiencePoints;
    public final int level;
    public final int initialHealthPoints;
    public final int healthPoints;
    public final int damagePoints;

    public HeroState(String name, int experiencePoints, int level, int initialHealthPoints, int healthPoints, int damagePoints) {
        this.name = name;
        this.experiencePoints = experiencePoints;
        this.level = level;
        this.initialHealthPoints = initialHealthPoints;
        this.healthPoints = healthPoints;
        this.damagePoints = damagePoints;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    @Override
    @SuppressWarnings("SimplifiableIfStatement")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeroState heroState = (HeroState) o;

        if (experiencePoints != heroState.experiencePoints) return false;
        if (level != heroState.level) return false;
        if (initialHealthPoints != heroState.initialHealthPoints) return false;
        if (healthPoints != heroState.healthPoints) return false;
        if (damagePoints != heroState.damagePoints) return false;
        return name != null ? name.equals(heroState.name) : heroState.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + experiencePoints;
        result = 31 * result + level;
        result = 31 * result + initialHealthPoints;
        result = 31 * result + healthPoints;
        result = 31 * result + damagePoints;
        return result;
    }
}
