package edu.kit.informatik;

class Game {
    /**
     * The ongoing game object to allow keeping some states
     */
    static Game current;

    /**
     * Board status of 'this' game object
     */
    Board board;

    /**
     * Nature player of this instance
     */
    Player nature;

    /**
     * Mission control player of this instance
     */
    Player missionControl;

    /**
     * Which player is allowed to play
     */
    Player.PlayerType turn;

    /**
     * The ongoing game phase
     */
    Phase phase;

    enum Phase {
        /**
         * Game is still on the first phase, in which MC is trying to hunt Vesta alone
         */
        FIRST,
        /**
         * Game is in the second phase, Ceres is on the board as well
         */
        SECOND
    }
}
