package jl.slotsmachine;

import java.util.Scanner;

public class Wallet {

    //*************************************
    // Starts when the Wallet is entered **
    //*************************************
    public static int enterWallet(int walletBalance) {
        boolean enterWalletFinished = false;
        while (!enterWalletFinished) {
            displayWalletHeader();
            displayWalletBalance(walletBalance);
            displayAddMoneyChoices();
            int addMoneyChoice = getAddMoneyChoice();
            if (addMoneyChoice == 1) {
                walletBalance += addMoney(walletBalance);
            } else if (addMoneyChoice == 2) {
                Util.clearScreen();
                System.out.println("Returning to Main Menu...\n");
                Util.pressEnterToContinue();
                Util.clearScreen();
                enterWalletFinished = true;
            }
        }
        return walletBalance;
    }

    private static void displayWalletHeader() {
        Util.clearScreen();
        System.out.println("Wallet\n-------------");
    }

    private static void displayWalletBalance(int walletBalance) {
        System.out.println("Your current Wallet Balance is $" + walletBalance + "." + "");
    }

    private static void displayAddMoneyChoices() {
        System.out.print("Would you like to add money to your Wallet?\n1.) Yes\n2.) No\n\nType 1 or 2 and press Enter.\n\n");
    }

    private static int getAddMoneyChoice() {
        int choice = Util.getUserChoice();
        choice = verifyAddMoneyChoice(choice);
        return choice;
    }

    private static int verifyAddMoneyChoice(int choice) {
        while (choice != 1 && choice != 2) {
            Util.displayChoiceError();
            Util.pressEnterToContinue();
            Util.clearScreen();
            displayWalletHeader();
            displayAddMoneyChoices();
            choice = Util.getUserChoice();
        }
        return choice;
    }

    //*************************************************************
    // Operations when a user wants to add money to their Wallet **
    //*************************************************************
    private static int addMoney(int balance) {
        boolean addMoneyFinished = false,
                amountChoiceFinalized;
        int amountChoice,
                amountToAdd = 0;

        while (!addMoneyFinished) {
            displayAmountChoices();
            amountChoice = getAmountChoice();
            if (amountChoice == 6) {
                addMoneyFinished = true;
                Util.clearScreen();
                System.out.println("Returning to the beginning of the Wallet Menu.\n");
                Util.pressEnterToContinue();
                Util.clearScreen();
            } else if (amountChoice == 5) {
                addMoneyFinished = true;
                Util.clearScreen();
                amountToAdd = addCustomAmount();
                addCustomAmountMsg(amountToAdd);

            } else {
                    amountChoiceFinalized = finalizeAmountChoice(amountChoice);
                    if (amountChoiceFinalized) {
                        switch (amountChoice){
                            case 1: amountToAdd = setAmountToAdd(amountChoice);
                                    displayAmountAddedMsg(amountChoice);
                                    break;
                            case 2: amountToAdd = setAmountToAdd(amountChoice);
                                    displayAmountAddedMsg(amountChoice);
                                    break;
                            case 3: amountToAdd = setAmountToAdd(amountChoice);
                                    displayAmountAddedMsg(amountChoice);
                                    break;
                            case 4: amountToAdd = setAmountToAdd(amountChoice);
                                    displayAmountAddedMsg(amountChoice);
                                    break;
                        }
                        addMoneyFinished = true;
                    }
            }
        }
        return amountToAdd;
    }

    private static void displayAmountChoices() {
        Util.clearScreen();
        System.out.println("How much money would you like to add to your Wallet?\n\n1.) $20\n2.) $50\n3.) $100\n4.) $500\n5.) Custom Amount\n6.) Back to Main Wallet Menu\n\nType 1, 2, 3, 4, 5, or 6 and press Enter.\n\n");
    }

    private static int getAmountChoice() {
        int choice = Util.getUserChoice();
        choice = verifyAmountChoice(choice);
        return choice;
    }

    private static int verifyAmountChoice(int choice) {
        while (choice < 1 || choice > 6) {
            Util.displayChoiceError();
            Util.pressEnterToContinue();
            Util.clearScreen();
            displayWalletHeader();
            displayAmountChoices();
            choice = Util.getUserChoice();
        }
        return choice;
    }

    //*************************************
    //* Finalizes the choice of the user **
    //*************************************
    private static boolean finalizeAmountChoice(int amChoice) {
        boolean finalized = false;
        displayFinalizeAmountChoices(amChoice);
        int choice = Util.getUserChoice();
        choice = verifyFinalizeAmountChoice(choice);
        if (choice == 1) {
            finalized = true;
        } else if (choice == 2) {
            Util.clearScreen();
            System.out.println("You will be taken back to the Amount Selection.\nNo money has been added to your Wallet.\n");
            Util.pressEnterToContinue();
            Util.clearScreen();
        }
        return finalized;
    }

    private static void displayFinalizeAmountChoices(int amChoice) {
        String amountMsg = " 0 ";
        if (amChoice == 1) {
            amountMsg = " $20 ";
        } else if (amChoice == 2) {
            amountMsg = " $50 ";
        } else if (amChoice == 3) {
            amountMsg = " $100 ";
        } else if (amChoice == 4) {
            amountMsg = " $500 ";
        }
        Util.clearScreen();
        System.out.println("Are you sure you want to add" + amountMsg + "to your Wallet?\n\n1.) Yes\n2.) No\n\nType 1 or 2 and press Enter.\n\n");
    }

    private static int verifyFinalizeAmountChoice(int choice) {
        while (choice != 1 && choice != 2) {
            Util.displayChoiceError();
            Util.pressEnterToContinue();
            Util.clearScreen();
            displayWalletHeader();
            displayFinalizeAmountChoices(choice);
            choice = Util.getUserChoice();
        }
        return choice;
    }

    //*****************************************************************
    //* Calculates amount of money to add and the message to display **
    //*****************************************************************
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
        System.out.println(amountMsg + "has been added to your account!\nYou will be returned to the Main Wallet Menu.\n\n");
        Util.pressEnterToContinue();
        Util.clearScreen();
    }

    //****************************************************
    //* Custom Amount Operations (Case 5 of addMoney()) **
    //****************************************************
    private static int addCustomAmount() {
        displayAddCustomAmountHeader();
        int choice = Util.getUserChoice();
        choice = verifyAddCustomAmount(choice);
        return choice;
    }

    private static void displayAddCustomAmountHeader() {
        Util.clearScreen();
        System.out.println("Please enter an amount between 1 and 10,000 that you would like to add to your Wallet.\n\n");
    }

    private static int verifyAddCustomAmount(int choice) {
        while (choice < 1 || choice > 10000) {
            Util.displayChoiceError();
            Util.pressEnterToContinue();
            Util.clearScreen();
            displayAddCustomAmountHeader();
            choice = Util.getUserChoice();
        }
        return choice;
    }

    private static void addCustomAmountMsg(int customAmount) {
        Util.clearScreen();
        System.out.println("$" + customAmount + " has been added to your account!\nYou will be returned to the beginning of the Wallet Menu.\n\n");
        Util.pressEnterToContinue();
        Util.clearScreen();
    }
}
