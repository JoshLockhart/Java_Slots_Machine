package jl.slotsmachine;

class GameChoice {

    static int playChosenGame(int wBal, int gChoice) {
            int bet = PlayBet.getValidBet(wBal, gChoice);

            wBal = subtractBetFromWallet(wBal, bet, gChoice);
            displayPullingTheLeverMsg(wBal);

            int numWinningLines = PlayGameResults.showAndGetGameResults(gChoice);

            if (isWinner(numWinningLines)) {
                int winningsAmount = getWinningsAmount(bet, numWinningLines, gChoice);
                wBal = addWinningsAmountToWallet(wBal, winningsAmount);
                showWinningMsg(winningsAmount);
                Util.showWalletBalanceMsg(wBal);
                Util.pressEnterToContinue();
            } else {
                showLosingMsg();
                Util.showWalletBalanceMsg(wBal);
                Util.pressEnterToContinue();
            }
            return wBal;
    }

        private static int subtractBetFromWallet(int wBal, int bet, int gChoice) {
            return wBal - (bet * gChoice);
        }

        private static void displayPullingTheLeverMsg(int bal) {
            Util.clearScreen();
            Util.showWalletBalanceMsg(bal);
            System.out.println("Pulling the lever...\n");
            Util.pressEnterToContinue();
        }


        private static boolean isWinner(int numWinningLines) {
            return numWinningLines >= 1;
        }

        private static int getWinningsAmount(int bet, int numWinningLines, int gChoice) {
            int winningsAmount = 0;

            if (isOneLineGame(gChoice)) {
                winningsAmount = bet * 2;
            } else if (isThreeLineGame(gChoice)) {
                if (numWinningLines == 1) {
                    winningsAmount = bet * 3;
                } else if (numWinningLines == 2) {
                    winningsAmount = bet * 6;
                } else if (numWinningLines == 3) {
                    winningsAmount = bet * 9;
                }
            } else {
                if (numWinningLines == 1) {
                    winningsAmount = bet * 5;
                } else if (numWinningLines == 2) {
                    winningsAmount = bet * 10;
                } else if (numWinningLines == 3) {
                    winningsAmount = bet * 15;
                } else if (numWinningLines == 4) {
                    winningsAmount = bet * 25;
                } else if (numWinningLines == 5) {
                    winningsAmount = bet * 30;
                }
            }
            return winningsAmount;
        }

        private static int addWinningsAmountToWallet(int wBal, int winningsAmount) {
            return wBal + winningsAmount;
        }

        private static void showWinningMsg(int winningsAmount) {
            System.out.println("Congratulation! You won for a total of $" + winningsAmount + "!\n");
            Util.pressEnterToContinue();
        }


        private static void showLosingMsg() {
            System.out.println("Sorry...you didn't win anything. Better luck next time!\n");
            Util.pressEnterToContinue();
        }


    static boolean isOneLineGame(int gChoice) {
        return gChoice == 1;
    }

    static boolean isThreeLineGame(int gChoice) {
        return gChoice == 3;
    }

    static boolean isFiveLineGame(int gChoice) {
        return gChoice == 5;
    }
}
