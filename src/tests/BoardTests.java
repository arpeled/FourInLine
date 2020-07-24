package tests;

import assignment4.Board;
import assignment4.Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTests {
    public static char[][] board = new char[Board.ROWS][Board.COLUMNS];

    @Test
    public void PositiveFullColTest()
    {
        int col = 0;

        Board.initializeBoard(board);

        for (int i=0; i<Board.ROWS; i++) {
            board[i][col] = Game.XPLAYER;
        }

        Board.printBoard(board);

        assertTrue(Board.isColumnFull(board, col));

        //System.out.println("BoardTests passed successfully!");
    }

}
