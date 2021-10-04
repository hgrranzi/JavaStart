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
            for (int i = 1; i <= this.SIZE; i++) {
                row[i] = digit;
                digit++;
            }
            row[this.SIZE] = '1';
        }
    }

    private void printCell(char c) {
        if (c == 'N') {
            System.out.print("~" + " ");
        } else {
            System.out.print(c + " ");
        }
    }

    public void printField() {
        System.out.println();
        for (int i = 0; i <= this.SIZE; i++) {
            for (int j = 0; j <= this.SIZE; j++) {
                if (i == 0 && j == this.SIZE) {
                    System.out.print(this.field[i][j] + "0");
                } else {
                    printCell(this.field[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void placeShip(Coordinates coordinates) throws BattleshipExceptions {
        if (coordinates.getX1() == coordinates.getX2()) {
            placeVerticalShip(coordinates.getX1(), coordinates.getY1(), coordinates.getY2());
        } else if (coordinates.getY1() == coordinates.getY2()) {
            placeHorizontalShip(coordinates.getY1(), coordinates.getX1(), coordinates.getX2());
        } else {
            throw new WrongLocationException("Wrong ship location!");
        }
    }

    public boolean hitShip(Coordinates coordinates) {
        int x = coordinates.getX1();
        int y = coordinates.getY1();

        if (this.field[y][x] == 'O') {
            this.field[y][x] = 'X';
            return true;
        }
        this.field[y][x] = 'M';
        return false;
    }

    private void placeVerticalShip(int x, int y1, int y2) throws BattleshipExceptions {
        for (int i = y1; i <= y2; i++) {
            if (this.field[i][x] == 'O' || this.field[i][x] == 'N') {
                throw new WrongLocationException("Too close to another ship!");
            }
        }
        for (int i = y1 - 1; i <= y2 + 1; i++) {
            if (i > 0 && i <= SIZE) {
                if (x - 1 > 0) {
                    this.field[i][x - 1] = 'N';
                }
                if (x + 1 <= SIZE) {
                    this.field[i][x + 1] = 'N';
                }
                if (i == y1 - 1 || i == y2 + 1) {
                    this.field[i][x] = 'N';
                } else {
                    this.field[i][x] = 'O';
                }
            }
        }
    }

    private void placeHorizontalShip(int y, int x1, int x2) throws BattleshipExceptions {
        for (int i = x1; i <= x2; i++) {
            if (this.field[y][i] == 'O' || this.field[y][i] == 'N') {
                throw new WrongLocationException("Too close to another ship!");
            }
        }
        for (int i = x1 - 1; i <= x2 + 1; i++) {
            if (i > 0 && i <= SIZE) {
                if (y - 1 > 0) {
                    this.field[y - 1][i] = 'N';
                }
                if (y + 1 <= SIZE) {
                    this.field[y + 1][i] = 'N';
                }
                if (i == x1 - 1 || i == x2 + 1) {
                    this.field[y][i] = 'N';
                } else {
                    this.field[y][i] = 'O';
                }
            }
        }
    }
}