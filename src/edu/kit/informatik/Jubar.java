package edu.kit.informatik;

public class Jubar {

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
        }
    }
}
