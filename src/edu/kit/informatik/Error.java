package edu.kit.informatik;

enum Error {
    /**
     * User did not enter anything
     */
    NO_INPUT,
    /**
     * User entered an invalid command
     */
    INVALID_COMMAND;

    @Override
    public String toString() {
        switch (this) {
            case NO_INPUT:
                return "no input received from Terminal.";
            case INVALID_COMMAND:
                return "entered text does not refer to a valid command.";
            default:
                return "something happened.";
        }
    }
}
