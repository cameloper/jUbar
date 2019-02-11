package edu.kit.informatik;

enum Command {
    /**
     * Prints the status of tile at given coordinates
     */
    STATE,
    /**
     * Prints the whole board
     */
    PRINT,
    /**
     * Place the Vesta or Ceres for the first time on the Board, at given coordinates
     */
    SET_VC,
    /**
     * Roll the dice
     */
    ROLL,
    /**
     * Place a bar on the board
     */
    PLACE,
    /**
     * Move the Vesta or Ceres to given coordinates, in given order
     */
    MOVE,
    /**
     * Show the game result, if it's in the {@code END} state.
     */
    SHOW_RESULT,
    /**
     * Reset the game and all states
     */
    RESET,
    /**
     * Quit the program
     */
    QUIT;

    /**
     * Converts given rawValue to Command object
     * @param rawValue String Entered input string
     * @return Command equivalent of rawValue
     */
    static Command initWith(String rawValue) {
        for (Command cmd : Command.values()) {
            if (cmd.rawValue().equals(rawValue)) {
                return cmd;
            }
        }

        return null;
    }

    /**
     * Gives the raw String value of this Command instance
     * @return String rawValue of command instance
     */
    String rawValue() {
        switch (this) {
            case STATE:
                return "state";
            case PRINT:
                return "print";
            case SET_VC:
                return "set-vc";
            case ROLL:
                return "roll";
            case PLACE:
                return "place";
            case MOVE:
                return "move";
            case SHOW_RESULT:
                return "show-result";
            case RESET:
                return "reset";
            case QUIT:
                return "quit";
            default:
                return null;
        }
    }
}
