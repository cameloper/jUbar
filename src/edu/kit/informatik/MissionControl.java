package edu.kit.informatik;

class MissionControl extends Player {
    /**
     * Collection of {@link Bar} objects the player has
     */
    private Bar[] deck;

    /**
     * Default constructor for {@link MissionControl}
     */
    MissionControl() {
        deck = newDeck();
    }

    /**
     * Public getter of Deck
     *
     * @return value of private variable Deck
     */
    public Bar[] getDeck() {
        return deck;
    }

    /**
     * Creates a new deck for the player
     */
    void refreshDeck() {
        deck = newDeck();
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
