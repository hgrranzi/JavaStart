package battleship;

public enum Ship {
    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    private final String name;
    private Coordinates coordinates;
    int life;

    private Ship(String name, int life) {
        this.name = name;
        this.coordinates = null;
        this.life = life;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", life=" + life +
                '}';
    }
}

