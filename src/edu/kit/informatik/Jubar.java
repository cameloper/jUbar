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
            input(input);
        }

//        String a = "set-vc 5;2|state 5;2|roll DAWN|reset|set-vc 5;2|roll 5|place 6;2:6;6|move 4;2:3;2|roll 5|place 2;0:2;5|move 4;2:3;2|roll DAWN|place 3;1:9;1|move 4;2|roll 3|place 5;3:5;5|move 5;2:4;2:5;2|roll 2|place 0;0:0;1|move 4;2:5;2|roll 3|place 2;6:5;6";
//        String[] commands = a.split("\\|");
//        for (String command : commands) {
//            Terminal.printLine(command);
//            input(command);
//        }

    }

    private static void input(String input) {
        Result<Operation> parsingResult = Operation.buildWith(input);

        if (!parsingResult.isSuccessful()) {
            Terminal.printError(parsingResult.error.toString());
            return;
        }

        Operation operation = parsingResult.value;
        Result<Integer> validationResult = operation.validate();

        if (!validationResult.isSuccessful()) {
            Terminal.printError(validationResult.error.toString());
            return;
        }

        Result<String> operationResult = operation.executeAndProceed();
        if (operationResult.isSuccessful()) {
            if (operationResult.value != null) {
                Terminal.printLine(operationResult.value);
            }
        } else Terminal.printError(operationResult.error.toString());
    }
}
