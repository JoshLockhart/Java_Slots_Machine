package jl.slotsmachine;

class Wallet {
    int balance,
        numWalletVisits,
        numTimesMoneyAdded,
        totalMoneyAdded;

    Wallet(int startBalance, int startNumVisits, int startNumTimesMoneyAdded, int startTotalMoneyAdded) {
        balance = startBalance;
        numWalletVisits = startNumVisits;
        numTimesMoneyAdded = startNumTimesMoneyAdded;
        totalMoneyAdded = startTotalMoneyAdded;
    }

    void enterWallet(Wallet wallet) {
        boolean exitWallet = false;

        updateNumWalletVisitsStat(wallet);
        displayWalletWelcomeMsg();
        while (!exitWallet) {
            displayWalletMenu(wallet.balance);
            int choice = getValidWalletMenuChoice(wallet.balance);
            if (isYesAddMoneyChoice(choice)) {
                WalletMoney.enterWalletMoney(wallet);
            } else {
                Util.displayReturnToMainMenuMsg();
                exitWallet = true;
            }
        }
    }

        private static void updateNumWalletVisitsStat(Wallet wallet) {
            wallet.numWalletVisits++;
        }

        private static void displayWalletWelcomeMsg() {
            Util.clearScreen();
            System.out.println("Welcome to the Wallet.\n"
                             + "Here you can add money to your Wallet account.\n"
                             + "Below is the Wallet Menu.\n");
        }


        private static void displayWalletMenu(int balance) {
            Util.displayWalletBalanceMsg(balance);
            System.out.println("Would you like to add money to your Wallet?\n\n"
                             + "1.) Yes\n"
                             + "2.) No\n\n"
                             + "Type 1 or 2 and press Enter.\n");
        }

        private static int getValidWalletMenuChoice(int balance) {
            int choice = Util.getUserChoice();
            while (choice != 1 && choice != 2) {
                Util.showChoiceErrorMsg();
                displayWalletMenu(balance);
                choice = Util.getUserChoice();
            }
            return choice;
        }


        private static boolean isYesAddMoneyChoice(int choice) {
            return choice == 1;
        }
}