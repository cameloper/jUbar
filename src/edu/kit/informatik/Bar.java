package edu.kit.informatik;

class Bar extends Figure {
    /**
     * On-Board Position of the Bar
     */
    Vector2D position;

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
}
