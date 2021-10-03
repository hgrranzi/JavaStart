package battleship;

import java.util.Arrays;

public class Field {
    final int SIZE;
    private char[][] field;

    Field() {
        char letter = '@';
        this.SIZE = 10;
        this.field = new char[this.SIZE + 1][];
        for (int i = 0; i <= this.SIZE; i++) {
            this.field[i] = new char[this.SIZE + 1];
            fillRow(this.field[i], letter);
            letter++;
        }

    }

    void fillRow(char[] row, char letter) {
        if (letter != '@') {
            Arrays.fill(row, '~');
            row[0] = letter;
        } else {
            char digit = '1';
            row[0] = ' ';
            for (int i = 1; i < this.SIZE; i++) {
                row[i] = digit;
                digit++;
            }
            row[this.SIZE] = '1';
        }
    }

    public void printField() {
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j <= this.SIZE; j++) {
                if (i == 0 && j == this.SIZE) {
                    System.out.print(this.field[i][j] + "0");
                } else {
                    System.out.print(this.field[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}