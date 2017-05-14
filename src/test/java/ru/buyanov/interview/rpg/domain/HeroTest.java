package ru.buyanov.interview.rpg.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class HeroTest {
    @Test
    public void testGainExperiencePoints_pointsAdded() {
        Hero hero = new Hero("", 1, 1);
        assertEquals(0, hero.getExperiencePoints());
        hero.gainExperiencePoints(20);
        assertEquals(20, hero.getExperiencePoints());
    }

    @Test
    public void testGainExperiencePoints_levelIncreased() {
        Hero hero = new Hero("", 1, 1);
        assertEquals(0, hero.getLevel());
        hero.gainExperiencePoints(Hero.EXPERIENCE_POINTS_PER_LEVEL );
        assertEquals(1, hero.getLevel());
    }

    @Test
    public void testGainExperiencePoints_healthRestoredAfterLevelUp() {
        Hero hero = new Hero("", 10, 1);
        hero.causeDamage(4);
        assertEquals(6, hero.getHealthPoints());
        hero.gainExperiencePoints(Hero.EXPERIENCE_POINTS_PER_LEVEL );
        assertEquals(20, hero.getHealthPoints());
    }

    @Test
    public void testCauseDamage_overflow() {
        Hero hero = new Hero("", 10, 1);
        hero.causeDamage(1000);
        assertEquals(0, hero.getHealthPoints());
    }

    @Test
    public void testCauseDamage_negativeDamage() {
        Hero hero = new Hero("", 10, 1);
        hero.causeDamage(-1);
        assertEquals(10, hero.getHealthPoints());
    }

    @Test
    public void testCauseDamage_dead() {
        Hero hero = new Hero("", 10, 1);
        hero.causeDamage(10);
        assertFalse(hero.isAlive());
    }
}
