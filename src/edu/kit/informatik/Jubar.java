package edu.kit.informatik;

class Jubar {

    /**
     * First responder of our program that will handle all user input.
     * @param args initial arguments. None expected
     */
    public static void main(String[] args) {
        boolean isListening = true;

        while (isListening) {
            String input = Terminal.readLine();
            Result<Operation> operationResult = Operation.buildWith(input);

            if (!operationResult.isSuccessful()) {
                Terminal.printError(operationResult.error.toString());
                continue;
            }

            Operation operation = operationResult.value;
            Result<Integer> validationResult = operation.validate();

            if (!validationResult.isSuccessful()) {
                Terminal.printError(validationResult.error.toString());
                continue;
            }
        }
    }
}
