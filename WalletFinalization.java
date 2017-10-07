package jl.slotsmachine;

class WalletFinalization {

    static boolean checkIfUserWantsToFinalizeAmount(int addMoneyMenuChoice) {
        displayFinalizedAmountMenu(addMoneyMenuChoice);
        int choice = getValidFinalizedAmountMenuChoice(addMoneyMenuChoice);
        return determineIfAmountIsFinalizedOrNot(choice);
    }

        private static void displayFinalizedAmountMenu(int addMoneyMenuChoice) {
            String amount;
            if (WalletMoney.isTwentyDollarsChoice(addMoneyMenuChoice)) {
                amount = " $20 ";
            } else if (WalletMoney.isFiftyDollarsChoice(addMoneyMenuChoice)) {
                amount = " $50 ";
            } else if (WalletMoney.isHundredDollarsChoice(addMoneyMenuChoice)) {
                amount = " $100 ";
            } else {
                amount = " $500 ";
            }
            Util.clearScreen();
            System.out.println("Are you sure you want to add" + amount + "to your Wallet?\n\n"
                             + "1.) Yes\n"
                             + "2.) No\n\n"
                             + "Type 1 or 2 and press Enter.\n\n");
        }

        private static int getValidFinalizedAmountMenuChoice(int addMoneyMenuChoice) {
            int choice = Util.getUserChoice();
            while (choice != 1 && choice != 2) {
                Util.showChoiceErrorMsg();
                choice = Util.getUserChoice();
                displayFinalizedAmountMenu(addMoneyMenuChoice);
            }
            return choice;
        }

        private static boolean determineIfAmountIsFinalizedOrNot(int choice) {
            boolean finalized = false;

            if (isYesFinalizedChoice(choice)) {
                finalized = true;
            } else {
                Util.clearScreen();
                System.out.println("You will be taken back to the money amount selection.\n"
                                 + "No money has been added to your Wallet.\n");
                Util.pressEnterToContinue();
            }
            return finalized;
        }

        private static boolean isYesFinalizedChoice(int choice) {
            return choice == 1;
        }
}
