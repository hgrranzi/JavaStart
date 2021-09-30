import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        String input = Parser.takeInput();
        if (Parser.isValid(input)) {
            Board board = new Board();
            board.fillBoard(input);
            board.printBoard();
        } else {
            System.out.println("Invalid input");
        }
    }
}

class Board {
    private char[][] board;

    public Board() {
        this.board =  new char[3][];
        for (char[] row : this.board) {
            row = new char[3];
            for (char c : row) {
                c = '_';
            }
        }
    }

    public void fillBoard(String input) {
       this.board[0] = Arrays.copyOfRange(input.toCharArray(), 0, 3);
       this.board[1] = Arrays.copyOfRange(input.toCharArray(), 3, 6);
       this.board[2] = Arrays.copyOfRange(input.toCharArray(), 6, 9);
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < this.board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}

class Parser {
    public static String takeInput() {
        Scanner term = new Scanner(System.in);
        System.out.print("Enter cells:");
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
}