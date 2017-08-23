package jl.slotsmachine;

import java.util.Scanner;

public final class Util {

    public static void displayMainMenu() {
        System.out.println("  Menu\n----------\n1.) Wallet\n2.) Rules\n3.) Play\n4.) Quit\n\nType 1, 2, 3, or 4 and press Enter.\n");
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void displayChoiceError() {
        clearScreen();
        System.out.println("Please select a valid choice.\n");
    }

    public static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            displayChoiceError();
            scan.next();
        }
        int choice = scan.nextInt();
        return choice;
    }



}
