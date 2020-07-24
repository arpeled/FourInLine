package tests;

import assignment4.Board;
import assignment4.Game;
import assignment4.VirtualPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPlayerTest {
    public static char[][] board = new char[Board.ROWS][Board.COLUMNS];

    @Test
    public void PositiveWinnigChoise()
    {
        int col = 1;

        Board.initializeBoard(board);

        for (int i=0; i<Board.ROWS-1; i++) {
            board[i][col] = Game.XPLAYER;
        }

        Board.printBoard(board);

        col = VirtualPlayer.computerChoice(board);

        assertTrue(col == 1);

    }
}
