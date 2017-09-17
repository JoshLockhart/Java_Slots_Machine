package jl.slotsmachine;

import java.util.Random;

class ThreeLineGame {

    static int playThreeLineGame(int wBal) {
        int betAmount = getThreeLineBetAmount(wBal);
        wBal = subtractThreeLineBetAmountFromWallet(wBal, betAmount);
        Play.displayPullingTheLeverMsg(wBal);

        int numLinesWon = displayAndCheckThreeLineGameResults();
        if (lineWon(numLinesWon)) {
            int winningsAmount = getThreeLineGameWinningsAmount(betAmount, numLinesWon);
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

        private static int getThreeLineBetAmount(int wBal) {
            Util.clearScreen();
            Util.showWalletBalanceMsg(wBal);
            displayThreeLineBetMsg();
            int betAmount = Util.getUserChoice();
            betAmount = verifyThreeLineBetAmount(wBal, betAmount);
            return betAmount;
        }

        private static int verifyThreeLineBetAmount(int wBal, int betAmount) {
            while (betAmount < 1 || (betAmount * 3) > wBal) {
                Util.clearScreen();
                Util.showWalletBalanceMsg(wBal);
                System.out.println("Minimum bet allowed is $1.\nMaximum bet cannot exceed 1/3 of your Wallet balance.\nSelect a valid amount.\n");
                displayThreeLineBetMsg();
                betAmount = Util.getUserChoice();
            }
            return betAmount;
        }

        private static void displayThreeLineBetMsg() {
            System.out.println("How much would you like to bet for each of the three lines?\n");
        }

        private static int subtractThreeLineBetAmountFromWallet(int wBal, int betAmount) {
            return wBal - betAmount;
        }


        private static int displayAndCheckThreeLineGameResults() {
            int nLinesWon = 0;
            String[] icons = {"Diamond", "Cherry", "7s", "Bar", "Shamrock"};
            Random rand = new Random();
            int randNumOne = rand.nextInt(5);
            int randNumTwo = rand.nextInt(5);
            int randNumThree = rand.nextInt(5);
            int randNumFour = rand.nextInt(5);
            int randNumFive = rand.nextInt(5);
            int randNumSix = rand.nextInt(5);
            int randNumSeven = rand.nextInt(5);
            int randNumEight = rand.nextInt(5);
            int randNumNine = rand.nextInt(5);

            String iconOne = icons[randNumOne];
            String iconTwo = icons[randNumTwo];
            String iconThree = icons[randNumThree];
            String iconFour = icons[randNumFour];
            String iconFive = icons[randNumFive];
            String iconSix = icons[randNumSix];
            String iconSeven = icons[randNumSeven];
            String iconEight = icons[randNumEight];
            String iconNine = icons[randNumNine];

            String secondLineResults = iconFour + " | " + iconFive + " | " + iconSix + "\n";
            String firstLineResults = iconOne + " | " + iconTwo + " | " + iconThree + "\n";
            String thirdLineResults = iconSeven + " | " + iconEight + " | " + iconNine + "\n";
            System.out.println(secondLineResults);
            System.out.println(firstLineResults);
            System.out.println(thirdLineResults);

            nLinesWon += Play.checkIfLineWins(iconFour, iconFive, iconSix);
            nLinesWon += Play.checkIfLineWins(iconOne, iconTwo, iconThree);
            nLinesWon += Play.checkIfLineWins(iconSeven, iconEight, iconNine);

            return nLinesWon;
        }

        private static boolean lineWon(int numLinesWon) {
            return numLinesWon >= 1;
        }

        private static int getThreeLineGameWinningsAmount(int betAmount, int numLinesWon) {
            int winningsAmount = 0;
            if (numLinesWon == 1) {
                winningsAmount = betAmount * 3;
            } else if (numLinesWon == 2) {
                winningsAmount = betAmount * 6;
            } else if (numLinesWon == 3) {
                winningsAmount = betAmount * 9;
            }
            return winningsAmount;
        }
}
