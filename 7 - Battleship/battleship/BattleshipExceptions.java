package battleship;

public class BattleshipExceptions extends Exception {
    private String message;

    BattleshipExceptions(String message) {
        this.message = message;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Error! " + message;
    }
}

class WrongLocationException extends BattleshipExceptions {
    WrongLocationException(String message) {
        super(message);
    }
}

class InvalidInputException extends BattleshipExceptions {
    InvalidInputException(String message) {
        super(message);
    }
}

class WrongShipLengthException extends BattleshipExceptions {
    WrongShipLengthException(String message) {
        super(message);
    }
}