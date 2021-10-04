package battleship;

public enum Ship {
    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    private final String name;
    private Coordinates coordinates;
    private int life;

    private Ship(String name, int life) {
        this.name = name;
        this.coordinates = null;
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.life + " cells)";
    }
}

