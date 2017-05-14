package ru.buyanov.interview.rpg.service;

import org.junit.Before;
import org.junit.Test;
import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.Monster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class FightActorTest {
    FightActor service = new FightActor();

    @Before
    public void startUp() {
        service = new FightActor();
    }

    @Test
    public void testPerform_heroNotSufferDamageWhenKillMonsterAtFirstHit() {
        int heroDamage = 10;
        int monsterHealth = 10;
        int heroHealth = 1;
        Hero hero = new Hero("", heroHealth, heroDamage);
        Monster monster = new Monster("", monsterHealth, 100, 0, false);
        service.perform(hero, monster);
        assertEquals("Health points of hero should not change", heroHealth, hero.getHealthPoints());
        assertFalse("Monster should be dead after the fight", monster.isAlive());
    }

    @Test
    public void testPerform_monsterDoNotHitBackWhenKilled() {
        Hero hero = new Hero("", 10, 5);
        Monster monster = new Monster("", 25, 2, 0, false);
        service.perform(hero, monster);
        assertEquals(2, hero.getHealthPoints());
        assertFalse("Monster should be dead after the fight", monster.isAlive());
    }

    @Test
    public void testPerform_heroNotHittingAfterMonsterKillHim() {
        Hero hero = new Hero("", 10, 5);
        Monster monster = new Monster("", 6, 10, 0, false);
        service.perform(hero, monster);
        assertFalse("Hero should be dead after the fight", hero.isAlive());
        assertEquals(1, monster.getHealthPoints());
        assertTrue("Monster should be alive after the fight", monster.isAlive());
    }
}
