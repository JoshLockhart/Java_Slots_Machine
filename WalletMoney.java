package jl.slotsmachine;

import static jl.slotsmachine.Main.showWalletBalance;
import static jl.slotsmachine.WalletCustomAmount.getCustomAmount;
import static jl.slotsmachine.WalletFinalization.finalizeAmount;


class WalletMoney {

    static int addWalletMoney(int bal) {
        boolean keepAddingMoney = true,
                amountIsFinalized;
        int amountToAdd = 0;

        while (keepAddingMoney) {
            showWalletBalance(bal);
            showAddMoneyMenu();
            int addMoneyMenuChoice = getAddMoneyMenuChoice();
            if (addMoneyMenuChoice == 5) {
                amountToAdd = getCustomAmount();
                keepAddingMoney = false;
            } else {
                amountIsFinalized = finalizeAmount(addMoneyMenuChoice);
                if (amountIsFinalized) {
                    amountToAdd = setAmountToAdd(addMoneyMenuChoice);
                    displayAmountAddedMsg(addMoneyMenuChoice);
                }
                keepAddingMoney = false;
            }
        }
        return amountToAdd;
    }

    private static void showAddMoneyMenu() {
        Util.clearScreen();
        System.out.println("How much money would you like to add to your Wallet?\n\n1.) $20\n2.) $50\n3.) $100\n4.) $500\n5.) Custom Amount\n\nType 1, 2, 3, 4, or 5 and press Enter.\n\n");
    }

    private static int getAddMoneyMenuChoice() {
        int choice = Util.getUserChoice();
        choice = verifyAddMoneyMenuChoice(choice);
        return choice;
    }

    private static int verifyAddMoneyMenuChoice(int choice) {
        while (choice < 1 || choice > 5) {
            Util.displayChoiceError();
            showAddMoneyMenu();
            choice = Util.getUserChoice();
        }
        return choice;
    }

    private static int setAmountToAdd(int amChoice) {
        int amountToAdd = 0;
        if (amChoice == 1) {
            amountToAdd = 20;
        } else if (amChoice == 2) {
            amountToAdd = 50;
        } else if (amChoice == 3) {
            amountToAdd = 100;
        } else if (amChoice == 4) {
            amountToAdd = 500;
        }
        return amountToAdd;
    }

    private static void displayAmountAddedMsg(int amChoice) {
        String amountMsg = null;
        if (amChoice == 1) {
            amountMsg = "$20 ";
        } else if (amChoice == 2) {
            amountMsg = "$50 ";
        } else if (amChoice == 3) {
            amountMsg = "$100 ";
        } else if (amChoice == 4) {
            amountMsg = "$500 ";
        }
        Util.clearScreen();
        System.out.println(amountMsg + "has been added to your account!\nYou will be returned to the Wallet Menu.\n");
        Util.pressEnterToContinue();
        Util.clearScreen();
    }

}
