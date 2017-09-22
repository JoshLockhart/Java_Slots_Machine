package jl.slotsmachine;

import java.util.Objects;
import java.util.Random;

class PlayGameResults {

    static int showAndGetGameResults(int gChoice) {
        int nLinesWon;

        if (GameChoice.isOneLineGame(gChoice)) {
            nLinesWon = showAndGetOneLineGameResults();
        } else {
            nLinesWon = showAndGetThreeOrFiveLineGameResults(gChoice);
        }
        return nLinesWon;
    }

        private static int showAndGetOneLineGameResults() {
            String[] icons = {"Diamond", "Cherry", "7s", "Bar", "Shamrock"};
            String[] randIcons = new String[3];

            for (int i = 0; i < 3; i++) {
                randIcons[i] = icons[getRandomNumberForIcon()];
            }

            String iconOne = randIcons[0];
            String iconTwo = randIcons[1];
            String iconThree = randIcons[2];

            System.out.println(iconOne + " | " + iconTwo + " | " + iconThree + "\n");
            return checkIfLineWins(iconOne, iconTwo, iconThree);
        }

        private static int showAndGetThreeOrFiveLineGameResults(int gChoice) {
            int nLinesWon = 0;
            String[] icons = {"Diamond", "Cherry", "7s", "Bar", "Shamrock"};
            String[] randIcons = new String[9];

            for (int i = 0; i < 9; i++) {
                randIcons[i] = icons[getRandomNumberForIcon()];
            }

            String iconOne = randIcons[0];
            String iconTwo = randIcons[1];
            String iconThree = randIcons[2];
            String iconFour = randIcons[3];
            String iconFive = randIcons[4];
            String iconSix = randIcons[5];
            String iconSeven = randIcons[6];
            String iconEight = randIcons[7];
            String iconNine = randIcons[8];

            System.out.println(iconFour + " | " + iconFive + " | " + iconSix + "\n");
            System.out.println(iconOne + " | " + iconTwo + " | " + iconThree + "\n");
            System.out.println(iconSeven + " | " + iconEight + " | " + iconNine + "\n");

            nLinesWon += checkIfLineWins(iconFour, iconFive, iconSix);
            nLinesWon += checkIfLineWins(iconOne, iconTwo, iconThree);
            nLinesWon += checkIfLineWins(iconSeven, iconEight, iconNine);
            if (GameChoice.isFiveLineGame(gChoice)) {
                nLinesWon += checkIfLineWins(iconFour, iconTwo, iconNine);
                nLinesWon += checkIfLineWins(iconSix, iconTwo, iconSeven);
            }
            return nLinesWon;
        }

        private static int getRandomNumberForIcon() {
            Random rand = new Random();
            return rand.nextInt(5);
        }

        private static int checkIfLineWins(String iconOne, String iconTwo, String iconThree) {
            int nLinesWon = 0;
            if (Objects.equals(iconOne, iconTwo) && Objects.equals(iconOne, iconThree)) {
                nLinesWon += 1;
            } else if (Objects.equals(iconOne, "Shamrock") && Objects.equals(iconTwo, iconThree)) {
                nLinesWon += 1;
            } else if (Objects.equals(iconTwo, "Shamrock") && Objects.equals(iconOne, iconThree)) {
                nLinesWon += 1;
            } else if (Objects.equals(iconThree, "Shamrock") && Objects.equals(iconOne, iconTwo)) {
                nLinesWon += 1;
            } else if (Objects.equals(iconOne, "Shamrock") && Objects.equals(iconTwo, "Shamrock")) {
                nLinesWon += 1;
            } else if (Objects.equals(iconOne, "Shamrock") && Objects.equals(iconThree, "Shamrock")) {
                nLinesWon += 1;
            } else if (Objects.equals(iconTwo, "Shamrock") && Objects.equals(iconThree, "Shamrock")) {
                nLinesWon += 1;
            }
            return nLinesWon;
        }
}
