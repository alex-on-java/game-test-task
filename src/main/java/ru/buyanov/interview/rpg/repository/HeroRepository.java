package ru.buyanov.interview.rpg.repository;

import ru.buyanov.interview.rpg.domain.Hero;

/**
 * @author A.Buyanov 14.05.2017.
 */
public interface HeroRepository {
    void save(Hero hero);
    Hero load();
}
