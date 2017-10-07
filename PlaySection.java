package jl.slotsmachine;

class PlaySection {
    int numGamesLost,
        numGamesWon,
        numLinesWon,
        totalMoneyWon;

    PlaySection(int startNumGamesLost, int startNumGamesWon, int startNumLinesWon, int startTotalMoneyWon) {
        numGamesLost = startNumGamesLost;
        numGamesWon = startNumGamesWon;
        numLinesWon = startNumLinesWon;
        totalMoneyWon = startTotalMoneyWon;
    }

    void enterPlaySection(Wallet wallet, PlaySection playSection) {
        if (hasNoMoneyToPlayWith(wallet.balance)) {
            displayNoMoneyToPlayWithMsg(wallet.balance);
        } else {
            int gameChoice = getValidGameChoice(wallet.balance);
            if (hasEnoughMoneyToPlayChosenGame(wallet.balance, gameChoice )) {
                Game.playChosenGame(wallet, playSection, gameChoice);
            } else {
                displayNotEnoughtToPlayMsg(gameChoice);
            }
        }
    }

        private static boolean hasNoMoneyToPlayWith(int balance) {
            return balance == 0;
        }

        private static void displayNoMoneyToPlayWithMsg(int balance) {
            Util.clearScreen();
            Util.displayWalletBalanceMsg(balance);
            System.out.println("Sorry, you do not have enough money in your Wallet to play a game.\n"
                             + "You can add more money to your Wallet from the Wallet Menu.\n");
            Util.pressEnterToContinue();
        }


        private int getValidGameChoice(int balance) {
            displayPlayMenu(balance);
            int gameChoice = Util.getUserChoice();
            while (gameChoice != 1 && gameChoice != 3 && gameChoice != 5) {
                Util.showChoiceErrorMsg();
                displayPlayMenu(balance);
                gameChoice  = Util.getUserChoice();
            }
            return gameChoice;
        }

        private static void displayPlayMenu(int balance) {
            Util.clearScreen();
            Util.displayWalletBalanceMsg(balance);
            System.out.println("How many lines would you like to play? 1, 3, or 5?\n\n"
                             + "Type 1, 3, or 5 and press Enter\n");
        }

        private static boolean hasEnoughMoneyToPlayChosenGame(int balance, int gameChoice ) {
            boolean hasEnoughMoney = false;
            if ((gameChoice == 1 && balance >= 1) || (gameChoice == 3 && balance >= 3) || (gameChoice == 5 && balance >= 5)) {
                hasEnoughMoney = true;
            }
            return  hasEnoughMoney;
        }

        private static void displayNotEnoughtToPlayMsg(int gameChoice){
            Util.clearScreen();
            System.out.println("Sorry, you must have at least $" + gameChoice + " to play a " + gameChoice + " line game.\n"
                             + "You can add more money to your Wallet from the Wallet Menu.\n");
            Util.pressEnterToContinue();
        }
}