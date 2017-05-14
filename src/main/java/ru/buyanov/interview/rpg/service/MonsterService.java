package ru.buyanov.interview.rpg.service;

import ru.buyanov.interview.rpg.domain.Monster;
import ru.buyanov.interview.rpg.domain.ReferenceMonster;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class MonsterService {
    private final ReferenceMonster REFERENCE_RAT = new ReferenceMonster("Rat", 2, 2, false, 5);
    private final ReferenceMonster REFERENCE_GOBLIN = new ReferenceMonster("Goblin", 3, 10, false, 10);
    private final ReferenceMonster REFERENCE_ORC = new ReferenceMonster("Orc", 5, 20, false, 15);
    private final ReferenceMonster REFERENCE_TROLL = new ReferenceMonster("Troll", 9, 35, false, 25);
    private final ReferenceMonster REFERENCE_BARLOG = new ReferenceMonster("Barlog", 20, 1000, true, 100);


    public Monster getFinalMonster() {
        return REFERENCE_BARLOG.createNew();
    }

    public Monster createRandomMonster(int percentage) {
        if (percentage < 15) {
            return REFERENCE_RAT.createNew();
        }
        if (percentage < 45) {
            return REFERENCE_GOBLIN.createNew();
        }
        if (percentage < 85) {
            return REFERENCE_ORC.createNew();
        }
        if (percentage < 99) {
            return REFERENCE_TROLL.createNew();
        }
        return REFERENCE_BARLOG.createNew();
    }
}
