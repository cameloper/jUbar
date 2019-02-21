package edu.kit.informatik;

enum Error {
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
    INVALID_PRAMETER_FORMATTING;

    @Override
    public String toString() {
        switch (this) {
            case NO_INPUT:
                return "no input received from Terminal.";
            case INVALID_COMMAND:
                return "entered text does not refer to a valid command.";
            case INVALID_NUMBEROF_PARAMETERS:
                return "number of given parameters are invalid for the entered command.";
            case INVALID_PRAMETER_FORMATTING:
                return "given parameters are not in correct format for the entered command";
            default:
                return "something happened.";
        }
    }
}
