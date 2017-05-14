package ru.buyanov.interview.rpg.service;

import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.Monster;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class FightActor {
    public void perform(Hero hero, Monster monster) {
        while (monster.isAlive() && hero.isAlive()) {
            monster.causeDamage(hero.getDamagePoints());
            if (monster.isAlive()) {
                hero.causeDamage(monster.getDamagePoints());
            }
        }
    }
}
