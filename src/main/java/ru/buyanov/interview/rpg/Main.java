package ru.buyanov.interview.rpg;

import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.Monster;
import ru.buyanov.interview.rpg.repository.HeroRepository;
import ru.buyanov.interview.rpg.repository.RepositoryFactory;
import ru.buyanov.interview.rpg.service.*;

import java.util.Random;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class Main {
    private static boolean runLoop = true;

    public static void main(String[] args) {
        MonsterService monsterService = new MonsterService();
        WorldService worldService = new WorldService(monsterService, new Random(), 50);
        View view = new View(new SystemService(), new ActionParser());
        HeroRepository heroRepository = new RepositoryFactory().createHeroRepository();
        HeroService heroService = new HeroService(heroRepository);
        FightService fightService = new FightService(new FightActor(), view);

        Action initialAction = view.splashScreen(monsterService.getFinalMonster());
        final Hero hero;
        switch (initialAction) {
            case NEW:
                String name = view.readHeroName();
                hero = heroService.create(name);
                break;
            case LOAD:
                hero = heroService.load();
                break;
            default:
                hero = heroService.create("NoNameHero");
        }

        view.heroStats(hero);

        Monster monster = null;
        while (runLoop) {
            Action mainAction = view.getMainAction(monster);
            switch (mainAction) {
                case QUIT:
                    view.quitGame();
                    break;
                case SAVE:
                    heroRepository.save(hero);
                    view.saveGame();
                    break;
                case EXPLORE:
                    if (monster == null) {
                        monster = worldService.tryToFindAMonster(hero);
                    }
                    view.encounterMonster(monster);
                    break;
                case RUN:
                    view.runFromMonster(monster);
                    break;
                case FIGHT:
                    monster = fightService.performFight(hero, monster);
                    break;
                case INFO:
                    view.heroStats(hero);
                    if (monster != null) {
                        view.monsterInfo(monster);
                    }
                    break;
                default:
                    view.noAction();
                    break;
            }
        }
    }
}
