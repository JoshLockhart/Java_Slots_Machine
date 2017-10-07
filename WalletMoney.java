package jl.slotsmachine;

class WalletMoney {

    static void enterWalletMoney(Wallet wallet) {
        int amountToAdd;
        boolean exitWalletMoney = false,
                amountIsFinalized;

        while (!exitWalletMoney) {

            displayAddMoneyToWalletMenu(wallet.balance);
            int choice = getValidAddMoneyToWalletMenuChoice(wallet.balance);
            if (isCustomAmountChoice(choice)) {
                amountToAdd = WalletCustomAmount.getValidCustomAmount();
                updateWalletStats(wallet,amountToAdd);
                exitWalletMoney = true;
            } else {
                amountIsFinalized = WalletFinalization.checkIfUserWantsToFinalizeAmount(choice);
                if (amountIsFinalized) {
                    amountToAdd = detmineAmountToAdd(choice);
                    displayAmountAddedMsg(amountToAdd);
                    updateWalletStats(wallet,amountToAdd);
                }
                exitWalletMoney = true;
            }
        }
    }

        private static void displayAddMoneyToWalletMenu(int balance) {
            Util.clearScreen();
            Util.displayWalletBalanceMsg(balance);
            System.out.println("How much money would you like to add to your Wallet?\n\n"
                             + "1.) $20\n"
                             + "2.) $50\n"
                             + "3.) $100\n"
                             + "4.) $500\n"
                             + "5.) Custom Amount\n\n"
                             + "Type 1, 2, 3, 4, or 5 and press Enter.\n\n");
        }

        private static int getValidAddMoneyToWalletMenuChoice(int balance) {
            int choice = Util.getUserChoice();
            while (choice < 1 || choice > 5) {
                Util.showChoiceErrorMsg();
                displayAddMoneyToWalletMenu(balance);
                choice = Util.getUserChoice();
            }
            return choice;
        }


        private static boolean isCustomAmountChoice(int choice) {
            return choice == 5;
        }

        private static void updateWalletStats(Wallet wallet, int amountToAdd) {
            wallet.balance += amountToAdd;
            wallet.totalMoneyAdded += amountToAdd;
            wallet.numTimesMoneyAdded++;
        }


        private static int detmineAmountToAdd(int choice) {
            int amountToAdd;
            if (isTwentyDollarsChoice(choice)) {
                amountToAdd = 20;
            } else if (isFiftyDollarsChoice(choice)) {
                amountToAdd = 50;
            } else if (isHundredDollarsChoice(choice)) {
                amountToAdd = 100;
            } else {
                amountToAdd = 500;
            }
            return amountToAdd;
        }

        private static void displayAmountAddedMsg(int amount) {
            Util.clearScreen();
            System.out.println("$ " + amount + "has been added to your account!\n"
                             + "You will be returned to the Wallet Menu.\n");
            Util.pressEnterToContinue();
            Util.clearScreen();
        }


    static boolean isTwentyDollarsChoice(int choice) {
        return choice == 1;
    }

    static boolean isFiftyDollarsChoice(int choice) {
        return choice == 2;
    }

    static boolean isHundredDollarsChoice(int choice) {
        return choice == 3;
    }

}
