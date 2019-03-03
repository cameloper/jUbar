package edu.kit.informatik;

class Jubar {
    /**
     * Says whether the game shall continue or not
     */
    static boolean isListening = true;

    /**
     * First responder of our program that will handle all user input.
     *
     * @param args initial arguments. None expected
     */
    public static void main(String[] args) {
        Game.newGame();

        while (isListening) {
            String input = Terminal.readLine();
            Result<Operation> parsingResult = Operation.buildWith(input);

            if (!parsingResult.isSuccessful()) {
                Terminal.printError(parsingResult.error.toString());
                continue;
            }

            Operation operation = parsingResult.value;
            Result<Integer> validationResult = operation.validate();

            if (!validationResult.isSuccessful()) {
                Terminal.printError(validationResult.error.toString());
                continue;
            }

            Result<String> operationResult = operation.executeAndProceed();
            if (operationResult.isSuccessful()) {
                if (operationResult.value != null) {
                    Terminal.printLine(operationResult.value);
                }
            } else Terminal.printError(operationResult.error.toString());
        }
    }
}
