package jl.slotsmachine;

import java.util.Random;

import static jl.slotsmachine.Main.showWalletBalance;
import static jl.slotsmachine.Play.displayPullingTheLeverMsg;
import static jl.slotsmachine.Play.checkIfLineWins;

class OneLineGame {

    static int playOneLineGame(int wBal) {
        int numLinesWon = 0;
        int winningsAmount = 0;

        int betAmount = getOneLineBetAmount(wBal);
        wBal = subtractBetAmount(wBal, betAmount);
        displayPullingTheLeverMsg(wBal);
        numLinesWon = displayAndCheckOneLineGameResults();

        if (lineWon(numLinesWon)) {
            winningsAmount = getWinningsAmount(betAmount);
            wBal = addWinningsAmount(wBal, winningsAmount);
            displayWinningMessage(winningsAmount);
            showWalletBalance(wBal);
            Util.pressEnterToContinue();
        } else {
            displayLosingMessage();
            showWalletBalance(wBal);
            Util.pressEnterToContinue();
        }
        return wBal;
    }

    private static int getOneLineBetAmount(int wBal) {
        Util.clearScreen();
        showWalletBalance(wBal);
        displayOneLineBetMsg();
        int betAmount = Util.getUserChoice();
        betAmount = verifyOneLineBetAmount(wBal, betAmount);
        return betAmount;
    }

    private static int verifyOneLineBetAmount(int wBal, int betAmount) {
        while (betAmount < 1 || betAmount > wBal) {
            Util.clearScreen();
            showWalletBalance(wBal);
            System.out.println("Minimum bet allowed is $1.\nMaximum bet allowed is your current Wallet balance.\nSelect a valid amount.\n");
            Util.pressEnterToContinue();
            showWalletBalance(wBal);
            displayOneLineBetMsg();
            betAmount = Util.getUserChoice();
        }
        return betAmount;
    }

    private static void displayOneLineBetMsg() {
        System.out.println("How much would you like to bet for the one line?\n");
    }

    private static int subtractBetAmount(int wBal, int betAmount) {
        return wBal - betAmount;
    }


    private static int displayAndCheckOneLineGameResults() {
        String[] icons = {"Diamond", "Cherry", "7s", "Bar", "Shamrock"};
        int nLinesWon = 0;

        Random rand = new Random();
        int randNumOne = rand.nextInt(5);
        int randNumTwo = rand.nextInt(5);
        int randNumThree = rand.nextInt(5);
        String iconOne = icons[randNumOne];
        String iconTwo = icons[randNumTwo];
        String iconThree = icons[randNumThree];

        System.out.println(iconOne + " | " + iconTwo + " | " + iconThree + "\n");
        nLinesWon = checkIfLineWins(iconOne, iconTwo, iconThree);
        return nLinesWon;
    }

    private static boolean lineWon(int numLinesWon) {
        return numLinesWon == 1;
    }

    private static int getWinningsAmount(int betAmount) {
        return betAmount * 2;
    }

    private static int addWinningsAmount(int wBal, int winningsAmount) {
        return wBal + winningsAmount;
    }

    private static void displayWinningMessage(int winningsAmount) {
        System.out.println("Congratulation! You won for a total of $" + winningsAmount + "!\n");
        Util.pressEnterToContinue();
    }

    private static void displayLosingMessage() {
        System.out.println("Sorry...you didn't win anything. Better luck next time!\n");
        Util.pressEnterToContinue();

    }

}
