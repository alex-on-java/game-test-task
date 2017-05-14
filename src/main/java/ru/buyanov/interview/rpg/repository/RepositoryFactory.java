package ru.buyanov.interview.rpg.repository;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class RepositoryFactory {
    private static final String FOLDER_NAME = "data";
    private static final String FILE_NAME = "save.dat";

    public HeroRepository createHeroRepository() {
        return new FileHeroRepository(FOLDER_NAME, FILE_NAME);
    }
}
