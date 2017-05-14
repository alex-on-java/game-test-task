package ru.buyanov.interview.rpg.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.Monster;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class WorldServiceTest {
    private MonsterService monsterService;
    private Random random;

    @Before
    public void startUp() {
        random = Mockito.mock(Random.class);
        monsterService = Mockito.mock(MonsterService.class);
    }

    @Test
    public void testTryToFindAMonster_noMonsterFound() {
        int probability = 40;
        WorldService service = new WorldService(monsterService, random, probability);
        Mockito.verify(monsterService, never()).createRandomMonster(probability);
        when(random.nextInt(100)).thenReturn(probability);
        service.tryToFindAMonster(new Hero("", 0, 0));
    }

    @Test
    public void testTryToFindAMonster_monsterFound() {
        int probability = 40;
        Monster expected = new Monster("test", 0, 0, 0, false);
        WorldService service = new WorldService(monsterService, random, probability);
        when(random.nextInt(100)).thenReturn(probability - 1);
        when(monsterService.createRandomMonster(probability - 1)).thenReturn(expected);
        Monster monster = service.tryToFindAMonster(new Hero("", 0, 0));
        assertEquals("Monster should be found", expected, monster);
    }
}
