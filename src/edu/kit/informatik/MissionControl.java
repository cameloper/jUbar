package edu.kit.informatik;

import java.util.HashMap;

public class MissionControl extends Player {
    HashMap<Symbol, Bar> firstDeck;
    HashMap<Symbol, Bar> secondDeck;

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
