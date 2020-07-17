package assignment4;

public class ConsoleUI implements UserInterface {

    public void printMenu() {
        System.out.println(MenuOptions.Exit.ordinal() + ". Exit");
        System.out.println(MenuOptions.SinglePlayer.ordinal()  + ". Play against a friend");
        System.out.println(MenuOptions.MultiPlayer.ordinal()  + ". Play against the computer");
        System.out.print("Please choose an option:");
    }

    public void printBoard(char[][] board) {
        System.out.println("Printing board:");
        System.out.println();
        for (int j = 0; j < Board.getROWS(); j++) {
            System.out.print("|");
            for (int k = 0; k < Board.getCOLUMNS(); k++)
                System.out.print(board[j][k] + "|");
            System.out.println();
        }
        for (int k = 0; k < 2*Board.getCOLUMNS()+1; k++)
            System.out.print("-");
        System.out.println();
        System.out.println();
    }

}
