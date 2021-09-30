package tictactoe;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        String input = Parser.takeInput("Enter cells: ");
        if (Parser.isValid(input)) {
            Game xo = new Game(input);
            xo.play();
        } else {
            System.out.println("Invalid input");
        }
    }
}