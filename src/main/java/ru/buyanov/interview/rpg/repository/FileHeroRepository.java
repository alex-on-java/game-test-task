package ru.buyanov.interview.rpg.repository;

import ru.buyanov.interview.rpg.domain.Hero;
import ru.buyanov.interview.rpg.domain.HeroState;

import java.io.*;

/**
 * @author A.Buyanov 14.05.2017.
 */
class FileHeroRepository implements HeroRepository {
    private final String folderName;
    private final String fileName;

    public FileHeroRepository(String folderName, String fileName) {
        this.folderName = folderName;
        this.fileName = fileName;
    }

    @Override
    public void save(Hero hero) {
        File dir = new File(folderName);
        if (!dir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            dir.mkdir();
        }
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(getFullPath());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(hero.getCurrentState());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Hero load() {
        try (
                FileInputStream fileInputStream = new FileInputStream(getFullPath());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                ObjectInput objectInputStream = new ObjectInputStream(bufferedInputStream)
            ) {
            HeroState heroState = (HeroState) objectInputStream.readObject();
            return new Hero(heroState);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFullPath() {
        return String.format("%s%s%s", folderName, File.separator, fileName);
    }
}
