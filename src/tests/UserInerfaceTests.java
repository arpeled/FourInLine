//package tests;
//
//import assignment4.Board;
//import assignment4.ConsoleUI;
//import assignment4.UserInterface;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class UserInerfaceTests {
//
//    @Test
//    public void printMenuTest()
//    {
//        //UserInterface userInterface;
//        //userInterface = new ConsoleUI();
//        //userInterface.printMenu();
//    }
//
//    @Test
//    public void printBoardTest()
//    {
//        int rows = Board.ROWS;
//        int columns = Board.COLUMNS;
//
//        char[][] board = new char[rows][columns];
//
//        UserInterface userInterface;
//        userInterface = new ConsoleUI();
//
//        Board.initializeBoard();
//
//        userInterface.printBoard(Board.board);
//    }
//
//    @Test
//    public void computerPlayerTurnTest()
//    {
//        UserInterface userInterface;
//        userInterface = new ConsoleUI();
//
//        userInterface.computerPlayerTurn(3);
//    }
//
//    @Test
//    public void showWinnerTest()
//    {
//        UserInterface userInterface;
//        userInterface = new ConsoleUI();
//
//        userInterface.showWinner(' ', true, 2);
//    }
//}
