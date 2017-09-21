package jl.slotsmachine;

class Play {

    static int performPlay(int wBal) {
        if (noMoneyToPlayWith(wBal)) {
            showNoMoneyToPlayWithMsg();
        } else {
            int gChoice = getValidGameChoice(wBal);
            if (hasEnoughMoneyToPlayChosenGame(wBal, gChoice)) {
                wBal = GameChoice.playChosenGame(wBal, gChoice);
            } else {
                showNotEnoughtToPlayMsg(gChoice);
            }
        }
        return wBal;
    }

        private static boolean noMoneyToPlayWith(int wBal) {
            return wBal <= 0;
        }

        private static void showNoMoneyToPlayWithMsg() {
            Util.clearScreen();
            System.out.println("Sorry, you do not have enough money in your Wallet to play.\nYou can add more money to your Wallet from the Wallet Menu.\n");
            Util.pressEnterToContinue();
        }


        private static int getValidGameChoice(int wBal) {
            displayPlayMenu(wBal);
            int gChoice = Util.getUserChoice();
            while (gChoice != 1 && gChoice != 3 && gChoice != 5) {
                Util.showChoiceErrorMsg();
                displayPlayMenu(wBal);
                gChoice = Util.getUserChoice();
            }
            return gChoice;
        }

        private static void displayPlayMenu(int bal) {
            Util.clearScreen();
            System.out.println("Play\n------------");
            Util.showWalletBalanceMsg(bal);
            System.out.println("How many lines would you like to play? 1, 3, or 5?\n\nType 1, 3, or 5 and press Enter\n");
        }

        private static boolean hasEnoughMoneyToPlayChosenGame(int wBal, int gChoice) {
            boolean hasEnoughMoney = false;
            if ((gChoice == 1 && wBal >= 1) || (gChoice == 3 && wBal >= 3) || (gChoice == 5 && wBal >= 5)) {
                hasEnoughMoney = true;
            }
            return  hasEnoughMoney;
        }

        private static void showNotEnoughtToPlayMsg(int gChoice){
            Util.clearScreen();
            System.out.println("Sorry, you must have at least $" + gChoice + " to play a " + gChoice + " line game.\nYou can add more money to your Wallet from the Wallet Menu.\n");
            Util.pressEnterToContinue();
        }
}