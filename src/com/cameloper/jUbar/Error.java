package com.cameloper.jUbar;

enum Error {
    /**
     * Something very specific happened
     */
    OTHER,
    /**
     * User did not enter anything
     */
    NO_INPUT,
    /**
     * User entered an invalid command
     */
    INVALID_COMMAND,
    /**
     * Invalid number of given parameters for the entered command
     */
    INVALID_NUMBER_OF_PARAMETERS,
    /**
     * Given parameters are not in correct format for the entered command
     */
    INVALID_PARAMETER_FORMATTING,
    /**
     * Current game ended
     */
    NO_ONGOING_GAME,
    /**
     * Invalid action for current game phase
     */
    INVALID_MOVE,
    /**
     * Given tile for placement etc. does not exist
     */
    TILE_DOES_NOT_EXIST,
    /**
     * Given tile for placement etc. is occupied
     */
    TILE_IS_FULL,
    /**
     * Given tile for movement etc. is not reachable from current tile
     */
    TILE_UNREACHABLE,
    /**
     * No direct path between head and end
     */
    NO_DIRECT_PATH,
    /**
     * Not the closest bar
     */
    INVALID_BAR,
    /**
     * Bar is out of the board etc.
     */
    INVALID_PLACEMENT,
    /**
     * Path is longer than allowed
     */
    PATH_TOO_LONG;

    @Override
    public String toString() {
        switch (this) {
            case OTHER:
                return "something happened.";
            case NO_INPUT:
                return "no input received from Terminal.";
            case INVALID_COMMAND:
                return "entered text does not refer to a valid command.";
            case INVALID_NUMBER_OF_PARAMETERS:
                return "number of given parameters are invalid for the entered command."
                        + " Number of expected parameters: &p";
            case INVALID_PARAMETER_FORMATTING:
                return "given parameters are not in correct format for the entered command.";
            case NO_ONGOING_GAME:
                return "there is no ongoing game right now. Use 'reset' command to create new one.";
            case INVALID_MOVE:
                return "the move you made is not valid for the current game phase.";
            case TILE_DOES_NOT_EXIST:
                return "tile &p doesn't exist.";
            case TILE_IS_FULL:
                return "tile &p is full.";
            case TILE_UNREACHABLE:
                return "there's no direct path to the tile &p.";
            case NO_DIRECT_PATH:
                return "there's no direct path between the two given coordinates &p.";
            case INVALID_BAR:
                return "the bar you played is not closest option to rolled dice. Bars you can play are &p.";
            case INVALID_PLACEMENT:
                return "the bar you played cannot be placed on requested coordinates.";
            case PATH_TOO_LONG:
                return "the number of steps you entered is higher than the last placed bar length."
                        + "The longest possible move is &p";
            default:
                return "something happened.";
        }
    }
}
