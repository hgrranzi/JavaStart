package tictactoe;

import java.util.*;

public class Parser {

    public static String takeInput(String message) {
        Scanner term = new Scanner(System.in);
        System.out.print(message);
        return term.nextLine();
    }

    public static boolean isValid(String input) {
        if (input.length() != 9) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '_' && input.charAt(i) != 'O' && input.charAt(i) != 'X') {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String[] input, char[][] board) {
        int x;
        int y;

        if (input.length != 2) {
            System.out.println("Invalid input");
            return false;
        }
        try {
            y = Integer.parseInt(input[0]);
            x = Integer.parseInt(input[1]);
            if (y < 1 || y > 3 || x < 1 || x > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (board[y - 1][x - 1] != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    public static Point takeMove(Board board) {
        String[] move;
        Point point = null;

        move = Parser.takeInput("Enter the coordinates: ").split(" ");
        if (Parser.isValid(move, board.getBoard())) {
            point = new Point(Integer.parseInt(move[1]), Integer.parseInt(move[0]));
        }
        return point;
    }
}
