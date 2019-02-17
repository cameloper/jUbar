package edu.kit.informatik;

class Operation {
    /**
     * The command entered by the user
     */
    Command command;
    /**
     * Given parameters along with the entered command
     */
    String[] parameters;

    public static Result<Operation> buildWith(String inputString) {
        return new Result(null, Error.NO_INPUT);
    }
}
