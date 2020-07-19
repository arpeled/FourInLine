package tests;

import assignment4.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    public static char[][] board;
    private UserInterface userInterface;

    @Test
    public void computerFullBoardChoiseTest()
    {
        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];
        userInterface = new ConsoleUI();

        Board.initializeBoard(board);

        // fill the board with 'X'
        for (int i=0; i<Board.getROWS(); i++) {
            for (int j=0; j<Board.getCOLUMNS(); j++) {
                board[i][j] = Game.XPLAYER;
            }
        }

        userInterface.printBoard(board);

        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
        Player computer = virtualPlayerFactory.getVirtialPlayer(GameModes.MEDIUM);

        int computerChoice = computer.MakeAChoise(board);

        // expect invalid column
        assertTrue(computerChoice == -1);

    }

    @Test
    public void computerWinnigChoiseEasyTest()
    {
        int col = 1;

        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];

        Board.initializeBoard(board);
        userInterface = new ConsoleUI();

        // line with 3 discs
        for (int i=Board.getROWS()-1; i>2; i--) {
            board[i][col] = Game.OPLAYER;
        }

        userInterface.printBoard(board);

        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
        Player computer = virtualPlayerFactory.getVirtialPlayer(GameModes.EASY);

        col = computer.MakeAChoise(board);

        assertTrue(col == 1);

    }

    @Test
    public void computerWinnigChoiseMediumTest()
    {
        int col = 1;

        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];

        Board.initializeBoard(board);
        userInterface = new ConsoleUI();

        // line with 3 discs
        for (int i=Board.getROWS()-1; i>2; i--) {
            board[i][col] = Game.OPLAYER;
        }

        userInterface.printBoard(board);

        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
        Player computer = virtualPlayerFactory.getVirtialPlayer(GameModes.MEDIUM);

        col = computer.MakeAChoise(board);

        assertTrue(col == 1);

    }

}