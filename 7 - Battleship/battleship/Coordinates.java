package battleship;

public class Coordinates {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Coordinates(char y1, char x1, char y2, char x2) {
        this.x1 = (int)x1 - 48;
        this.y1 = (int)y1 - 64;
        this.x2 = (int)x2 - 48;
        this.y2 = (int)y2 - 64;;
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
}