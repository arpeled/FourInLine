package assignment4;

import java.util.Scanner;

public class Game {

    // first index is row (horizontal), second is column (vertical)
    // [0,0] is the top left board cell
    public static char[][] board = new char[Board.ROWS][Board.COLUMNS];

    // how many discs to win
    public static int WIN = 4;
    // the discs
    public static char XPLAYER = 'X';
    public static char OPLAYER = 'O';
    public static char EMPTY = ' ';

    public static char currentPlayer; // XPLAYER or OPLAYER
    public static boolean gameover = false;
    public static boolean computerplays = false;

    // 'O' is player 1, 'X' is player 2
    public static int playerNum (char c)
    {
        if (c == XPLAYER) {
            return 2;
        }
        else
        {
            return 1;
        }
    }

    public static void changePlayer() {
        if (currentPlayer == OPLAYER)
            currentPlayer = XPLAYER;
        else currentPlayer = OPLAYER;
    }

    public static void showWinner(char winner,boolean isComp) {
        if (winner == EMPTY)
            System.out.print("Board is full! game has ended with a tie!");
        else
        if (isComp && playerNum(winner)==2) System.out.println("Game has ended! The computer won!");
        else System.out.println("Game has ended! Player " + playerNum(winner) + " won!");
        System.out.println();
    }

    public static void play()
    {
        Scanner terminalInput = new Scanner(System.in);

        int choice, row, col;
        boolean badchoice = true;

        // each loop is a new game
        while (true) {

            do {
                badchoice = false;
                Menu.printMenu();
                choice = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
                badchoice = choice < 0 || choice > 2;
                if (badchoice) {
                    System.out.println("Input incorrect! Please try again.");
                }
            } while (badchoice);

            // 0: quit the game
            if (choice == 0) {
                System.out.println("Bye bye!");
                terminalInput.close();
                return;
            }
            // start the game
            Board.initializeBoard(board);
            System.out.println();

            Board.printBoard(board); // empty board
            System.out.println("Starting a game of 'Four in a Line'.");

            currentPlayer = OPLAYER;
            gameover = false;
            computerplays = false;
            if (choice == 2) {
                computerplays = true;
            }

            do {
                // loop as long as the chosen column is full
                // we request the player to enter a column which is not full
                do {
                    if (computerplays && currentPlayer == XPLAYER) {
                        col = VirtualPlayer.computerChoice(board);
                        System.out.print("Computer put a disk in column ");
                        System.out.println(col + 1);
                        //System.out.println();
                    } else {
                        System.out.print("Player " + playerNum(currentPlayer) + ", choose a column: ");
                        col = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
                        col--; // the real index
                    }

                    row = -1;

                    // is this really a column number?
                    if (col < 0 || col >= Board.COLUMNS)
                        System.out.println("Illegal column number");
                    else
                        // find the row and check if winning
                        if (!Board.isColumnFull(board, col)) {
                            row = Board.firstEmptyRow(board, col);
                            System.out.println();
                        } else
                            // column is full, try again
                            System.out.println("Column is full.");

                } while (row == -1);
                // now we have a valid (row,col) cell

                board[row][col] = currentPlayer;

                // in any case we print the board
                Board.printBoard(board);

                if (Board.winningDisk(board, row, col)) {
                    gameover = true;
                    showWinner(currentPlayer, computerplays);
                } else if (Board.boardIsFull(board)) {
                    gameover = true;
                    showWinner(EMPTY, computerplays); // tie
                }
                // switch to next player
                changePlayer();

            } while (!gameover);
        }
    }
}
