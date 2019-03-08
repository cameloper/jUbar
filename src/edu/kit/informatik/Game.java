package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

final class Game {
    /**
     * The ongoing game object to allow keeping some states
     */
    static Game current;

    /**
     * Board status of 'this' game object
     */
    private final Board board;

    /**
     * Nature player of this instance
     */
    private final Nature nature;

    /**
     * Mission control player of this instance
     */
    private final MissionControl missionControl;

    private Symbol lastRolledDice;
    private Symbol lastPlacedBar;

    /**
     * The ongoing game phase
     */
    private Phase phase;

    private int round;

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
        round = 1;
        subphase = Phase.Subphase.INIT;
    }

    /**
     * Ends the current game and creates a new one
     */
    static void newGame() {
        Game.current = new Game();
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
    Phase.Subphase getSubphase() {
        return subphase;
    }

    /**
     * Switches to the next game phase
     */
    void nextPhase() {
        if (phase == Phase.END) return;
        subphase = subphase.next();
        if (subphase == Phase.Subphase.END) {
            round++;
            if (round == 7) {
                round = 1;
                phase = phase.next();
                if (phase == Phase.SECOND) {
                    subphase = Phase.Subphase.INIT;
                    missionControl.refreshDeck();
                }
            } else subphase = Phase.Subphase.I;
        }
    }

    private Stone currentStone() {
        switch (phase) {
            case FIRST:
                return nature.getVesta();
            case SECOND:
                return nature.getCeres();
            default:
                return null;
        }
    }

    /**
     * Places the given Stone to given coordinates
     *
     * @param target Target tile coordinates
     * @return Empty result if successful. Otherwise Result with Error
     */
    Result<Void> place(Point2D target) {
        Stone stone = currentStone();
        if (stone == null) return new Result<>(null, Error.OTHER);

        Tile tile = board.getTile(target);
        if (tile == null) return new Result<>(null, Error.TILE_DOES_NOT_EXIST, target.toString());

        if (tile.isFull()) return new Result<>(null, Error.TILE_IS_FULL, target.toString());

        Point2D oldPosition = stone.getPosition();
        if (oldPosition != null) {
            Tile oldTile = board.getTile(oldPosition);
            if (oldTile != null) oldTile.setResident(null);
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
     * @param point Requested tile coordinates
     * @return Result with "-" for empty, "+" for MC Bars, "V" or "C" for Nature stones
     */
    Result<String> stateOf(Point2D point) {
        Tile tile = board.getTile(point);
        if (tile == null) {
            return new Result<>(null, Error.TILE_DOES_NOT_EXIST, point.toString());
        }

        String value = tile.toString();
        return new Result<>(value, null);
    }

    /**
     * Changes the last rolled symbol to given symbol
     *
     * @param symbol New symbol
     * @return Result that says "OK" or not
     */
    Result<Void> roll(Symbol symbol) {
        lastRolledDice = symbol;
        return new Result<>(null, null);
    }

    /**
     * Places the appropriate Bar onto given coordinates
     *
     * @param position Vector of positions MC gave
     * @return Result that says "OK" or not
     */
    Result<Void> place(Vector2D position) {
        Point2D[] path = position.directPath();
        if (path == null) {
            return new Result<>(null, Error.NO_DIRECT_PATH, position.toString());
        }

        Symbol enteredSymbol = Symbol.initWith(path.length);

        ArrayList<Symbol> allowedSymbols = missionControl.closestAvailableTo(lastRolledDice);
        if (!allowedSymbols.contains(enteredSymbol)) {
            StringBuilder allowedSymbolsString = new StringBuilder();
            for (Symbol symbol : allowedSymbols) {
                allowedSymbolsString.append(symbol.toString());
            }
            return new Result<>(null, Error.INVALID_BAR, allowedSymbolsString.toString());
        }

        Bar bar = missionControl.barWith(enteredSymbol);
        Tile[] tiles = board.getTiles(path);

        if (Arrays.stream(tiles).noneMatch(Objects::nonNull)) return new Result<>(null, Error.BAR_OUT_OF_BOARD);

        for (Tile tile : tiles) {
            if (tile == null && enteredSymbol != Symbol.DAWN) {
                return new Result<>(null, Error.INVALID_PLACEMENT);
            } else if (tile != null && tile.isFull()) {
                return new Result<>(null, Error.TILE_IS_FULL, tile.getPosition().toString());
            }
        }

        for (Tile tile : tiles) {
            if (tile != null) tile.setResident(bar);
        }

        bar.setPosition(position);
        lastPlacedBar = enteredSymbol;

        return new Result<>(null, null);
    }

    /**
     * Moves the current game stone through the given path
     * @param steps Each step the stone has to take
     * @return Result without value
     */
    Result<Void> move(Point2D[] steps) {
        Stone stone = currentStone();
        if (stone == null) return new Result<>(null, Error.OTHER);

        if (steps.length > lastPlacedBar.length()) {
            return new Result<>(null, Error.PATH_TOO_LONG, String.valueOf(lastPlacedBar.length()));
        }

        Tile currentTile = board.getTile(stone.getPosition());
        Tile[] tiles = board.getTiles(steps);
        Tile newPosition = tiles[tiles.length - 1];

        if (!tiles[0].isNeighborOf(currentTile)) {
            return new Result<>(null, Error.TILE_UNREACHABLE, tiles[0].getPosition().toString());
        }

        if (tiles[0].isFull()) return new Result<>(null, Error.TILE_IS_FULL, tiles[0].getPosition().toString());

        for (int i = 0; i < tiles.length - 1; i++) {
            Tile tileX = tiles[i];
            Tile tileY = tiles[i + 1];
            if (!tileY.isAvailableNeighborOf(tileX)
                && !(tileY.equals(currentTile) && tileY.isNeighborOf(tileX))) {
                return new Result<>(null, Error.TILE_UNREACHABLE, tileY.getPosition().toString());
            }
        }

        currentTile.setResident(null);
        newPosition.setResident(stone);
        stone.setPosition(newPosition.getPosition());

        return new Result<>(null, null);
    }

    /**
     * Does a BFS and returns result
     *
     * @return Result with an integer
     */
    Result<Integer> showResult() {
        Point2D vestaPosition = nature.getVesta().getPosition();
        Point2D ceresPosition = nature.getCeres().getPosition();

        int fV = board.getReachablePoints(vestaPosition, Stone.Type.VESTA).length; // Playroom of vesta
        int fC = board.getReachablePoints(ceresPosition, Stone.Type.CERES).length; // Playroom of ceres

        // E = max{F (C), F (V )} + [max{F (C), F (V )} − min{F (C), F (V )}]

        int maxF = Math.max(fC, fV);
        int minF = Math.min(fC, fV);

        int result = maxF + (maxF - minF);

        return new Result<>(result, null);

    }
}