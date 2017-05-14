package ru.buyanov.interview.rpg;

import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.HeroState;
import ru.buyanov.interview.rpg.domain.Monster;
import ru.buyanov.interview.rpg.service.SystemService;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class View {
    private final SystemService system;
    private final ActionParser actionParser;

    public View(SystemService system, ActionParser actionParser) {
        this.system = system;
        this.actionParser = actionParser;
    }

    public Action splashScreen(Monster finalMoster) {
        system.printf("Hello! Your challenge to find and kill the %s!%n", finalMoster.getName());
        system.println("Please choose you next action: L for loading saved game and N for new game. ");
        return actionParser.parse(system.read());
    }

    public String readHeroName() {
        System.out.println("Please, enter your hero's name:");
        return system.read();
    }

    public void heroStats(Hero hero) {
        system.printf("Your hero is %s and he is %d level adventurer with %d experience points. ", hero.getName(), hero.getLevel(), hero.getExperiencePoints());
        system.printf("He is damaging for %d points per hit, and has %d/%d health points left.%n",
                hero.getDamagePoints(), hero.getHealthPoints(), hero.getMaximumHealthPoints());
    }

    public void monsterInfo(Monster monster) {
        system.printf("%s is damaging %d points per hit, and has %d health points. You will receive %d experience points for beating him%n",
                monster.getName(), monster.getDamagePoints(), monster.getHealthPoints(), monster.getExperiencePointsReward());
        if (monster.isFinalMonster()) {
            system.println("It is a final monster! If you beat him, you'll won the game!");
        }
    }

    public Action getMainAction(Monster monster) {
        if (monster != null) {
            System.out.printf("Please choose you next action: F for fight with %s, I for info or R for run away%n", monster.getName());
        }
        else {
            System.out.println("Please choose you next action: E for exploring, I for info, S for save game or Q for quit without saving");
        }
        return actionParser.parse(system.read());
    }

    public void endOfFight(HeroState beforeFight, HeroState afterFight, HeroState afterExperience, Monster monster) {
        if (afterFight.isAlive()) {
            system.printf("Fight is over, %s is killed! ", monster.getName());
            system.printf("Total damage you've done is %d points, you received %d damage points, now you have %d health points left.%n",
                    monster.getInitialHealthPoints(), beforeFight.healthPoints - afterFight.healthPoints, afterFight.healthPoints);

            system.printf("You receive %d experience points.%n", afterExperience.experiencePoints - beforeFight.experiencePoints);
            if (afterExperience.level > beforeFight.level) {
                system.printf("You've got new level, congrats! Now you are %d level adventurer.%n", afterExperience.level);
            }
            if (monster.isFinalMonster()) {
                system.exit("Your hero killed final monster, so the game is over. Thanks for playing!");
            }
        } else {
            system.exit("Your hero was killed. Game over!");
        }
    }

    public void encounterMonster(Monster monster) {
        if (monster == null) {
            system.println("You explore a bit, but find nothing");
        }
        else {
            system.printf("You encounter %s%n", monster.getName());
        }
    }

    public void runFromMonster(Monster monster) {
        if (monster != null) {
            system.printf("You ran away from %s. Trying to explore somewhere else.%n%n", monster.getName());
        }
    }

    public void quitGame() {
        system.exit("Quiting without saving.");
    }

    public void saveGame() {
        system.println("Game is saved.");
    }

    public void noAction() {
        system.println("You command has not been parsed. Please try again.");
    }
}
