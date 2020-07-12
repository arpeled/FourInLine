package assignment4;

import assignment4.Board;

public aspect BoardAspect {

    pointcut loging(char[][] board):
            call(void printBoard(char [][])) && args(board);

    before(char[][] board) : loging(board) {
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

    after(char[][] board) : loging(board) {
                System.out.println("---------------------------------------");
            }
}
