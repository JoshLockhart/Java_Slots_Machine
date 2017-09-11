package jl.slotsmachine;

class WalletCustomAmount {

    static int getCustomAmount() {
        showValidCustomAmountRange();
        int amount = Util.getUserChoice();
        amount = verifyCustomAmount(amount);
        showCustomAmountAddedMsg(amount);
        return amount;
    }

    private static void showValidCustomAmountRange() {
        Util.clearScreen();
        System.out.println("Please enter an amount between 0 and 10,000 that you would like to add to your Wallet.\n\n");
    }

    private static int verifyCustomAmount(int amount) {
        while (amount < 0 || amount > 10000) {
            Util.displayChoiceError();
            showValidCustomAmountRange();
            amount = Util.getUserChoice();
        }
        return amount;
    }

    private static void showCustomAmountAddedMsg(int cAmount) {
        String msg;

        Util.clearScreen();
        if (cAmount <= 0) {
            msg = "No money has been added to your Wallet. You will be returned to the Main Menu.\n\n";
        } else {
            msg = "$" + cAmount + " has been added to your Wallet!\nYou will be returned to the Main Menu.\n\n";
        }
        System.out.println(msg);
        Util.pressEnterToContinue();
    }
}
