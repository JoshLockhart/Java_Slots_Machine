package jl.slotsmachine;

import java.util.Random;

class OneLineGame {

    static int playOneLineGame(int wBal) {
        int betAmount = getOneLineBetAmount(wBal);
        wBal = subtractOneLineBetAmountFromWallet(wBal, betAmount);
        Play.displayPullingTheLeverMsg(wBal);

        int numLinesWon = displayAndCheckOneLineGameResults();
        if (lineWon(numLinesWon)) {
            int winningsAmount = getOneLineGameWinningsAmount(betAmount);
            wBal = Play.addWinningsAmountToWallet(wBal, winningsAmount);
            Play.showWinningMsg(winningsAmount);
            Util.showWalletBalanceMsg(wBal);
            Util.pressEnterToContinue();
        } else {
            Play.showLosingMsg();
            Util.showWalletBalanceMsg(wBal);
            Util.pressEnterToContinue();
        }
        return wBal;
    }

        private static int getOneLineBetAmount(int wBal) {
            Util.clearScreen();
            Util.showWalletBalanceMsg(wBal);
            displayOneLineBetMsg();
            int betAmount = Util.getUserChoice();
            betAmount = verifyOneLineBetAmount(wBal, betAmount);
            return betAmount;
        }

        private static int verifyOneLineBetAmount(int wBal, int betAmount) {
            while (betAmount < 1 || betAmount > wBal) {
                Util.clearScreen();
                Util.showWalletBalanceMsg(wBal);
                System.out.println("Minimum bet allowed is $1.\nMaximum bet allowed is your current Wallet balance.\nSelect a valid amount.\n");
                Util.pressEnterToContinue();
                Util.showWalletBalanceMsg(wBal);
                displayOneLineBetMsg();
                betAmount = Util.getUserChoice();
            }
            return betAmount;
        }

        private static void displayOneLineBetMsg() {
            System.out.println("How much would you like to bet for the one line?\n");
        }

        private static int subtractOneLineBetAmountFromWallet(int wBal, int betAmount) {
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
            nLinesWon = Play.checkIfLineWins(iconOne, iconTwo, iconThree);
            return nLinesWon;
        }

        private static boolean lineWon(int numLinesWon) {
            return numLinesWon == 1;
        }

        private static int getOneLineGameWinningsAmount(int betAmount) {
            return betAmount * 2;
        }
}
