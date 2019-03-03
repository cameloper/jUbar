package edu.kit.informatik;

class Jubar {

    /**
     * First responder of our program that will handle all user input.
     *
     * @param args initial arguments. None expected
     */
    public static void main(String[] args) {
        boolean isListening = true;

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

            Result<String> operationResult = operation.execute();
            if (operationResult.isSuccessful()) {
                Terminal.printLine(operationResult.value);
            } else {
                Terminal.printError(operationResult.error.toString());
            }
        }
    }
}
