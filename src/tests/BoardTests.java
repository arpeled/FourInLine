//package tests;
//
//import assignment4.Board;
//import assignment4.ConsoleUI;
//import assignment4.Game;
//
//import assignment4.UserInterface;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BoardTests {
//    private UserInterface userInterface;
//
//    @Test
//    public void fullColTest()
//    {
//        int col = 0;
//        Board Board = new Board();
//
//        userInterface = new ConsoleUI();
//
//        Board.initializeBoard();
//
//        // fill only one row
//        for (int i=0; i<Board.ROWS; i++) {
//            Board.setBoard(i, col, Game.XPLAYER);
//        }
//
//        userInterface.printBoard(Board.board);
//
//        // is column full should return true
//        assertTrue(Board.isColumnFull(col));
//    }
//
//    @Test
//    public void initializeBoardTest()
//    {
//        Board Board = new Board();
//        boolean BoardInitSuccessfully = true;
//
//        userInterface = new ConsoleUI();
//
//        Board.initializeBoard();
//
//        char[][] board = Board.board;
//
//        // Check that board is empty
//        for (int i=0; i<Board.ROWS; i++) {
//            for (int j=0; j<Board.COLUMNS; j++) {
//                if (board[i][j] != Board.EMPTY)
//                {
//                    BoardInitSuccessfully = false;
//                }
//            }
//        }
//
//        assertTrue(BoardInitSuccessfully);
//    }
//
//    @Test
//    public void firstEmptyRowTest()
//    {
//        int col = 0;
//        Board Board = new Board();
//        userInterface = new ConsoleUI();
//
//        Board.initializeBoard();
//        char[][] board = Board.board;
//
//        // Check that board is empty
//        for (int i=Board.ROWS-1; i>4 ;i--) {
//            for (int j=0; j<Board.COLUMNS; j++) {
//                board[i][j] = Game.OPLAYER;
//            }
//        }
//        userInterface.printBoard(board);
//
//        assertEquals(4,Board.firstEmptyRow(2));
//    }
//
//    @Test
//    public void boardIsFullTest()
//    {
//        int col = 0;
//        Board Board = new Board();
//        userInterface = new ConsoleUI();
//
//        Board.initializeBoard();
//        char[][] board = Board.board;
//
//        assertFalse(Board.boardIsFull());
//
//        // Check that board is empty
//        for (int i=Board.ROWS-1; i>=0 ;i--) {
//            for (int j=Board.COLUMNS-1; j>=0; j--) {
//                board[i][j] = Game.XPLAYER;
//            }
//        }
//
//        userInterface.printBoard(board);
//
//        assertTrue(Board.boardIsFull());
//    }
//
//    @Test
//    public void setBoardSizeTest()
//    {
//        int col = 0;
//
//        int rows = 10;
//        int columns = 10;
//
//        Board Board = new Board();
//
//        Board.setColumns(columns);
//        Board.setRows(rows);
//
//        userInterface = new ConsoleUI();
//
//        Board.initializeBoard();
//
//        userInterface.printBoard(Board.board);
//
//        Board.setColumns(7);
//        Board.setRows(6);
//    }
//}
