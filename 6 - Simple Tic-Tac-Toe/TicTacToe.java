import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        String input = Parser.takeInput();
        if (Parser.isValid(input)) {
            Game xo = new Game(input);
            System.out.println(xo.analyze());
        } else {
            System.out.println("Invalid input");
        }
    }
}