package tictactoe;

import java.util.*;

public class Game {
    private Board board;
    private GameState state;

    public Game() {
        this.board = new Board();
        this.state = GameState.NOT_FINISHED;
    }

    public Game(String input) {
        this();
        this.board.fillBoard(input);
        this.board.printBoard();
    }

    public void updateState() {
        this.state = analyze();
    }

    GameState analyze() {
        boolean xWin;
        boolean oWin;
        int xCount = 0;
        int oCount = 0;

        for (char[] row : this.board.getBoard()) {
            for (char c : row) {
                if (c == 'X') {
                    xCount++;
                }
                if (c == 'O') {
                    oCount++;
                }
            }
        }
        if (Math.abs(xCount - oCount) > 1) {
            return GameState.IMPOSSIBLE;
        }
        if (xCount + oCount < 5) {
            return GameState.NOT_FINISHED;
        }
        xWin = checkWin('X', this.board.getBoard().length);
        oWin = checkWin('O', this.board.getBoard().length);
        if (xWin && oWin) {
            return GameState.IMPOSSIBLE;
        }
        if (xWin) {
            return GameState.X_WINS;
        }
        if (oWin) {
            return GameState.O_WINS;
        }
        if (xCount + oCount == 9) {
            return GameState.DRAW;
        }
        return GameState.NOT_FINISHED;
    }

    boolean checkWin(char c, int n) {

        for (char[] row : this.board.getBoard()) {
            int i = 0;
            while (i < n && row[i] == c) {
                i++;
            }
            if (i == n) {
                return true;
            }
        }

        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n && this.board.getBoard()[j][i] == c) {
                j++;
            }
            if (j == n) {
                return true;
            }
        }

        int i = 0;
        int j = 0;
        while (i < n && this.board.getBoard()[j][i] == c) {
            i++;
            j++;
        }
        if (i == n) {
            return true;
        }

        i = n - 1;
        j = 0;
        while (i >= 0 && this.board.getBoard()[i][j] == c) {
            i--;
            j++;
        }
        if (i == -1) {
            return true;
        }
        return false;
    }

    public void play() {
        Point point = null;
        int i = 0;
        while (i < 9 && this.state != GameState.X_WINS && this.state != GameState.O_WINS) {
            while (point == null) {
                point = Parser.takeMove(this.board);
            }
            if (i % 2 == 0) {
                this.board.updateBoard(point, 'X');
            } else {
                this.board.updateBoard(point, 'O');
            }
            updateState();
            this.board.printBoard();
            point = null;
            i++;
        }
        System.out.println(this.state);
    }
}

enum GameState {

    NOT_FINISHED ("Game not finished"),
    DRAW ("Draw"),
    X_WINS ("X wins"),
    O_WINS ("O wins"),
    IMPOSSIBLE ("Impossible");

    private String state;

    GameState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state;
    }
}