package jl.slotsmachine;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        boolean exitProgram = false;
        Wallet wallet = new Wallet(0, 0, 0, 0);
        PlaySection playSection = new PlaySection(0, 0, 0, 0);

        displayWelcomeMsg();
        while (!exitProgram) {
            displayMainMenu(wallet.balance);
            int choice = getValidMainMenuChoice(wallet.balance);
            if (isWalletChoice(choice)) {
                wallet.enterWallet(wallet);
            } else if (isRulesChoice(choice)) {
                displayRules();
            } else if (isPlayChoice(choice)) {
                playSection.enterPlaySection(wallet, playSection);
            } else {
                displayExitMsg();
                printStatistics(wallet, playSection);
                exitProgram = true;
            }
        }
    }

        private static void displayWelcomeMsg() {
            Util.clearScreen();
            System.out.println("Author: Joshua Lockhart\n" +
                    "Project: Slots Machine (Java)\n\n" +
                    "Welcome to my Slots Machine program! Have a seat and play a few rounds!\n");
            Util.pressEnterToContinue();
        }

        private static void displayMainMenu(int balance) {
            Util.clearScreen();
            System.out.println("Below is the Main Menu. It has 4 options that you can choose from.\n"
                             + "1.) Wallet - The Wallet sections allows you to add more money to your Wallet account.\n"
                             + "2.) Rules - The Rules selection displays the rules and different payouts for each game type.\n"
                             + "3.) Play - The Play section allows you to play a game of your choosing.\n"
                             + "4.) Exit - Selecting Exit will exit the program and print a text file with statistics about your session.\n");
            Util.displayWalletBalanceMsg(balance);
            System.out.println("   Main Menu\n"
                             + "----------------\n"
                             + "1.) Wallet\n"
                             + "2.) Rules\n"
                             + "3.) Play\n"
                             + "4.) Quit\n\n"
                             + "Type 1, 2, 3, or 4 and press Enter.\n");
        }


        private static int getValidMainMenuChoice(int balance) {
            int choice = Util.getUserChoice();
            while (choice < 1 || choice > 4) {
                Util.showChoiceErrorMsg();
                displayMainMenu(balance);
                choice = Util.getUserChoice();
            }
            return choice;
        }

        private static boolean isWalletChoice(int choice) {
            return choice == 1;
        }

        private static boolean isRulesChoice(int choice) {
            return choice == 2;
        }

        private static boolean isPlayChoice(int choice) {
            return choice == 3;
        }


        private static void displayRules() {
            Util.clearScreen();
            System.out.println("   Rules\n"
                             + "------------\n"
                             + "Three of a kind wins.\n"
                             + "You may play 1, 3, or 5 lines.\n"
                             + "Shamrocks are wild.\n"
                             + "   Payout\n"
                             + "-------------\n"
                             + "Each line won in a one line game pays 1:1\n"
                             + "Each line won in a three line game pays 2:1\n"
                             + "Each line won in a five line pays 3:1\n\n"
                             + "   Lines\n"
                             + "------------\n"
                             + "Playing one line gives you the middle row running horizontally.\n"
                             + " | | \n"
                             + "x|x|x\n"
                             + " | | \n"
                             + "Playing three lines gives you the top, middle, and bottom rows running horizontally.\n"
                             + "x|x|x\n"
                             + "x|x|x\n"
                             + "x|x|x\n"
                             + "Playing five lines gives you the top, middle, and bottom rows running horizontally and two rows running diagonally.\n"
                             + "x| |x\n"
                             + " |x| \n"
                             + "x| |x\n");
            Util.pressEnterToContinue();
        }


        private static void displayExitMsg() {
            Util.clearScreen();
            System.out.println("Thanks for playing!");
        }

        private static void printStatistics(Wallet wallet, PlaySection playSection) {
            try (PrintWriter out = new PrintWriter("Slots_Machine_Statistics.txt")) {
                out.println("Total number of Wallet Visits: " + wallet.numWalletVisits
                          + "Total number of times money added to Wallet: " + wallet.numTimesMoneyAdded
                          + "Total amount of money added to Wallet: " + wallet.totalMoneyAdded
                          + "Total number of games lost: " + playSection.numGamesLost
                          + "Total number of games won: " + playSection.numGamesWon
                          + "Total amount of money won: " + playSection.totalMoneyWon);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
}
