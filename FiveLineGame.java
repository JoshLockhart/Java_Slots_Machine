package jl.slotsmachine;

import java.util.Random;

class FiveLineGame {

    static int playFiveLineGame(int wBal) {
        int betAmount = getFiveLineBetAmount(wBal);
        wBal = subtractFiveLineBetAmountFromWallet(wBal, betAmount);
        Play.displayPullingTheLeverMsg(wBal);

        int numLinesWon = displayAndCheckFiveLineGameResults();
        if (lineWon(numLinesWon)) {
            int winningsAmount = getFiveLineGameWinningsAmount(betAmount, numLinesWon);
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

        private static int getFiveLineBetAmount(int wBal) {
            Util.clearScreen();
            Util.showWalletBalanceMsg(wBal);
            displayFiveLineBetMsg();
            int betAmount = Util.getUserChoice();
            betAmount = verifyFiveLineBetAmount(wBal, betAmount);
            return betAmount;
        }

        private static int verifyFiveLineBetAmount(int wBal, int betAmount) {
            while (betAmount < 1 || (betAmount * 5) > wBal) {
                Util.clearScreen();
                Util.showWalletBalanceMsg(wBal);
                System.out.println("Minimum bet allowed is $1.\nMaximum bet cannot exceed 1/5 of your Wallet balance.\nSelect a valid amount.\n");
                displayFiveLineBetMsg();
                betAmount = Util.getUserChoice();
            }
            return betAmount;
        }

        private static void displayFiveLineBetMsg() {
            System.out.println("How much would you like to bet for each of the five lines?\n");
        }

        private static int subtractFiveLineBetAmountFromWallet(int wBal, int betAmount) {
            return wBal - (betAmount * 5);
        }


        private static int displayAndCheckFiveLineGameResults() {
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

            nLinesWon += Play.checkIfLineWins(iconFour, iconTwo, iconNine);
            nLinesWon += Play.checkIfLineWins(iconSix, iconTwo, iconSeven);

            return nLinesWon;
        }

        private static boolean lineWon(int numLinesWon) {
            return numLinesWon >= 1;
        }

        private static int getFiveLineGameWinningsAmount(int betAmount, int numLinesWon) {
            int winningsAmount = 0;
            if (numLinesWon == 1) {
                winningsAmount = betAmount * 5;
            } else if (numLinesWon == 2) {
                winningsAmount = betAmount * 10;
            } else if (numLinesWon == 3) {
                winningsAmount = betAmount * 15;
            } else if (numLinesWon == 4) {
                winningsAmount = betAmount * 25;
            } else if (numLinesWon == 5) {
                winningsAmount = betAmount * 30;
            }
            return winningsAmount;
        }
}
