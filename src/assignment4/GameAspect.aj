package assignment4;

import assignment4.Board;
import java.sql.Timestamp;

public aspect GameAspect {

    pointcut BoardLoging(char[][] board) : call(void printBoard(char [][])) && args(board);

    before(char[][] board) : BoardLoging(board)
            {
                System.out.println("------------printing board----------");
                System.out.println();

                for (int i = 0; i < Board.getROWS(); i++)
                {
                    System.out.print("|");
                    for (int j = 0; j < Board.getCOLUMNS(); j++)
                        System.out.print(board[i][j] + "|");
                    System.out.println();
                }

                for (int k = 0; k < 2*Board.getROWS()+1; k++)
                    System.out.print("-");

                System.out.println();
            }

    after(char[][] board) : BoardLoging(board)
            {
                System.out.println("---------------------------------------");
            }


    pointcut HumanChoiceLoging(int playerNum) : call(int HumanPlayerTurn(int)) && args(playerNum);

    before(int playerNum) : HumanChoiceLoging(playerNum)
            {
                System.out.print("Player " + playerNum + ", choose a column: ");
                System.out.println();
            }

    after(int playerNum) : HumanChoiceLoging(playerNum)
            {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                System.out.println(timestamp + "  Player choice");
            }


    pointcut ComputerChoiceLoging(int col) : call(void ComputerPlayerTurn(int)) && args(col);

    before(int col): ComputerChoiceLoging(col)
            {
                System.out.print("Computer put a disk in column ");
                System.out.println(col + 1);
                System.out.println();
            }

    after(int col) : ComputerChoiceLoging(col)
            {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                System.out.println(timestamp + "  Computer choice");
                System.out.println();
            }
}
