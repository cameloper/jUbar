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
    private Game() {
        board = new Board();
        nature = new Nature();
        missionControl = new MissionControl();
        turn = nature;
        phase = Phase.FIRST;
        subphase = Phase.Subphase.INIT;
    }

    static void newGame() {
        Game.current = new Game();
    }

    /**
     * Public getter of Nature
     *
     * @return value of private variable Nature
     */
    Nature getNature() {
        return nature;
    }

    /**
     * Getter for phase
     *
     * @return current phase
     */
    Phase getPhase() {
        return phase;
    }

    /**
     * Public getter of Subphase
     *
     * @returns value of private variable Subphase
     */
    public Phase.Subphase getSubphase() {
        return subphase;
    }

    /**
     * Switches to the next game phase
     */
    void nextPhase() {
        subphase = subphase.next();
        if (subphase == Phase.Subphase.END) {
            phase = phase.next();
            subphase = Phase.Subphase.INIT;
        }
    }

    /**
     * Places the given Stone to given coordinates
     *
     * @param stone  {@link Stone} to place
     * @param target Target tile coordinates
     * @return Empty result if successful. Otherwise Result with Error
     */
    Result<Void> place(Stone stone, Point2D target) {

        return new Result<>(null, Error.OTHER);
    }
}