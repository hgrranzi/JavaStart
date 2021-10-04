package battleship;

public class Player {
    public final int id;
    private Field field;
    private int shipsCount;
    private Ship[] ships;

    public Player(int id) {
        this.id = id;
        this.field = new Field();
        this.shipsCount = 5;
        this.ships = Ship.values();
    }

    public Field getField() {
        return field;
    }

    public int getShipsCount() {
        return shipsCount;
    }

    public void beforeStart() {
        int i = 0;
        Coordinates coordinates;

        System.out.printf("Player %d, place your ships on the game field\n", this.id);
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
    }

    public void shoot() {
        Coordinates coordinates;
        boolean hit = false;
        boolean shot = false;

        while (!shot) {
            try {
                coordinates = Coordinates.takeCoordinates();
            } catch (BattleshipExceptions e) {
                System.out.println(e);
                continue;
            }
            hit = field.hitShip(coordinates); // try to hit a ship
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
}