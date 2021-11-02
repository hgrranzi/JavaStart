package life;

public class GameOfLife {
    public static void main(String[] args) {
        try {
            Field field = Field.create();
            field.printField();
        } catch (Exception e) {
            System.out.println("Error. Wrong input.");
        }
    }
}