package tests;

import assignment4.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPlayerTest {
    public static char[][] board;

    @Test
    public void computerWinnigChoiseTest()
    {
        int col = 1;

        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];

        Board.initializeBoard(board);

        // line with 3 discs
        for (int i=Board.getROWS()-1; i>2; i--) {
            board[i][col] = Game.OPLAYER;
        }

        Board.printBoard(board);

        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
        VirtualPlayer computer = virtualPlayerFactory.getVirtialPlayer(GameModes.MEDIUM);

        col = computer.computerChoice(board);

        assertTrue(col == 1);

    }

    @Test
    public void computerFullBoardChoiseTest()
    {
        int rows = Board.getROWS();
        int columns = Board.getCOLUMNS();

        board = new char[rows][columns];

        Board.initializeBoard(board);

        // fill the board with 'X'
        for (int i=0; i<Board.getROWS(); i++) {
            for (int j=0; j<Board.getCOLUMNS(); j++) {
                board[i][j] = Game.XPLAYER;
            }
        }

        Board.printBoard(board);

        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
        VirtualPlayer computer = virtualPlayerFactory.getVirtialPlayer(GameModes.MEDIUM);

        int computerChoice = computer.computerChoice(board);

        // expect invalid column
        assertTrue(computerChoice == -1);

    }

}
