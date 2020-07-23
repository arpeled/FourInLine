package tests;

import assignment4.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

    private UserInterface userInterface;
    public static Board boardI;

    @Test
    public void fullColTest()
    {
        int col = 0;
        boardI = new Board();

        userInterface = new ConsoleUI();

        // fill only one row
        for (int i=0; i<Board.ROWS; i++) {
            Board.board[i][col] = Game.XPLAYER;
        }

        userInterface.printBoard(Board.board);

        // is column full should return true
        assertTrue(Board.isColumnFull(col));
    }

    @Test
    public void initializeBoardTest()
    {
        boardI = new Board();
        boolean BoardInitSuccessfully = true;

        userInterface = new ConsoleUI();

        char[][] board = Board.board;

        // Check that board is empty
        for (int i=0; i<Board.ROWS; i++) {
            for (int j=0; j<Board.COLUMNS; j++) {
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
        boardI = new Board();
        userInterface = new ConsoleUI();

        // Check that board is empty
        for (int i=Board.ROWS-1; i>4 ;i--) {
            for (int j=0; j<Board.COLUMNS; j++) {
                Board.board[i][j] = Game.OPLAYER;
            }
        }

        userInterface.printBoard(Board.board);

        assertEquals(4,Board.firstEmptyRow(2));
    }

    @Test
    public void boardIsFullTest()
    {
        int col = 0;
        boardI = new Board();
        userInterface = new ConsoleUI();

        assertFalse(Board.boardIsFull());

        // Check that board is empty
        for (int i=Board.ROWS-1; i>=0 ;i--) {
            for (int j=Board.COLUMNS-1; j>=0; j--) {
                Board.board[i][j] = Game.XPLAYER;
            }
        }

        userInterface.printBoard(Board.board);

        assertTrue(Board.boardIsFull());
    }

}
