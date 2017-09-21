package jl.slotsmachine;

class WalletCustomAmount {

    static int getValidCustomAmount() {
        showValidCustomAmountRangeMsg();
        int cAmount = Util.getUserChoice();
        while (cAmount < 0 || cAmount > 10000) {
            Util.showChoiceErrorMsg();
            showValidCustomAmountRangeMsg();
            cAmount = Util.getUserChoice();
        }
        showCustomAmountAddedMsg(cAmount);
        return cAmount;
    }

        private static void showValidCustomAmountRangeMsg() {
            Util.clearScreen();
            System.out.println("Please enter an amount between 0 and 10,000 that you would like to add to your Wallet.\n\n");
        }

        private static void showCustomAmountAddedMsg(int cAmount) {
            Util.clearScreen();
            if (cAmount <= 0) {
                System.out.println("No money has been added to your Wallet. You will be returned to the Main Menu.\n\n");
            } else {
                System.out.println("$" + cAmount + " has been added to your Wallet!\nYou will be returned to the Main Menu.\n\n");
            }
            Util.pressEnterToContinue();
        }
}
