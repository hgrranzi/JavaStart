package battleship;

public class Game {

    private Field field;
    private int shipsCount;
    private Ship[] ships;

    public Game() {
        this.field = new Field();
        this.shipsCount = 5;
        this.ships = Ship.values();
    }

    public void beforeStart() {
       int i = 0;
       Coordinates coordinates;

       while (i < this.shipsCount) {
           System.out.printf("Enter the coordinates of the %s:\n", ships[i]);
            try {
                coordinates = Coordinates.takeCoordinates(ships[i]);
                field.placeShip(coordinates); // 2 place the ship
            } catch (BattleshipExceptions e) {
                System.out.println(e);
                continue;
            }
            this.ships[i].setCoordinates(coordinates); // set coordinates to the ship
            field.printField(false);
            i++;
       }
        System.out.println("The game starts!");
        field.printField(true);
    }

    public void shoot() {
        Coordinates coordinates;
        boolean hit = false;
        int i = 0;

        while (i < 1) {
            System.out.printf("Take a shot!\n");
            try {
                coordinates = Coordinates.takeCoordinates();
            } catch (BattleshipExceptions e) {
                System.out.println(e);
                continue;
            }
            hit = field.hitShip(coordinates); // try to hit a ship
            field.printField(true);
            if (hit) {
                System.out.println("You hit a ship!");
            } else {
                System.out.println("You missed!");
            }
            field.printField(false);
            i++;
        }
    }
}