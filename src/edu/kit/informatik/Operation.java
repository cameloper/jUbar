package edu.kit.informatik;

import java.util.Arrays;

final class Operation {
    private static final String OK_STRING = "OK";
    /**
     * The command entered by the user
     */
    private final Command command;
    /**
     * Given parameters along with the entered command
     */
    private final String[] parameters;

    private Operation(Command command, String[] parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    /**
     * Creates an {@link Operation} object from user input.
     * This method checks if the entered command is valid,
     * however it doesn't check if the entered parameters are
     * valid regarding the command.
     * <p>
     * For that purpose, use instance method {@code validate()} instead.
     *
     * @param inputString The whole string gathered from {@code Terminal.readLine()}
     * @return {@link Result<Operation>} result of the conversion
     */
    static Result<Operation> buildWith(String inputString) {
        String stringWithoutWhiteSpaces = inputString.replaceAll(" ", "");
        if (stringWithoutWhiteSpaces.length() == 0) {
            return new Result<>(null, Error.NO_INPUT);
        }

        String[] components = inputString.split(" ", 2);
        Command cmd = Command.initWith(components[0]);

        if (cmd == null) {
            return new Result<>(null, Error.INVALID_COMMAND);
        }

        String[] parameters;
        if (components.length == 2) {
            String parameterString = components[1];
            parameters = parameterString.split(":");
        } else {
            parameters = new String[0];
        }

        Operation operation = new Operation(cmd, parameters);

        return new Result<>(operation, null);
    }

    /**
     * Validates if the parameters are in a valid format
     *
     * @return Result with number of parameters entered
     */
    Result<Integer> validate() {
        try {
            Command.ParameterType parameterType = command.parameterType();

            assert parameterType != null;
            if ((parameters.length != parameterType.numberOfParams())
                    && (!parameterType.numberIsOptional() || parameters.length < 1)) {
                return new Result<>(null, Error.INVALID_NUMBEROF_PARAMETERS);
            }

            for (String parameter : parameters) {
                switch (parameterType) {
                    case SINGLE_COORDINATE:
                    case TWO_COORDINATES:
                    case OPT_NUMBER_COORDINATES:
                        if (!Command.ParameterType.isCoordinate(parameter)) {
                            return new Result<>(null, Error.INVALID_PARAMETER_FORMATTING);
                        }
                        break;
                    case SYMBOL:
                        if (!Symbol.isSymbol(parameter)) {
                            return new Result<>(null, Error.INVALID_PARAMETER_FORMATTING);
                        }
                        break;
                    default:
                        return new Result<>(null, Error.OTHER);
                }
            }

            return new Result<>(parameters.length, null);
        } catch (NullPointerException exception) {
            return new Result<>(null, Error.INVALID_NUMBEROF_PARAMETERS);
        }
    }

    /**
     * Executes the operation with given command and parameters
     *
     * @return {@link Result<String>} with value that'll be written
     * in terminal
     */
    Result<String> executeAndProceed() {
        Result<String> result = execute();
        switch (command) {
            case SET_VC:
            case MOVE:
            case ROLL:
            case PLACE:
                if (result.isSuccessful()) {
                    Game.current.nextPhase();
                }
            default:
                break;
        }

        return result;
    }

    private Result<String> execute() {
        if (!command.isValidIn(Game.current.getSubphase())) {
            if (Game.current.getPhase() == Phase.END) {
                return new Result<>(null, Error.NO_ONGOING_GAME);
            }

            return new Result<>(null, Error.INVALID_MOVE);
        }

        switch (command) {
            case STATE:
                return state();
            case RESET:
                return resetGame();
            case PRINT:
                return printBoard();
            case SET_VC:
                return placeStone();
            case ROLL:
                return roll();
            case PLACE:
                return placeBar();
            case MOVE:
                return move();
            case QUIT:
                return quitGame();
            default:
                return new Result<>(null, Error.OTHER);
        }
    }

    private Result<String> roll() {
        if (Game.current == null) return new Result<>(null, Error.NO_ONGOING_GAME);

        Symbol symbol = Symbol.initWith(parameters[0]);
        if (symbol == null) new Result<>(null, Error.INVALID_PARAMETER_FORMATTING);

        Result<Void> result = Game.current.roll(symbol);
        if (result.isSuccessful()) return new Result<>(OK_STRING, null);
        else return new Result<>(null, Error.OTHER);
    }

    private Result<String> state() {
        if (Game.current == null) return new Result<>(null, Error.NO_ONGOING_GAME);

        try {
            Point2D targetCoordinates = Point2D.parse(parameters[0]);
            return Game.current.stateOf(targetCoordinates);
        } catch (NumberFormatException exception) {
            return new Result<>(null, Error.OTHER);
        }
    }

    private Result<String> resetGame() {
        Game.newGame();
        return new Result<>(OK_STRING, null);
    }

    private Result<String> quitGame() {
        Jubar.isListening = false;
        return new Result<>(null, null);
    }

    private Result<String> printBoard() {
        if (Game.current == null) return new Result<>(null, Error.NO_ONGOING_GAME);
        return Game.current.print();
    }

    private Result<String> placeStone() {
        if (Game.current == null) return new Result<>(null, Error.NO_ONGOING_GAME);

        try {
            Point2D targetCoordinates = Point2D.parse(parameters[0]);
            Result<Void> result = Game.current.place(targetCoordinates);
            if (result.isSuccessful()) return new Result<>(OK_STRING, null);
            else return new Result<>(null, result.error);
        } catch (NumberFormatException exception) {
            return new Result<>(null, Error.INVALID_PARAMETER_FORMATTING);
        }
    }

    private Result<String> placeBar() {
        if (Game.current == null) {
            return new Result<>(null, Error.NO_ONGOING_GAME);
        }

        try {
            Point2D head = Point2D.parse(parameters[0]);
            Point2D end = Point2D.parse(parameters[1]);
            Vector2D vector = new Vector2D(head, end);
            Result<Void> result = Game.current.place(vector);
            if (result.isSuccessful()) return new Result<>(OK_STRING, null);
            else return new Result<>(null, result.error);
        } catch (NumberFormatException exception) {
            return new Result<>(null, Error.INVALID_PARAMETER_FORMATTING);
        }
    }

    private Result<String> move() {
        if (Game.current == null) return new Result<>(null, Error.NO_ONGOING_GAME);

        try {
            Point2D[] stepCoordinates = Arrays.stream(parameters)
                    .map(Point2D::parse)
                    .toArray(Point2D[]::new);

            Result<Void> result = Game.current.move(stepCoordinates);
            if (result.isSuccessful()) return new Result<>(OK_STRING, null);
            else return new Result<>(null, result.error);
        } catch (NumberFormatException exception) {
            return new Result<>(null, Error.INVALID_PARAMETER_FORMATTING);
        }
    }
}
