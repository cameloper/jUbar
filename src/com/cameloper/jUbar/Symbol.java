package com.cameloper.jUbar;

enum Symbol {
    /**
     * Bar figure with length 2
     */
    TWO,
    /**
     * Bar figure with length 3
     */
    THREE,
    /**
     * Bar figure with length 4
     */
    FOUR,
    /**
     * Bar figure with length 5
     */
    FIVE,
    /**
     * Bar figure with length 6
     */
    SIX,
    /**
     * Bar figure with length 7
     */
    DAWN;

    /**
     * Gives the length of Symbol back
     * @return int
     */
    int length() {
        switch (this) {
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case DAWN:
                return 7;
            default:
                return -1;
        }
    }

    /**
     * Initializes new Symbol with the given length
     *
     * @param length Length of bar
     * @return new symbol object
     */
    static Symbol initWith(int length) {
        switch (length) {
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return DAWN;
            default:
                return null;
        }
    }

    /**
     * Returns a new {@link Symbol} object using the given raw String value
     * @param rawValue Input string
     * @return Referred Symbol case
     */
    static Symbol initWith(String rawValue) {
        switch (rawValue) {
            case "2":
                return TWO;
            case "3":
                return THREE;
            case "4":
                return FOUR;
            case "5":
                return FIVE;
            case "6":
                return SIX;
            case "DAWN":
                return DAWN;
            default:
                return null;
        }
    }

    /**
     * Says whether the given input String
     * is a valid Symbol or not
     * @param input Raw input string
     * @return true if {@code}input{@code} refers to a Symbol case, otherwise false
     */
    static boolean isSymbol(String input) {
        Symbol symbol = initWith(input);
        return symbol != null;
    }
}