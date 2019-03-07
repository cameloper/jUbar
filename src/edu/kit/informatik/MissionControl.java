package edu.kit.informatik;

import java.util.ArrayList;

class MissionControl extends Player {
    /**
     * Collection of {@link Bar} objects the player has
     */
    private Bar[] deck;

    /**
     * Default constructor for {@link MissionControl}
     */
    MissionControl() {
        refreshDeck();
    }

    /**
     * Gives the bar in Deck with given symbol.
     *
     * @param symbol Symbol the bar should have
     * @return The bar with given symbol if exists
     */
    Bar barWith(Symbol symbol) {
        for (Bar bar: deck) {
            if (bar.getSymbol() == symbol) {
                return bar;
            }
        }

        return null;
    }

    /**
     * Creates a new deck for the player
     */
    void refreshDeck() {
        deck = newDeck();
    }

    /**
     * Gives the closest available symbol in deck
     *
     * @param symbol Rolled dice
     * @return Closest symbol
     */
    ArrayList<Symbol> closestAvailableTo(Symbol symbol) {
        int indexOfSymbol = symbol.length() - 2;

        ArrayList<Symbol> out = new ArrayList<>();
        if (deck[indexOfSymbol].getPosition() == null) {
            out.add(deck[indexOfSymbol].getSymbol());
        } else {
            for (int i = indexOfSymbol; i < deck.length; i++) {
                if (deck[i].getPosition() == null) {
                    out.add(deck[i].getSymbol());
                    break;
                }
            }

            for (int i = indexOfSymbol; i >= 0; i--) {
                if (deck[i].getPosition() == null) {
                    out.add(deck[i].getSymbol());
                    break;
                }
            }
        }

        return out;
    }

    private static Bar[] newDeck() {
        Symbol[] symbols = Symbol.values();
        Bar[] deck = new Bar[symbols.length];
        for (int i = 0; i < symbols.length; i++) {
            deck[i] = new Bar(symbols[i]);
        }

        return deck;
    }
}
