package jl.slotsmachine;

class WalletFinalization {

    static boolean checkIfUserWantsToFinalizeAmount(int wmMenuChoice) {
        showFinalizeAmountMenu(wmMenuChoice);
        int choice = getValidFinalizedAmountMenuChoice(wmMenuChoice);
        return determineIfAmountIsFinalized(choice);
    }

        private static void showFinalizeAmountMenu(int wmMenuChoice) {
            String amount = " 0 ";
            if (wmMenuChoice == 1) {
                amount = " $20 ";
            } else if (wmMenuChoice == 2) {
                amount = " $50 ";
            } else if (wmMenuChoice == 3) {
                amount = " $100 ";
            } else if (wmMenuChoice == 4) {
                amount = " $500 ";
            }
            Util.clearScreen();
            System.out.println("Are you sure you want to add" + amount + "to your Wallet?\n\n1.) Yes\n2.) No\n\nType 1 or 2 and press Enter.\n\n");
        }

        private static int getValidFinalizedAmountMenuChoice(int wmMenuChoice) {
            int choice = Util.getUserChoice();
            while (choice != 1 && choice != 2) {
                Util.showChoiceErrorMsg();
                choice = Util.getUserChoice();
                showFinalizeAmountMenu(wmMenuChoice);
            }
            return choice;
        }

        private static boolean determineIfAmountIsFinalized(int choice) {
            int yes = 1,
                    no = 2;
            boolean finalized = false;

            if (choice == yes) {
                finalized = true;
            } else if (choice == no) {
                Util.clearScreen();
                System.out.println("You will be taken back to the money amount selection.\nNo money has been added to your Wallet.\n");
                Util.pressEnterToContinue();
            }
            return finalized;
        }
}
