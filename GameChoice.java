package jl.slotsmachine;

import java.util.Objects;
import java.util.Random;

class GameChoice {

    static int playChosenGame(int wBal, int gChoice) {
            int bet = getValidBet(wBal, gChoice);
            wBal = subtractBetFromWallet(wBal, bet, gChoice);
            displayPullingTheLeverMsg(wBal);

            int numWinningLines = showAndGetGameResults(gChoice);

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

        private static int getValidBet(int wBal, int gChoice) {
            Util.clearScreen();
            Util.showWalletBalanceMsg(wBal);
            showBetMsg(gChoice);
            int bet = Util.getUserChoice();
            if (gChoice == 1) {
                while (bet < 1 || bet > wBal) {
                    showBetAmountErrorMsg(wBal, gChoice);
                    bet = Util.getUserChoice();
                }
            } else if (gChoice == 3) {
                while (bet < 1 || (bet * 3) > wBal) {
                    showBetAmountErrorMsg(wBal, gChoice);
                    bet = Util.getUserChoice();
                }
            } else {
                while (bet < 1 || (bet * 5) > wBal) {
                    showBetAmountErrorMsg(wBal, gChoice);
                    bet = Util.getUserChoice();
                }
            }
            return bet;
        }

        private static void showBetMsg(int gChoice) {
            if (gChoice == 1) {
                System.out.println("How much would you like to bet for the one line?\n");
            } else if (gChoice == 3) {
                System.out.println("How much would you like to bet for each of the three lines?\n");
            } else {
                System.out.println("How much would you like to bet for each of the five lines?\n");
            }
        }

        private static void showBetAmountErrorMsg(int wBal, int gChoice) {
            String msg;

            if (gChoice == 1) {
                msg = "Minimum bet allowed is $1.\nMaximum bet allowed is your current Wallet balance.\nSelect a valid amount.\n";
            } else if (gChoice == 3) {
                msg = "Minimum bet allowed is $1 for each line.\nMaximum bet cannot exceed 1/3 of your Wallet balance.\nSelect a valid amount.\n";
            } else {
                msg = "Minimum bet allowed is $1 for each line.\nMaximum bet cannot exceed 1/5 of your Wallet balance.\nSelect a valid amount.\n";
            }
            Util.clearScreen();
            Util.showWalletBalanceMsg(wBal);
            System.out.println(msg);
            Util.pressEnterToContinue();
            Util.showWalletBalanceMsg(wBal);
            showBetMsg(gChoice);
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



        private static int showAndGetGameResults(int gChoice) {
            String[] icons = {"Diamond", "Cherry", "7s", "Bar", "Shamrock"};
            int nLinesWon = 0;
            Random rand = new Random();

            if (gChoice == 1) {
                int randNumOne = rand.nextInt(5);
                int randNumTwo = rand.nextInt(5);
                int randNumThree = rand.nextInt(5);
                String iconOne = icons[randNumOne];
                String iconTwo = icons[randNumTwo];
                String iconThree = icons[randNumThree];

                System.out.println(iconOne + " | " + iconTwo + " | " + iconThree + "\n");
                nLinesWon = checkIfLineWins(iconOne, iconTwo, iconThree);
            } else if (gChoice == 3) {
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

                nLinesWon += checkIfLineWins(iconFour, iconFive, iconSix);
                nLinesWon += checkIfLineWins(iconOne, iconTwo, iconThree);
                nLinesWon += checkIfLineWins(iconSeven, iconEight, iconNine);
            } else {
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

                nLinesWon += checkIfLineWins(iconFour, iconFive, iconSix);
                nLinesWon += checkIfLineWins(iconOne, iconTwo, iconThree);
                nLinesWon += checkIfLineWins(iconSeven, iconEight, iconNine);

                nLinesWon += checkIfLineWins(iconFour, iconTwo, iconNine);
                nLinesWon += checkIfLineWins(iconSix, iconTwo, iconSeven);
            }
            return nLinesWon;
        }

        private static int checkIfLineWins(String iconOne, String iconTwo, String iconThree) {
            int nLinesWon = 0;
            if (Objects.equals(iconOne, iconTwo) && Objects.equals(iconOne, iconThree)) {
                nLinesWon += 1;
            } else if (Objects.equals(iconOne, "Shamrock") && Objects.equals(iconTwo, iconThree)) {
                nLinesWon += 1;
            } else if (Objects.equals(iconTwo, "Shamrock") && Objects.equals(iconOne, iconThree)) {
                nLinesWon += 1;
            } else if (Objects.equals(iconThree, "Shamrock") && Objects.equals(iconOne, iconTwo)) {
                nLinesWon += 1;
            } else if (Objects.equals(iconOne, "Shamrock") && Objects.equals(iconTwo, "Shamrock")) {
                nLinesWon += 1;
            } else if (Objects.equals(iconOne, "Shamrock") && Objects.equals(iconThree, "Shamrock")) {
                nLinesWon += 1;
            } else if (Objects.equals(iconTwo, "Shamrock") && Objects.equals(iconThree, "Shamrock")) {
                nLinesWon += 1;
            }
            return nLinesWon;
        }



        private static boolean isWinner(int numWinningLines) {
            return numWinningLines >= 1;
        }

        private static int getWinningsAmount(int bet, int numWinningLines, int gChoice) {
            int winningsAmount = 0;

            if (gChoice == 1) {
                winningsAmount = bet * 2;
            } else if (gChoice == 3) {
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






}
