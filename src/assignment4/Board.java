package assignment4;

public class Board {

    // board size
    private static int ROWS = 6;
    private static int COLUMNS = 7;
    public static char EMPTY = ' ';

    public static int getROWS(){return ROWS;}
    public static int getCOLUMNS(){return COLUMNS;}

    public static void setROWS(int rows) {ROWS=rows;}
    public static void setCOLUMNS(int columns) {COLUMNS=columns;}

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = EMPTY;
    }

    public static void printBoard(char[][] board) {
        System.out.println("Printing board:");
        System.out.println();
        for (int j = 0; j < ROWS; j++) {
            System.out.print("|");
            for (int k = 0; k < COLUMNS; k++)
                System.out.print(board[j][k] + "|");
            System.out.println();
        }
        for (int k = 0; k < 2*COLUMNS+1; k++)
            System.out.print("-");
        System.out.println();
        System.out.println();
    }

    public static boolean isColumnFull(char[][] board, int colIndex){
        for (int i = 0; i < ROWS; i++) {
            if (board[i][colIndex] == EMPTY)
                return false;
        }
        return true;
    }

    // returns the ROW index of the first empty cell in the COLUMN rowIndex. -1 if all full
    public static int firstEmptyRow(char[][] board, int colIndex) {
        for (int i = ROWS-1; i >=0; i--) {
            if (board[i][colIndex] == EMPTY) return i;
        }
        return -1;
    }

    // is the disc at board[rowIndex][colIndex] winning?
    public static boolean winningDisk(char[][] board, int rowIndex, int colIndex){
        char c = board[rowIndex][colIndex];
        int count = 1;

        // horizontal right
        for (int i=colIndex+1; i < COLUMNS; i++) {
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
        for (int i=rowIndex+1; i < ROWS; i++) {
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
            if (kol>=COLUMNS) break; // we reached the end of the board right side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol++;
        }
        if (count >= Game.WIN) return true;
        // keep counting down
        kol = colIndex-1;
        for (int i=rowIndex+1; i < ROWS; i++) {
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
        for (int i=rowIndex+1; i < ROWS; i++) {
            if (kol>=COLUMNS) break; // we reached the end of the board right side
            if (board[i][kol]==c)
                count++;
            else
                break;
            kol++;
        }
        if (count >= Game.WIN) return true; // won diagonal "\"

        return false;
    }

    public static boolean boardIsFull(char[][] board) {
        // it's enough to check top row
        for (int i=0; i<COLUMNS; i++)
            if (board[0][i]==EMPTY) return false;
        return true;
    }

}
