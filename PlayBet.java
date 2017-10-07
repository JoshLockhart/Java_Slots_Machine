package jl.slotsmachine;

class PlayBet {

    static int getValidBet(int balance, int gameChoice) {
        displayBetMsg(balance, gameChoice);
        int bet = Util.getUserChoice();
        if (Game.isOneLineGame(gameChoice)) {
            while (bet < 1 || bet > balance) {
                displayBetAmountErrorMsg(balance, gameChoice);
                bet = Util.getUserChoice();
            }
        } else if (Game.isThreeLineGame(gameChoice)) {
            while (bet < 1 || (bet * 3) > balance) {
                displayBetAmountErrorMsg(balance, gameChoice);
                bet = Util.getUserChoice();
            }
        } else {
            while (bet < 1 || (bet * 5) > balance) {
                displayBetAmountErrorMsg(balance, gameChoice);
                bet = Util.getUserChoice();
            }
        }
        return bet;
    }

    private static void displayBetMsg(int balance, int gameChoice) {
        Util.clearScreen();
        Util.displayWalletBalanceMsg(balance);
        if (Game.isOneLineGame(gameChoice)) {
            System.out.println("How much would you like to bet for the one line?\n");
        } else if (Game.isThreeLineGame(gameChoice)) {
            System.out.println("How much would you like to bet for each of the three lines?\n");
        } else {
            System.out.println("How much would you like to bet for each of the five lines?\n");
        }
    }

    private static void displayBetAmountErrorMsg(int balance, int gameChoice) {
        String msg;
        if (Game.isOneLineGame(gameChoice)) {
            msg = "Minimum bet allowed is $1.\nMaximum bet allowed is your current Wallet balance.\nSelect a valid amount.\n";
        } else if (Game.isThreeLineGame(gameChoice)) {
            msg = "Minimum bet allowed is $1 for each line.\nMaximum bet cannot exceed 1/3 of your Wallet balance.\nSelect a valid amount.\n";
        } else {
            msg = "Minimum bet allowed is $1 for each line.\nMaximum bet cannot exceed 1/5 of your Wallet balance.\nSelect a valid amount.\n";
        }
        Util.clearScreen();
        Util.displayWalletBalanceMsg(balance);
        System.out.println(msg);
        Util.pressEnterToContinue();
        displayBetMsg(balance, gameChoice);
    }
}
