package jl.slotsmachine;

class Game {

    static void playChosenGame(Wallet wallet, PlaySection playSection, int gameChoice) {
            int bet = PlayBet.getValidBet(wallet.balance, gameChoice);
            subtractBetFromWallet(wallet, bet, gameChoice);
            displayPullingTheLeverMsg(wallet.balance);

            int numWinningLines = PlayGameResults.displayAndGetGameResults(gameChoice);
            if (isWinner(numWinningLines)) {
                int winningsAmount = getWinningsAmount(bet, numWinningLines, gameChoice);
                showWinningMsg(wallet.balance, winningsAmount);
                addWinningsAmountToWallet(wallet, winningsAmount);
                updatePlaySectionWinningStats(playSection, numWinningLines, winningsAmount);
            } else {
                showLosingMsg(wallet.balance);
                updateNumGamesLostStat(playSection);
            }
    }

        private static void subtractBetFromWallet(Wallet wallet, int bet, int gameChoice) {
            wallet.balance -= (bet * gameChoice);
        }

        private static void displayPullingTheLeverMsg(int balance) {
            Util.clearScreen();
            Util.displayWalletBalanceMsg(balance);
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

        private static void showWinningMsg(int balance, int winningsAmount) {
            System.out.println("Congratulation! You won for a total of $" + winningsAmount + "!\n");
            Util.displayWalletBalanceMsg(balance);
            Util.pressEnterToContinue();
        }

        private static void addWinningsAmountToWallet(Wallet wallet, int winningsAmount) {
            wallet.balance += winningsAmount;
        }

        private static void updatePlaySectionWinningStats(PlaySection playSection, int numWinningLines, int winningsAmount) {
            playSection.numLinesWon += numWinningLines;
            playSection.numGamesWon++;
            playSection.totalMoneyWon += winningsAmount;
        }


        private static void showLosingMsg(int balance) {
            System.out.println("Sorry...you didn't win anything. Better luck next time!\n");
            Util.displayWalletBalanceMsg(balance);
            Util.pressEnterToContinue();
        }

        private static void updateNumGamesLostStat(PlaySection playSection) {
            playSection.numGamesLost++;
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
