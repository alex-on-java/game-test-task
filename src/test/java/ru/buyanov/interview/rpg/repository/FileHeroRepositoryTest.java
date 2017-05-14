package ru.buyanov.interview.rpg.repository;

import org.junit.Assert;
import org.junit.Test;
import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.HeroState;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class FileHeroRepositoryTest {

    @Test
    public void test_saveAndLoad() throws IOException {
        String fileName = "file.dat";
        String folder = "folder";
        FileHeroRepository repository =  new FileHeroRepository(folder, fileName);
        HeroState expectedState = new HeroState("name", 101, 3, 20, 60, 5);
        repository.save(new Hero(expectedState));
        Hero loadedHero = repository.load();
        Assert.assertEquals(expectedState, loadedHero.getCurrentState());

        // cleanup
        Path directory = Paths.get(folder);
        for (Path file : Files.newDirectoryStream(directory)) {
            Files.delete(file);
        }
        Files.delete(directory);
    }
}
