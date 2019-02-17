package edu.kit.informatik;

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
        if (inputString == null || inputString.length() == 0) {
            return new Result<>(null, Error.NO_INPUT);
        }

        String[] components = inputString.split(" ", 2);
        Command cmd = Command.initWith(components[0]);

        if (cmd == null) {
            return new Result<>(null, Error.INVALID_COMMAND);
        }

        String parameterString = "";
        if (components.length == 2) {
            parameterString = components[1];
        }

        Operation operation = new Operation(cmd, parameterString.split(":"));

        return new Result<>(operation, null);
    }

    /**
     * Validates if the parameters are in a valid format
     * @return true or false
     */
    public boolean validate() {
        return false;
    }

}
