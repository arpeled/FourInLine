package tests;

import assignment4.*;
import org.junit.jupiter.api.Test;

public class GameTest {
    public static DecoratedBoard board;

    char currentPlayer; // XPLAYER or OPLAYER
    boolean gameover = false;

    @Test
    void playTest() {
        UserInterface userInterface = new ConsoleUI();
        userInterface = (UserInterface) DebugProxy.newInstance(new ConsoleUI());

        board = new DecoratedBoard();

        // start the game
        userInterface.printBoard(Board.board); // empty board
        System.out.println("Starting a game of 'Four in a Line'.");

        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
        VirtualPlayer computer = virtualPlayerFactory.getVirtialPlayer(GameModes.MEDIUM);

        int row = 0, col = 0;

        do {
            if (currentPlayer == Game.XPLAYER) {
                col = computer.MakeAChoise(Board.board);
                userInterface.computerPlayerTurn(col);
            } else {
                // simulate human choice
                Board.board[row][col] = Game.OPLAYER;
            }

            // in any case we print the board
            userInterface.printBoard(Board.board);

            if (Game.winningDisk(Board.board, row, col)) {
                gameover = true;
                userInterface.showWinner(currentPlayer, true, Game.playerNum(currentPlayer));
            } else if (Board.boardIsFull()) {
                gameover = true;
                userInterface.showWinner(Game.EMPTY, true, Game.playerNum(Game.EMPTY)); // tie
            }
            // switch to next player
            Game.changePlayer();

            row++;
            col++;
        } while (!gameover);

        DebugProxy.close_inner_file();

    }
}
