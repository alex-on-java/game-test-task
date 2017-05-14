package ru.buyanov.interview.rpg.service;

import java.util.Scanner;

/**
 * @author A.Buyanov 14.05.2017.
 */
public class SystemService {
    private final Scanner scanner = new Scanner(System.in);


    public void exit(String message) {
        System.out.println(message);
        System.exit(0);
    }

    public void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public String read() {
        return scanner.next();
    }
}
