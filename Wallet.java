package jl.slotsmachine;

class Wallet {

    static int enterWallet(int wBal) {
        boolean stayInWallet = true;

        showWalletWelcomeMessage();
        while (stayInWallet) {
            Util.showWalletBalanceMsg(wBal);
            showWalletMenu();
            int walletMenuChoice = getWalletMenuChoice();
            if (walletMenuChoice == 1) {
                wBal += WalletMoney.addWalletMoney(wBal);
            } else if (walletMenuChoice == 2) {
                Util.showReturnToMainMenuMsg();
                stayInWallet = false;
            }
        }
        return wBal;
    }

        private static void showWalletWelcomeMessage() {
            Util.clearScreen();
            System.out.println("You have entered the Wallet\nBelow is the Wallet Menu.");
        }

        private static void showWalletMenu() {
            System.out.println("Would you like to add money to your Wallet?\n\n1.) Yes\n2.) No\n\nType 1 or 2 and press Enter.\n\n");
        }

        private static int getWalletMenuChoice() {
            int choice = Util.getUserChoice();
            choice = verifyWalletMenuChoice(choice);
            return choice;
        }

        private static int verifyWalletMenuChoice(int choice) {
            while (choice != 1 && choice != 2) {
                Util.showChoiceErrorMsg();
                showWalletMenu();
                choice = Util.getUserChoice();
            }
            return choice;
        }
}