package ru.buyanov.interview.rpg.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class MonsterServiceTest {
    MonsterService service;

    @Before
    public void startUp() {
        service = new MonsterService();
    }

    @Test
    public void testGetFinalMonster_isFinal() {
        Assert.assertTrue("MonsterService.getFinalMonster() should return final monster", service.getFinalMonster().isFinalMonster());
    }
}
