package tests;

import assignment4.*;
import assignment4.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInerfaceTests {

    public static Board board;

    @Test
    public void printMenuTest()
    {
//        UserInterface userInterface;
//        userInterface = new ConsoleUI();
//        userInterface.printMenu();
    }

    @Test
    public void printBoardTest()
    {
        board = new Board();

        UserInterface userInterface;
        userInterface = new LogUI(new ConsoleUI());

        userInterface.printBoard(Board.board);

        for (int i=Board.ROWS-1; i>=0; i--)
            for(int j=Board.COLUMNS-1;j>=0;j--)
            {
                if (i==j)
                    Board.board[i][j]=Game.OPLAYER;
                else
                    Board.board[i][j]=Game.XPLAYER;

                userInterface.printBoard(Board.board);
            }

        LogUI.closeFile();
    }

    @Test
    public void computerPlayerTurnTest()
    {
        UserInterface userInterface;
        userInterface = new ConsoleUI();

        userInterface.computerPlayerTurn(3);
    }

    @Test
    public void showWinnerTest()
    {
        UserInterface userInterface;
        userInterface = new ConsoleUI();

        userInterface.showWinner(' ', true, 2);
    }
}