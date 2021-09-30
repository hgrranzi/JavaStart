import java.util.*;

public class Board {
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

    public char[][] getBoard() {
        return board;
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