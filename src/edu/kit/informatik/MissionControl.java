package edu.kit.informatik;

import java.util.HashMap;

class MissionControl extends Player {
    /**
     * Collection of {@link Bar} objects the player has
     */
    private HashMap<Symbol, Bar> deck;

    /**
     * Default constructor for {@link MissionControl}
     */
    MissionControl() {
        deck = newDeck();
    }

    /**
     * Creates a new deck for the player
     */
    public void refreshDeck() {
        deck = newDeck();
    }

    private static HashMap<Symbol, Bar> newDeck() {
        HashMap<Symbol, Bar> deck = new HashMap<>();
        for (Symbol symbol : Symbol.values()) {
            deck.put(symbol, new Bar(symbol));
        }

        return deck;
    }
}
