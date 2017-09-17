package jl.slotsmachine;

public class Main {

    public static void main(String[] args) {
        int walletBalance = 0;
        boolean keepPlaying = true;

        showWelcomeMsg();
        while (keepPlaying) {
            showMainMenu();
            int choice = getMainMenuChoice();
            if (choice == 1) {
                walletBalance = Wallet.enterWallet(walletBalance);
            } else if (choice == 2) {
                displayRules();
            } else if (choice == 3) {
                walletBalance = Play.enterPlay(walletBalance);
            } else {
                Util.clearScreen();
                System.out.println("Thanks for playing!");
                keepPlaying = false;
            }
        }
    }

        private static void showWelcomeMsg() {
            Util.clearScreen();
            System.out.println("Welcome to the Slots Machine!\nBelow is the Main Menu.");
        }

        private static void showMainMenu() {
            Util.clearScreen();
            System.out.println("  Menu\n----------\n1.) Wallet\n2.) Rules\n3.) Play\n4.) Quit\n\nType 1, 2, 3, or 4 and press Enter.\n");
        }

        private static int getMainMenuChoice() {
            int choice = Util.getUserChoice();
            choice = verifyMainMenuChoice(choice);
            return choice;
        }

        private static int verifyMainMenuChoice(int choice) {
            while (choice < 1 || choice > 4) {
                Util.showChoiceErrorMsg();
                showMainMenu();
                choice = Util.getUserChoice();
            }
            return choice;
        }

        private static void displayRules() {
            Util.clearScreen();
            System.out.println("Rules\n------------\nThree of a kind wins.\nYou may play 1, 3, or 5 lines.\nShamrocks are wild.\n");
            System.out.println("Payout\n-------------\nEach line won in a one line game pays 1:1\nEach line won in a three line game pays 2:1\nEach line won in a five line pays 3:1\n");
            System.out.println("Lines\n------------\nPlaying one line gives you the middle row running horizontally.");
            System.out.println(" | | ");
            System.out.println("x|x|x");
            System.out.println(" | | \n");
            System.out.println("Playing three lines gives you the top, middle, and bottom rows running horizontally.");
            System.out.println("x|x|x");
            System.out.println("x|x|x");
            System.out.println("x|x|x\n");
            System.out.println("Playing five lines gives you the top, middle, and bottom rows running horizontally and two rows running diagonally.");
            System.out.println("x| |x");
            System.out.println(" |x| ");
            System.out.println("x| |x\n");
            Util.pressEnterToContinue();
        }
}
