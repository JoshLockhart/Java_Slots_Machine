package jl.slotsmachine;

public class PlayBet {

    static int getValidBet(int wBal, int gChoice) {
        Util.clearScreen();
        Util.showWalletBalanceMsg(wBal);
        showBetMsg(gChoice);
        int bet = Util.getUserChoice();
        if (GameChoice.isOneLineGame(gChoice)) {
            while (bet < 1 || bet > wBal) {
                showBetAmountErrorMsg(wBal, gChoice);
                bet = Util.getUserChoice();
            }
        } else if (GameChoice.isThreeLineGame(gChoice)) {
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
        if (GameChoice.isOneLineGame(gChoice)) {
            System.out.println("How much would you like to bet for the one line?\n");
        } else if (GameChoice.isThreeLineGame(gChoice)) {
            System.out.println("How much would you like to bet for each of the three lines?\n");
        } else {
            System.out.println("How much would you like to bet for each of the five lines?\n");
        }
    }

    private static void showBetAmountErrorMsg(int wBal, int gChoice) {
        String msg;

        if (GameChoice.isOneLineGame(gChoice)) {
            msg = "Minimum bet allowed is $1.\nMaximum bet allowed is your current Wallet balance.\nSelect a valid amount.\n";
        } else if (GameChoice.isThreeLineGame(gChoice)) {
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
}
