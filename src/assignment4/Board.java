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

    public static boolean boardIsFull(char[][] board) {
        // it's enough to check top row
        for (int i=0; i<COLUMNS; i++)
            if (board[0][i]==EMPTY) return false;
        return true;
    }

}
