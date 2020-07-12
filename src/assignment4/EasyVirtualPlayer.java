package assignment4;

public class EasyVirtualPlayer implements VirtualPlayer{

    // returns a column number within 0...COLUMNS, -1 if board is full
    public int computerChoice(char[][] board)
    {

        for (int i = 0; i < Board.getCOLUMNS(); i++) {
            if (!Board.isColumnFull(board, i)) {
                return i;
            }
        }
        return -1;
    }
}
