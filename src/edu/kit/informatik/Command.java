package edu.kit.informatik;

enum Command {
    /**
     * Prints the status of tile at given coordinates
     */
    STATE,
    /**
     * Prints the whole board
     */
    PRINT,
    /**
     * Place the Vesta or Ceres for the first time on the Board, at given coordinates
     */
    SET_VC,
    /**
     * Roll the dice
     */
    ROLL,
    /**
     * Place a bar on the board
     */
    PLACE,
    /**
     * Move the Vesta or Ceres to given coordinates, in given order
     */
    MOVE,
    /**
     * Show the game result, if it's in the {@code END} state.
     */
    SHOW_RESULT,
    /**
     * Reset the game and all states
     */
    RESET,
    /**
     * Quit the program
     */
    QUIT;
}
