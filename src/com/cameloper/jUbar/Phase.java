package com.cameloper.jUbar;

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

    /**
     * Gives the next phase of current game
     *
     * @return {@link Phase} next phase of game
     */
    Phase next() {
        if (this == FIRST) return SECOND;
        else return END;
    }

    enum Subphase {
        /**
         * Nature places Stone
         */
        INIT,
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

        /**
         * Gives the next sub phase of current phase
         *
         * @return {@link Subphase} next subphase of game
         */
        Subphase next() {
            switch (this) {
                case INIT:
                    return I;
                case I:
                    return II;
                case II:
                    return III;
                default:
                    return END;
            }
        }
    }
}