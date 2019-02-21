package edu.kit.informatik;

import java.util.ArrayList;

final class Operation {
    /**
     * The command entered by the user
     */
    Command command;
    /**
     * Given parameters along with the entered command
     */
    String[] parameters;

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
        if (command == null || parameters == null) {
            return new Result<>(null, Error.INVALID_NUMBEROF_PARAMETERS);
        }

        Command.ParameterType parameterType = command.parameterType();

        if ((parameters.length != parameterType.numberOfParams()) && (!parameterType.numberIsOptional() || parameters.length < 2)) {
                return new Result<>(null, Error.INVALID_NUMBEROF_PARAMETERS);
        }

        return new Result<>(parameters.length, null);
    }

}
