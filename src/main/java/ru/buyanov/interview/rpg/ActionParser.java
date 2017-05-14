package ru.buyanov.interview.rpg;


/**
 * @author A.Buyanov 14.05.2017.
 */
public class ActionParser {
    public Action parse(final String s) {
        return Action.getActionByCommand(s.toUpperCase());
    }
}
