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
        int j = 0;

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
        return ' ';
    }

    static char deadCellLife(char[][] currentField, int i, int j) {
        return 'O';
    }
}