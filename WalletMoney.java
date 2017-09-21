package jl.slotsmachine;

class WalletMoney {

    static int addWalletMoney(int bal) {
        int amountToAdd = 0,
                addCustomAmountChoice = 5;
        boolean exitWalletMoney = false,
                amountIsFinalized;

        while (!exitWalletMoney) {
            Util.showWalletBalanceMsg(bal);
            showAddWalletMoneyMenu();
            int choice = getValidAddWalletMoneyMenuChoice();
            if (choice == addCustomAmountChoice) {
                amountToAdd = WalletCustomAmount.getValidCustomAmount();
                exitWalletMoney = true;
            } else {
                amountIsFinalized = WalletFinalization.checkIfUserWantsToFinalizeAmount(choice);
                if (amountIsFinalized) {
                    amountToAdd = setAmountToAdd(choice);
                    displayAmountAddedMsg(choice);
                }
                exitWalletMoney = true;
            }
        }
        return amountToAdd;
    }

        private static void showAddWalletMoneyMenu() {
            Util.clearScreen();
            System.out.println("How much money would you like to add to your Wallet?\n\n1.) $20\n2.) $50\n3.) $100\n4.) $500\n5.) Custom Amount\n\nType 1, 2, 3, 4, or 5 and press Enter.\n\n");
        }

        private static int getValidAddWalletMoneyMenuChoice() {
            int choice = Util.getUserChoice();
            while (choice < 1 || choice > 5) {
                Util.showChoiceErrorMsg();
                showAddWalletMoneyMenu();
                choice = Util.getUserChoice();
            }
            return choice;
        }

        private static int setAmountToAdd(int choice) {
            int amountToAdd = 0;
            if (choice == 1) {
                amountToAdd = 20;
            } else if (choice == 2) {
                amountToAdd = 50;
            } else if (choice == 3) {
                amountToAdd = 100;
            } else if (choice == 4) {
                amountToAdd = 500;
            }
            return amountToAdd;
        }

        private static void displayAmountAddedMsg(int choice) {
            String amountMsg = null;
            if (choice == 1) {
                amountMsg = "$20 ";
            } else if (choice == 2) {
                amountMsg = "$50 ";
            } else if (choice == 3) {
                amountMsg = "$100 ";
            } else if (choice == 4) {
                amountMsg = "$500 ";
            }
            Util.clearScreen();
            System.out.println(amountMsg + "has been added to your account!\nYou will be returned to the Wallet Menu.\n");
            Util.pressEnterToContinue();
            Util.clearScreen();
        }

}
