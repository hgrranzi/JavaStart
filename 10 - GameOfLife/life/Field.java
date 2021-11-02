package life;

import java.util.Scanner;
import java.util.Random;

public class Field {
    private char[][] field;
    private int steps;

    private Field(char[][] field, int steps) {
        this.field = field;
        this.steps = steps;
    }

    public char[][] getField() {
        return field;
    }

    public int getSteps() {
        return steps;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    public void printField() {
        for (char[] row : this.field) {
            System.out.println(row);
        }
    }

    public static Field create() throws Exception {
        Scanner term = new Scanner(System.in);
        int side = term.nextInt();
        int seed = term.nextInt();
        int steps = term.nextInt();
        char[][] field;
        Random generator = new Random(seed);

        if (side < 1 || steps < 0) {
            throw new Exception();
        }
        field = new char[side][side];
        for (char[] row : field) {
            for (int i = 0; i < row.length; i++) {
                if (generator.nextBoolean()) {
                    row[i] = 'O';
                } else {
                    row[i] = ' ';
                }
            }
        }
        return new Field(field, steps);
    }
}