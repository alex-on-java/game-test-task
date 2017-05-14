package ru.buyanov.interview.rpg.service;

import ru.buyanov.interview.rpg.View;
import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.HeroState;
import ru.buyanov.interview.rpg.domain.Monster;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class FightService {
    private final FightActor actor;
    private final View view;

    public FightService(FightActor actor, View view) {
        this.actor = actor;
        this.view = view;
    }

    public Monster performFight(Hero hero, Monster monster) {
        if (monster == null)
            return null;
        HeroState beforeFight = hero.getCurrentState();
        actor.perform(hero, monster);
        HeroState afterFight = hero.getCurrentState();
        if (hero.isAlive()) {
            hero.gainExperiencePoints(monster.getExperiencePointsReward());
        }
        HeroState afterExperience = hero.getCurrentState();
        view.endOfFight(beforeFight, afterFight, afterExperience, monster);
        if (monster.isAlive())
            return monster;
        return null;
    }
}
