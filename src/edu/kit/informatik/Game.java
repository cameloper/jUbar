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
}
