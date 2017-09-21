package jl.slotsmachine;

class Wallet {

    static int performWallet(int wBal) {
        int addMoneyChoice = 1,
                exitWalletChoice = 2;
        boolean exitWallet = false;

        showWalletWelcomeMessage();
        while (!exitWallet) {
            Util.showWalletBalanceMsg(wBal);
            showWalletMenu();
            int choice = getValidWalletMenuChoice();
            if (choice == addMoneyChoice) {
                wBal += WalletMoney.addWalletMoney(wBal);
            } else if (choice == exitWalletChoice) {
                Util.showReturnToMainMenuMsg();
                exitWallet = true;
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

        private static int getValidWalletMenuChoice() {
            int choice = Util.getUserChoice();
            while (choice != 1 && choice != 2) {
                Util.showChoiceErrorMsg();
                showWalletMenu();
                choice = Util.getUserChoice();
            }
            return choice;
        }
}