package tests;

import assignment4.Board;
import assignment4.ConsoleUI;
import assignment4.Game;

import assignment4.UserInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {
    public static char[][] board;
    private UserInterface userInterface;

    @Test
    public void fullColTest()
    {
        int col = 0;

        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];
        userInterface = new ConsoleUI();

        Board.initializeBoard(board);

        // fill only one row
        for (int i=0; i<Board.getROWS(); i++) {
            board[i][col] = Game.XPLAYER;
        }

        userInterface.printBoard(board);

        // is column full should return true
        assertTrue(Board.isColumnFull(board, col));
    }

    @Test
    public void initializeBoardTest()
    {
        boolean BoardInitSuccessfully = true;

        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];
        userInterface = new ConsoleUI();

        Board.initializeBoard(board);

        // Check that board is empty
        for (int i=0; i<Board.getROWS(); i++) {
            for (int j=0; j<Board.getCOLUMNS(); j++) {
                if (board[i][j] != Board.EMPTY)
                {
                    BoardInitSuccessfully = false;
                }
            }
        }

        assertTrue(BoardInitSuccessfully);
    }

    @Test
    public void firstEmptyRowTest()
    {
        int col = 0;

        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];
        userInterface = new ConsoleUI();

        Board.initializeBoard(board);

        // Check that board is empty
        for (int i=Board.getROWS()-1; i>4 ;i--) {
            for (int j=0; j<Board.getCOLUMNS(); j++) {
                board[i][j] = Game.OPLAYER;
            }
        }
        userInterface.printBoard(board);

        assertEquals(4,Board.firstEmptyRow(board,2));
    }

    @Test
    public void boardIsFullTest()
    {
        int col = 0;

        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];
        userInterface = new ConsoleUI();

        Board.initializeBoard(board);

        assertFalse(Board.boardIsFull(board));

        // Check that board is empty
        for (int i=Board.getROWS()-1; i>=0 ;i--) {
            for (int j=Board.getCOLUMNS()-1; j>=0; j--) {
                board[i][j] = Game.XPLAYER;
            }
        }

        userInterface.printBoard(board);

        assertTrue(Board.boardIsFull(board));
    }

    @Test
    public void setBoardSizeTest()
    {
        int col = 0;

        int rows = 10;
        int columns = 10;

        Board.setCOLUMNS(columns);
        Board.setROWS(rows);

        board = new char[rows][columns];
        userInterface = new ConsoleUI();

        Board.initializeBoard(board);

        userInterface.printBoard(board);

        Board.setCOLUMNS(7);
        Board.setROWS(6);
    }
}
