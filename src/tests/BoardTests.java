package tests;

import assignment4.Board;
import assignment4.Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTests {
    public static char[][] board;

    @Test
    public void fullColTest()
    {
        int col = 0;

        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];

        Board.initializeBoard(board);

        // fill only one row
        for (int i=0; i<Board.getROWS(); i++) {
            board[i][col] = Game.XPLAYER;
        }

        Board.printBoard(board);

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

}
