package jl.slotsmachine;

class WalletCustomAmount {

    static int getValidCustomAmount() {
        displayValidCustomAmountRangeMsg();
        int customAmount = Util.getUserChoice();
        while (customAmount < 0 || customAmount > 10000) {
            Util.showChoiceErrorMsg();
            displayValidCustomAmountRangeMsg();
            customAmount = Util.getUserChoice();
        }
        showCustomAmountAddedMsg(customAmount);
        return customAmount;
    }

        private static void displayValidCustomAmountRangeMsg() {
            Util.clearScreen();
            System.out.println("Please enter an amount between 0 and 10,000 that you would like to add to your Wallet.\n\n");
        }

        private static void showCustomAmountAddedMsg(int customAmount) {
            Util.clearScreen();
            if (customAmount == 0) {
                System.out.println("No money has been added to your Wallet. You will be returned to the Main Menu.\n\n");
            } else {
                System.out.println("$" + customAmount + " has been added to your Wallet!\nYou will be returned to the Main Menu.\n\n");
            }
            Util.pressEnterToContinue();
        }
}
