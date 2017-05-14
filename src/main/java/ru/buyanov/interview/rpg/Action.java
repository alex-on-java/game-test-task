package ru.buyanov.interview.rpg;

import java.util.stream.Stream;

/**
 * @author A.Buyanov 14.05.2017.
 */
public enum Action {
    NEW("N"),
    LOAD("L"),
    SAVE("S"),
    QUIT("Q"),
    EXPLORE("E"),
    FIGHT("F"),
    RUN("R"),
    INFO("I"),
    NO_ACTION("");

    private String command;

    Action(String command) {
        this.command = command;
    }

    public static Action getActionByCommand(String command) {
        return Stream.of(values()).filter(a -> a.command.equals(command)).findFirst().orElse(getDefault());
    }

    public static Action getDefault() {
        return NO_ACTION;
    }
}
