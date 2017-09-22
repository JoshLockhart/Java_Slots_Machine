package jl.slotsmachine;

public class Main {

    public static void main(String[] args) {
        int walletBalance = 0,
                walletChoice = 1,
                rulesChoice = 2,
                playChoice = 3;
        boolean exitSlotsMachine = false;

        showWelcomeMsg();
        while (!exitSlotsMachine) {
            showMainMenu();
            int choice = getValidMainMenuChoice();
            if (choice == walletChoice) {
                walletBalance = WalletSection.performWallet(walletBalance);
            } else if (choice == playChoice) {
                walletBalance = PlaySection.performPlay(walletBalance);
            } else if (choice == rulesChoice) {
                displayRules();
            } else {
                Util.clearScreen();
                System.out.println("Thanks for playing!");
                exitSlotsMachine = true;
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

        private static int getValidMainMenuChoice() {
            int choice = Util.getUserChoice();
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
