package ru.buyanov.interview.rpg.service;

import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.repository.HeroRepository;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class HeroService {
    private final HeroRepository repository;

    public HeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public Hero create(String name) {
        return new Hero(name, 20, 5);
    }

    public Hero load() {
        return repository.load();
    }
}
