package jl.slotsmachine;

public class Main {

    public static void main(String[] args) {
        boolean stopProgram = false;
        int walletBalance = 0;

        while (!stopProgram) {
            Util.displayMainMenu();
            int userMenuChoice = getUserMenuChoice();
            switch (userMenuChoice) {
                case 1: walletBalance = Wallet.enterWallet(walletBalance);
                        break;
                case 4: System.out.println("Cya nerd");
                        stopProgram = true;
                        break;
            }
        }
    }

    public static int getUserMenuChoice() {
        int choice = Util.getUserChoice();
        choice = verifyMenuChoice(choice);
        return choice;
    }

    private static int verifyMenuChoice(int choice) {
        while (choice < 1 || choice > 4) {
            Util.clearScreen();
            Util.displayChoiceError();
            Util.pressEnterToContinue();
            Util.clearScreen();
            Util.displayMainMenu();
            choice = Util.getUserChoice();
        }
        return choice;
    }

}
