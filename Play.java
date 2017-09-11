package jl.slotsmachine;

import java.util.Objects;

import static jl.slotsmachine.Main.showWalletBalance;
import static jl.slotsmachine.OneLineGame.playOneLineGame;
import static jl.slotsmachine.ThreeLineGame.playThreeLineGame;
import static jl.slotsmachine.FiveLineGame.playFiveLineGame;

class Play {

    static int enterPlay(int wBal) {
        if (unableToPlay(wBal)) {
            displayUnableToPlayMsg();
        } else {
            int gameChoice = getGameChoice(wBal);
            if (isOneLineGame(gameChoice)) {
                wBal = playOneLineGame(wBal);
            } else if (isThreeLineGame(gameChoice) && hasEnoughToPlay(wBal, gameChoice)) {
                wBal = playThreeLineGame(wBal);
            } else if (isFiveLineGame(gameChoice) && hasEnoughToPlay(wBal, gameChoice)) {
                wBal = playFiveLineGame(wBal);
            }
            else {
                displayNotEnoughtToPlay(gameChoice);
            }
        }
        return wBal;
    }

        private static boolean unableToPlay(int wBal) {
            return wBal <= 0;
        }

        private static void displayUnableToPlayMsg() {
            Util.clearScreen();
            System.out.println("Sorry, you do not have enough money in your Wallet to play.\nYou can add more money to your Wallet from the Wallet Menu.\n");
            Util.pressEnterToContinue();
        }


        private static int getGameChoice(int wBal) {
            displayPlayMenu(wBal);
            return getNumLinesChoice(wBal);
        }

        private static void displayPlayMenu(int bal) {
            Util.clearScreen();
            System.out.println("Play\n------------");
            showWalletBalance(bal);
            System.out.println("How many lines would you like to play? 1, 3, or 5?\n\nType 1, 3, or 5 and press Enter\n");
        }

        private static int getNumLinesChoice(int wBal) {
            int choice = Util.getUserChoice();
            choice = verifyNumLinesChoice(wBal, choice);
            return choice;
        }

        private static int verifyNumLinesChoice(int wBal, int choice) {
            while (choice != 1 && choice != 3 && choice != 5) {
                Util.displayChoiceError();
                displayPlayMenu(wBal);
                choice = Util.getUserChoice();
            }
            return choice;
        }


        private static boolean isOneLineGame (int gameChoice) {
            return gameChoice == 1;
        }

        private static boolean isThreeLineGame (int gameChoice) {
            return gameChoice == 3;
        }

        private static boolean isFiveLineGame (int gameChoice) {
            return gameChoice == 5;
        }


        private static boolean hasEnoughToPlay(int wBal, int gameChoice) {
            return wBal >= gameChoice;
        }

        private static void displayNotEnoughtToPlay(int gameChoice){
            Util.clearScreen();
            System.out.println("Sorry, you must have at least $" + gameChoice + " to play a " + gameChoice + " line game.\nYou can add more money to your Wallet from the Wallet Menu.\n");
            Util.pressEnterToContinue();
        }


        static void displayPullingTheLeverMsg(int bal) {
        Util.clearScreen();
        showWalletBalance(bal);
        System.out.println("Pulling the lever...\n");
        Util.pressEnterToContinue();
    }

        static int checkIfLineWins(String iconOne, String iconTwo, String iconThree) {
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

}