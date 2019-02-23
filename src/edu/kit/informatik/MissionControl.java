package edu.kit.informatik;

import java.util.HashMap;

public class MissionControl extends Player {
    /**
     * Bar deck for the first phase of game
     */
    HashMap<Symbol, Bar> firstDeck;
    /**
     * Bar deck for the second phase of game
     */
    HashMap<Symbol, Bar> secondDeck;

    /**
     * Default constructor for {@link MissionControl}
     */
    MissionControl() {
        firstDeck = newDeck();
        secondDeck = newDeck();

    }

    private static HashMap<Symbol, Bar> newDeck() {
        HashMap<Symbol, Bar> deck = new HashMap<>();
        for (Symbol symbol : Symbol.values()) {
            deck.put(symbol, new Bar(symbol));
        }

        return deck;
    }
}
