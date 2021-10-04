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

    public void setLife(int life) {
        this.life = life;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.life + " cells)";
    }

    public boolean atCell(Coordinates coordinates) {
        if (this.coordinates.getX1() == this.coordinates.getX2()) {
            return (coordinates.getX1() == this.coordinates.getX1()
                    && coordinates.getY1() >= this.coordinates.getY1() && coordinates.getY1() <= this.coordinates.getY2());
        }
        return (coordinates.getY1() == this.coordinates.getY1()
                && coordinates.getX1() >= this.coordinates.getX1() && coordinates.getX1() <= this.coordinates.getX2());
    }
}

