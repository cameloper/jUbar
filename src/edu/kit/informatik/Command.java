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
            assert cmd.rawValue() != null;
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
    private String rawValue() {
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

    /**
     * Gives what kind and how many parameters are expected for this command
     * @return {@link ParameterType}
     */
    ParameterType parameterType() {
        switch (this) {
            case PRINT:
            case SHOW_RESULT:
            case RESET:
            case QUIT:
                return ParameterType.NO_PARAMETER;
            case ROLL:
                return ParameterType.SYMBOL;
            case STATE:
            case SET_VC:
                return ParameterType.SINGLE_COORDINATE;
            case PLACE:
                return ParameterType.TWO_COORDINATES;
            case MOVE:
                return ParameterType.OPT_NUMBER_COORDINATES;
            default:
                return null;
        }
    }

    /**
     * Says if move is valid in given subphase
     *
     * @param subphase The subphase the command will be validated for
     * @return boolean
     */
    boolean isValidIn(Phase.Subphase subphase) {
        switch (this) {
            case SET_VC:
                return subphase == Phase.Subphase.INIT;
            case ROLL:
                return subphase == Phase.Subphase.I;
            case PLACE:
                return subphase == Phase.Subphase.II;
            case MOVE:
                return subphase == Phase.Subphase.III;
            case SHOW_RESULT:
                return subphase == Phase.Subphase.END;
            default:
                return true;
        }
    }

    enum ParameterType {
        /**
         * Command requires no parameters
         */
        NO_PARAMETER,
        /**
         * Expecting a dice symbol for this command
         */
        SYMBOL,
        /**
         * Expecting a single coordinate pair (x,y Positions)
         */
        SINGLE_COORDINATE,
        /**
         * Expecting two coordinate pairs (x,y Positions)
         */
        TWO_COORDINATES,
        /**
         * Expecting any number of coordinate pairs.
         */
        OPT_NUMBER_COORDINATES;

        /**
         * Gives the number of parameters this command requires
         * @return int number of parameters
         */
        int numberOfParams() {
            switch (this) {
                case NO_PARAMETER:
                    return 0;
                case SYMBOL:
                case SINGLE_COORDINATE:
                    return 1;
                case TWO_COORDINATES:
                    return 2;
                default:
                    return -1;
            }
        }

        /**
         * Gives whether the number of parameters
         * @return boolean
         */
        boolean numberIsOptional() {
            return this.numberOfParams() == -1;
        }

        /**
         * Checks if the given string is a coordinate
         *
         * @param input String to check
         * @return true if given string is a coordinate, otherwise false
         */
        static boolean isCoordinate(String input) {
            return input.matches("(-?[0-9]{1,2});-?([0-9]{1,2})");
        }
    }
}
