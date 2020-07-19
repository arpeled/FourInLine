package assignment4;

public class Game {

    // first index is row (horizontal), second is column (vertical)
    // [0,0] is the top left board cell
    public static char[][] board;

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

    // is the disc at board[rowIndex][colIndex] winning?
    public static boolean winningDisk(char[][] board, int rowIndex, int colIndex){
        char c = board[rowIndex][colIndex];
        int count = 1;

        // horizontal right
        for (int i=colIndex+1; i < Board.getCOLUMNS(); i++) {
            if (board[rowIndex][i]==c)
                count++;
            else break;
        }
        if (count >= Game.WIN)
        {
            return true; // won horizontally
        }
        // keep counting horizontal left
        for (int i=colIndex-1; i >=0; i--) {
            if (board[rowIndex][i]==c)
                count++;
            else break;
        }
        if (count >= Game.WIN) return true; // won horizontally

        count = 1;
        // vertical down
        for (int i=rowIndex+1; i < Board.getROWS(); i++) {
            if (board[i][colIndex]==c)
                count++;
            else break;
        }
        if (count >= Game.WIN) return true; // won vertical
        // keep counting vertical up
        for (int i=rowIndex-1; i >=0; i--) {
            if (board[i][colIndex]==c)
                count++;
            else
                break;
        }
        if (count >= Game.WIN) return true; // won vertical

        // first diagonal:  /
        count = 1;
        // up
        int kol = colIndex+1;
        for (int i=rowIndex-1; i >= 0; i--) {
            if (kol>=Board.getCOLUMNS()) break; // we reached the end of the board right side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol++;
        }
        if (count >= Game.WIN) return true;
        // keep counting down
        kol = colIndex-1;
        for (int i=rowIndex+1; i < Board.getROWS(); i++) {
            if (kol<0) break; // we reached the end of the board left side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol--;
        }
        if (count >= Game.WIN) return true; // won diagonal "/"

        // second diagonal : \
        count = 1;
        // up
        kol = colIndex-1;
        for (int i=rowIndex-1; i >= 0; i--) {
            if (kol<0) break; // we reached the end of the board left side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol--;
        }
        if (count >= Game.WIN) return true; // won diagonal "\"
        // keep counting down
        kol = colIndex+1;
        for (int i=rowIndex+1; i < Board.getROWS(); i++) {
            if (kol>=Board.getCOLUMNS()) break; // we reached the end of the board right side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol++;
        }
        if (count >= Game.WIN) return true; // won diagonal "\"

        return false;
    }

    public static void play()
    {
        UserInterface userInterface = new ConsoleUI();

        int choice, row, col = 0;

        // each loop is a new game
        while (true) {

            choice = userInterface.printMenu();

            // 0: quit the game
            if (choice == MenuOptions.Exit.ordinal()) {
                userInterface.exit();
                return;
            }

            //Board.setROWS(4);    // optional
            //Board.setCOLUMNS(4); // optional

            int rows = Board.getROWS();
            int columns = Board.getCOLUMNS();

            board = new char[rows][columns];

            // start the game
            Board.initializeBoard(board);
            System.out.println();

            userInterface.printBoard(board); // empty board
            System.out.println("Starting a game of 'Four in a Line'.");

            currentPlayer = OPLAYER;
            gameover = false;
            computerplays = false;

            Player computer = null;

            if (choice == 2) {
                computerplays = true;
                VirtualPlayerFactory virtualPlayerFactory = new VirtualPlayerFactory();
                GameModes mode = GameModes.MEDIUM;
                computer = virtualPlayerFactory.getVirtialPlayer(mode);
                computer = (Player) DebugProxy.newInstance(new ComputerPlayerMedium());
            }

            do {
                // loop as long as the chosen column is full
                // we request the player to enter a column which is not full
                do {
                    if (computerplays && currentPlayer == XPLAYER) {
                        col = computer.MakeAChoise(board);
                        userInterface.computerPlayerTurn(col);
                    }
                    else
                    {
                        col = userInterface.humanPlayerTurn(playerNum(currentPlayer));
                        col--; // the real index
                    }

                    row = -1;

                    // is this really a column number?
                    if (col < 0 || col >= Board.getCOLUMNS()) {
                        System.out.println("Illegal column number");
                    }
                    else {
                        // find the row and check if winning
                        if (!Board.isColumnFull(board, col)) {
                            row = Board.firstEmptyRow(board, col);
                            System.out.println();
                        } else
                            // column is full, try again
                            System.out.println("Column is full.");
                    }
                } while (row == -1);
                // now we have a valid (row,col) cell

                board[row][col] = currentPlayer;

                // in any case we print the board
                userInterface.printBoard(board);

                if (winningDisk(board, row, col)) {
                    gameover = true;
                    userInterface.showWinner(currentPlayer, computerplays, playerNum(currentPlayer));
                } else if (Board.boardIsFull(board)) {
                    gameover = true;
                    userInterface.showWinner(EMPTY, computerplays, playerNum(EMPTY)); // tie
                }
                // switch to next player
                changePlayer();

            } while (!gameover);

            DebugProxy.close_inner_file();
        }
    }
}
