package battleship;

public class BattleshipExceptions extends Exception {
    BattleshipExceptions(String message) {
        super(message);
    }
}

class WrongLocationException extends BattleshipExceptions {
    WrongLocationException(String message) {
        super(message);
    }
}
