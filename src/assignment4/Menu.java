package assignment4;

public class Menu {

    public static void printMenu() {
        System.out.println(MenuOptions.Exit.ordinal() + ". Exit");
        System.out.println(MenuOptions.SinglePlayer.ordinal()  + ". Play against a friend");
        System.out.println(MenuOptions.MultiPlayer.ordinal()  + ". Play against the computer");
        System.out.print("Please choose an option:");
    }
}
