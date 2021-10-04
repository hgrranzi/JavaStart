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

       field.printField(true);
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
        boolean shot = false;

        while (!shot) {
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
                if (sankShip(ships, coordinates)) {
                    System.out.println("You sank a ship!");
                } else {
                    System.out.println("You hit a ship!");
                }
            } else {
                System.out.println("You missed!");
            }
            shot = true;
        }
    }

    public boolean sankShip(Ship[] ships, Coordinates coordinates) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i].getLife() > 0 && ships[i].atCell(coordinates)) {
                ships[i].setLife(ships[i].getLife() - 1);
                if (ships[i].getLife() == 0) {
                    this.shipsCount--;
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public void play() {
        while (this.shipsCount > 0) {
            shoot();
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }
}