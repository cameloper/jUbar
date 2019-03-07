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

//        String a = "set-vc 5;2|roll 5|place 6;2:6;6|move 4;2:3;2|roll 5|place 2;0:2;5|move 4;2:3;2|roll DAWN|place 3;1:9;1|move 4;2|roll 3|place 5;3:5;5|move 5;2:4;2:5;2|roll 2|place 0;0:0;1|move 4;2:5;2|roll 3|place 2;6:5;6|move 4;2:3;2:4;2|print|set-vc 3;5|roll DAWN|place 0;14:0;20|move 4;5:4;4:4;3:4;2:3;2:3;3:3;4|move 4;5:4;4:4;3:3;3:3;2:3;3:3;4|roll DAWN|place 10;0:10;5|move 4;4:4;3:3;3:3;4:3;5:4;5|roll 2|place 1;13:1;14|move 3;5:3;4|roll 5|place 2;10:2;14|move 4;4:4;5:3;5|roll 5|place 3;11:3;14|move 4;5:3;5|roll 3|place 4;10:4;12|move 3;4:3;5|set-vc 5;2|roll 5|place 0;0:0;1|move 5;5:6;5";
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
