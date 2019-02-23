package edu.kit.informatik;

enum Phase {
    /**
     * Game is still on the first phase, in which MC is trying to hunt Vesta alone
     */
    FIRST,
    /**
     * Game is in the second phase, Ceres is on the board as well
     */
    SECOND,
    /**
     * Game did end
     */
    END;

    enum Subphase {
        /**
         * Nature rolls the dice
         */
        I,
        /**
         * MC places the bar with length that's closest to rolled symbol
         */
        II,
        /**
         * Nature moves V or C
         */
        III,
        /**
         * Phase did end
         */
        END;

        Subphase next() {
            switch (this) {
                case I:
                    return II;
                case II:
                    return III;
                case III:
                    return END;
                default:
                    return null;
            }
        }
    }
}