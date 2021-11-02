package life;

public class GameOfLife {
    public static void main(String[] args) {
        try {
            Field field = Field.create();
            Generation.runLife(field);
            field.printField();
        } catch (Exception e) {
            System.out.println("Error. Wrong input.");
        }
    }
}