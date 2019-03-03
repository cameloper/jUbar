package edu.kit.informatik;

final class Game {
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

    private Symbol lastRolledDice;
    private Symbol lastPlacedBar;

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
        phase = Phase.FIRST;
        subphase = Phase.Subphase.INIT;
    }

    /**
     * Ends the current game and creates a new one
     */
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
     * @return value of private variable Subphase
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
        Tile tile = board.getTile(target);
        if (tile == null) {
            return new Result<>(null, Error.TILE_DOES_NOT_EXIST);
        }

        if (tile.isFull()) {
            return new Result<>(null, Error.TILE_IS_FULL);
        }

        Point2D oldPosition = stone.getPosition();
        if (oldPosition != null) {
            Tile oldTile = board.getTile(oldPosition);
            if (oldTile != null) {
                oldTile.setResident(null);
            }
        }

        tile.setResident(stone);
        stone.setPosition(target);

        return new Result<>(null, null);
    }

    /**
     * Writes the current state of board into String
     *
     * @return {@code this.board} as String
     */
    Result<String> print() {
        String value = board.toString();
        if (value == null) {
            return new Result<>(null, Error.OTHER);
        }

        return new Result<>(value, null);
    }

    /**
     * Gives the current state of requested tile
     *
     * @param point Requested tile coordinations
     * @return Result with "-" for empty, "+" for MC Bars, "V" or "C" for Nature stones
     */
    Result<String> stateOf(Point2D point) {
        Tile tile = board.getTile(point);
        if (tile == null) {
            return new Result<>(null, Error.TILE_DOES_NOT_EXIST);
        }

        String value = tile.toString();
        return new Result<>(value, null);
    }

    /**
     * Changes the last rolled symbol to given symbol
     *
     * @param symbol New symbol
     * @return Result that says "OK"
     */
    Result<String> roll(Symbol symbol) {
        lastRolledDice = symbol;
        return new Result<>("OK", null);
    }
}