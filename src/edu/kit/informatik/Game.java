package edu.kit.informatik;

class Game {
    /**
     * The ongoing game object to allow keeping some states
     */
    static Game current;

    /**
     * Board status of 'this' game object
     */
    private Board board;

    /**
     * Nature player of this instance
     */
    private Nature nature;

    /**
     * Mission control player of this instance
     */
    private MissionControl missionControl;

    /**
     * Which player is allowed to play
     */
    private Player turn;

    /**
     * The ongoing game phase
     */
    private Phase phase;

    /**
     * The ongoing game subphase
     */
    private Phase.Subphase subphase;

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
