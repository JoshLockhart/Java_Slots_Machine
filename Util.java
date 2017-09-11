package jl.slotsmachine;

import java.util.Scanner;

public final class Util {



    public static void clearScreen() {
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Util.clearScreen();
    }

    public static void displayChoiceError() {
        System.out.println("\nPlease select a valid choice.\n");
        Util.pressEnterToContinue();
        clearScreen();
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

    public static void returnToMainMenu() {
        Util.clearScreen();
        System.out.println("Returning to Main Menu...\n");
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Util.clearScreen();
    }



}
