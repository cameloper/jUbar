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
    Nature nature;

    /**
     * Mission control player of this instance
     */
    MissionControl missionControl;

    /**
     * Which player is allowed to play
     */
    Player turn;

    /**
     * The ongoing game phase
     */
    Phase phase;

    /**
     * The ongoing game subphase
     */
    Phase.Subphase subphase;

    /**
     * Default constructor for {@link Game}
     */
    Game() {
        board = new Board();
        nature = new Nature();
        missionControl = new MissionControl();
        turn = nature;
        phase = Phase.FIRST;
        subphase =  Phase.Subphase.I;
    }
}
