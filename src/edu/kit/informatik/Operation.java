package edu.kit.informatik;

final class Operation {
    /**
     * The command entered by the user
     */
    private Command command;
    /**
     * Given parameters along with the entered command
     */
    private String[] parameters;

    private Operation(Command command, String[] parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    /**
     * Creates an {@link Operation} object from user input.
     * This method checks if the entered command is valid,
     * however it doesn't check if the entered parameters are
     * valid regarding the command.
     *
     * For that purpose, use instance method {@code validate()} instead.
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
     * @return Result with number of parameters entered
     */
    public Result<Integer> validate() {
        try {
            Command.ParameterType parameterType = command.parameterType();

            assert parameterType != null;
            if ((parameters.length != parameterType.numberOfParams())
                    && (!parameterType.numberIsOptional() || parameters.length < 2)) {
                return new Result<>(null, Error.INVALID_NUMBEROF_PARAMETERS);
            }

            for (String parameter : parameters) {
                switch (parameterType) {
                    case SINGLE_COORDINATE:
                    case TWO_COORDINATES:
                    case OPT_NUMBER_COORDINATES:
                        if (!Command.ParameterType.isCoordinate(parameter)) {
                            return new Result<>(null, Error.INVALID_PRAMETER_FORMATTING);
                        }
                        break;
                    case SYMBOL:
                        if (!Symbol.isSymbol(parameter)) {
                            return new Result<>(null, Error.INVALID_PRAMETER_FORMATTING);
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

}
