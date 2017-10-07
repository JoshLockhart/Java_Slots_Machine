package jl.slotsmachine;

import java.util.Scanner;

class Util {

    static void displayWalletBalanceMsg(int bal) {
        System.out.println("Your current Wallet Balance is $" + bal + ".\n");
    }

    static void showChoiceErrorMsg() {
        System.out.println("\nPlease select a valid choice!\n");
        Util.pressEnterToContinue();
        clearScreen();
    }

    static void displayReturnToMainMenuMsg() {
        Util.clearScreen();
        System.out.println("Returning to Main Menu...\n");
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Util.clearScreen();
    }


    static void clearScreen() {
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
    }

    static void pressEnterToContinue() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Util.clearScreen();
    }

    static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            showChoiceErrorMsg();
            scan.next();
        }
        return scan.nextInt();
    }
}
