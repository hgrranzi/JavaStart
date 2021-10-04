package battleship;

import java.util.Scanner;

public class Coordinates {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Coordinates(int y1, int x1, int y2, int x2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public static Coordinates takeCoordinates(Ship ship) throws InvalidInputException {
        Scanner term = new Scanner(System.in);
        String first = term.next();
        String second = term.next();
        Coordinates coordinates;
        if (!validInput(first) || !validInput(second)) {
            throw new InvalidInputException("Invalid input!");
        }
        return (convertInputToCoordinates(ship, first, second));
    }

    private static Coordinates convertInputToCoordinates(Ship ship, String first, String second) throws InvalidInputException {
        int y1 = (int)first.charAt(0) - 64;
        int y2 = (int)second.charAt(0) - 64;
        int x1 = Integer.parseInt(first.substring(1));
        int x2 = Integer.parseInt(second.substring(1));
        int tmp;

        if (y1 > y2) {
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        if (x1 > x2) {
            tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        if (!validCoordinates(x1, y1, x2, y2)) {
            throw new InvalidInputException("Invalid coordinates!");
        }
        if (x2 - x1 + 1 != ship.getLife() && y2 - y1 + 1 != ship.getLife()) {
            throw new InvalidInputException("Wrong length of the " + ship + "!");
        }
        return new Coordinates(y1, x1, y2, x2);
    }

    private static boolean validCoordinates(int x1, int y1, int x2, int y2) {
        if (x1 < 1 || x1 > 10 || y1 < 1 || y1 > 10 || x2 < 1 || x2 > 10 || y2 < 1 || y2 > 10) {
            return false;
        }
        if (x1 != x2 && y1 != y2) {
            return false;
        }
        return true;
    }

    private static boolean validInput(String input) {
        if (input.length() < 2 || input.length() > 3) {
            return false;
        }
        if (input.charAt(0) < 'A' || input.charAt(0) > 'J') {
            return false;
        }
        if (input.charAt(1) < '0' || input.charAt(1) > '9') {
            return false;
        }
        if (input.length() == 3 && (input.charAt(2) < '0' || input.charAt(2) > '9')) {
            return false;
        }
        return true;
    }
}