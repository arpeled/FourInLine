//package tests;
//
//import assignment4.*;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class PlayerTest {
//    public static char[][] board;
//    private UserInterface userInterface;
//
//    @Test
//    public void computerFullBoardChoiseTest()
//    {
//        int rows = Board.ROWS;
//        int columns = Board.COLUMNS;
//
//        board = new char[rows][columns];
//        userInterface = new ConsoleUI();
//
//        Board.initializeBoard();
//
//        // fill the board with 'X'
//        for (int i=0; i<Board.ROWS; i++) {
//            for (int j=0; j<Board.COLUMNS; j++) {
//                board[i][j] = Game.XPLAYER;
//            }
//        }
//
//        userInterface.printBoard(Board.board);
//
//        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
//        Player computer = virtualPlayerFactory.getVirtialPlayer(GameModes.MEDIUM);
//
//        int computerChoice = computer.MakeAChoise(board);
//
//        // expect invalid column
//        assertTrue(computerChoice == -1);
//
//    }
//
//    @Test
//    public void computerWinnigChoiseEasyTest()
//    {
//        int col = 1;
//
//        int rows = Board.ROWS;
//        int columns = Board.COLUMNS;
//
//        Board.initializeBoard();
//        userInterface = new ConsoleUI();
//
//        // line with 3 discs
//        for (int i=Board.ROWS-1; i>2; i--) {
//            board[i][col] = Game.OPLAYER;
//        }
//
//        userInterface.printBoard(board);
//
//        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
//        Player computer = virtualPlayerFactory.getVirtialPlayer(GameModes.EASY);
//
//        col = computer.MakeAChoise(board);
//
//        assertTrue(col == 1);
//
//    }
//
//    @Test
//    public void computerWinnigChoiseMediumTest()
//    {
//        int col = 1;
//
//        int rows = Board.ROWS;
//        int columns = Board.COLUMNS;
//
//        board = new char[rows][columns];
//
//        Board.initializeBoard();
//        userInterface = new ConsoleUI();
//
//        // line with 3 discs
//        for (int i=Board.ROWS-1; i>2; i--) {
//            board[i][col] = Game.OPLAYER;
//        }
//
//        userInterface.printBoard(board);
//
//        VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
//        Player computer = virtualPlayerFactory.getVirtialPlayer(GameModes.MEDIUM);
//
//        col = computer.MakeAChoise(board);
//
//        assertTrue(col == 1);
//
//    }
//
//}