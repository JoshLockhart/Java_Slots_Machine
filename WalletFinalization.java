package jl.slotsmachine;

class WalletFinalization {

    static boolean finalizeAmount(int amMenuChoice) {

        showFinalizeAmountMenu(amMenuChoice);
        int choice = getFinalizeAmountMenuChoice(amMenuChoice);
        return determineIfAmountIsFinalized(choice);
    }

        private static void showFinalizeAmountMenu(int amMenuChoice) {
            String amount = " 0 ";
            if (amMenuChoice == 1) {
                amount = " $20 ";
            } else if (amMenuChoice == 2) {
                amount = " $50 ";
            } else if (amMenuChoice == 3) {
                amount = " $100 ";
            } else if (amMenuChoice == 4) {
                amount = " $500 ";
            }
            Util.clearScreen();
            System.out.println("Are you sure you want to add" + amount + "to your Wallet?\n\n1.) Yes\n2.) No\n\nType 1 or 2 and press Enter.\n\n");
        }

        private static int getFinalizeAmountMenuChoice(int amMenuChoice) {
            int choice = Util.getUserChoice();
            choice = verifyFinalizeAmountMenuChoice(choice, amMenuChoice);
            return choice;
        }

        private static int verifyFinalizeAmountMenuChoice(int choice, int amMenuChoice) {
            while (choice != 1 && choice != 2) {
                Util.showChoiceErrorMsg();
                choice = Util.getUserChoice();
                showFinalizeAmountMenu(amMenuChoice);
            }
            return choice;
        }

        private static boolean determineIfAmountIsFinalized(int choice) {
            boolean finalized = false;
            if (choice == 1) {
                finalized = true;
            } else if (choice == 2) {
                Util.clearScreen();
                System.out.println("You will be taken back to the money amount selection.\nNo money has been added to your Wallet.\n");
                Util.pressEnterToContinue();
            }
            return finalized;
        }
}
