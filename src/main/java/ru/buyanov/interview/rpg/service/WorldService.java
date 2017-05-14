package ru.buyanov.interview.rpg.service;

import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.Monster;

import java.util.Random;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class WorldService {
    private final MonsterService monsterService;
    private final Random random;
    private final int chanceToEncounterMonster;

    public WorldService(MonsterService monsterService, Random random, int chanceToEncounterMonster) {
        this.monsterService = monsterService;
        this.random = random;
        this.chanceToEncounterMonster = chanceToEncounterMonster;
    }

    public Monster tryToFindAMonster(Hero hero) {
        int rnd = random.nextInt(100);
        if (rnd < chanceToEncounterMonster) {
            return monsterService.createRandomMonster(random.nextInt(100) + hero.getLevel());
        }
        return null;
    }
}
