package life;

import java.util.Scanner;

public class Generation {

    public static void runLife(Field field) {
        for (int i = 0; i < field.getSteps(); i++) {
            field.setField(nextGeneration(field.getField()));
        }
    }

    static char[][] nextGeneration(char[][] currentField) {
        char[][] nextField = new char[currentField.length][currentField.length];
        int i = 0;
        int j;

        while (i < currentField.length) {
            j = 0;
            while (j < currentField.length) {
                if (currentField[i][j] == 'O') {
                    nextField[i][j] = liveCellLife(currentField, i, j);
                } else {
                    nextField[i][j] = deadCellLife(currentField, i, j);
                }
                j++;
            }
            i++;
        }
        return nextField;
    }

    static char liveCellLife(char[][] currentField, int i, int j) {
        int liveAround = countLiveAround(currentField, i, j) -  1;

        if (liveAround == 2 || liveAround == 3) {
            return 'O';
        }
        return ' ';
    }

    static char deadCellLife(char[][] currentField, int i, int j) {
        int liveAround = countLiveAround(currentField, i, j);

        if (liveAround == 3) {
            return 'O';
        }
        return ' ';
    }

    static int countLiveAround(char[][] currentField, int i, int j) {
        int count = 0;
        boolean ySmall = false;
        boolean xSmall = false;
        boolean yBig = false;
        boolean xBig = false;

        for (int y = i - 1; y <= i + 1; y++) {
            if (y == -1) {
                y += currentField.length;
                ySmall = true;
            }
            if (y == currentField.length) {
                y = 0;
                yBig = true;
            }
            for (int x = j - 1; x <= j + 1; x++) {
                if (x == -1) {
                    x += currentField.length;
                    xSmall = true;
                }
                if (x == currentField.length) {
                    x = 0;
                    xBig = true;
                }
                if (currentField[y][x] == 'O') {
                    count++;
                }
                if (xSmall) {
                    xSmall = false;
                    x = -1;
                }
                if (xBig) {
                    xBig = false;
                    x = currentField.length;
                }
            }
            if (ySmall) {
                ySmall = false;
                y = -1;
            }
            if (yBig) {
                yBig = false;
                y = currentField.length;
            }
        }
        return count;
    }
}