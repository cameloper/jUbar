package edu.kit.informatik;

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
    INVALID_NUMBEROF_PARAMETERS,
    /**
     * Given parameters are not in correct format for the entered command
     */
    INVALID_PARAMETER_FORMATTING,
    /**
     * Current game ended
     */
    NO_ONGOING_GAME,
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
    TILE_UNREACHABLE;

    @Override
    public String toString() {
        switch (this) {
            case OTHER:
                return "something happened.";
            case NO_INPUT:
                return "no input received from Terminal.";
            case INVALID_COMMAND:
                return "entered text does not refer to a valid command.";
            case INVALID_NUMBEROF_PARAMETERS:
                return "number of given parameters are invalid for the entered command.";
            case INVALID_PARAMETER_FORMATTING:
                return "given parameters are not in correct format for the entered command.";
            case NO_ONGOING_GAME:
                return "there is no ongoing game right now. Use 'reset' command to create new one.";
            case TILE_DOES_NOT_EXIST:
                return "such a tile doesn't exist.";
            case TILE_IS_FULL:
                return "requested target tile is full.";
            case TILE_UNREACHABLE:
                return "there's no path to the requested tile.";
            default:
                return "something happened.";
        }
    }
}
