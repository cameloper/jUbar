package edu.kit.informatik;

class Tile {
    private final Point2D position;
    private Figure resident;

    /**
     * Default constructor for Tile
     * @param position position of the tile
     */
    Tile(Point2D position) {
        this.position = position;
    }

    /**
     * Public getter of Position
     *
     * @return value of private variable Position
     */
    Point2D getPosition() {
        return position;
    }

    /**
     * Public setter for resident
     *
     * @param resident New value for variable
     */
    void setResident(Figure resident) {
        this.resident = resident;

    }

    /**
     * Gives if the tile is occupied by a {@link Figure} or not
     *
     * @return true or false
     */
    boolean isFull() {
        return resident != null;
    }

    boolean isNeighborOf(Tile tile) {
        int x1 = position.getX();
        int x2 = tile.position.getX();

        int y1 = position.getY();
        int y2 = tile.position.getY();

        return ((x1 - x2 == 1 || x2 - x1 == 1) && y1 == y2)
                != ((y1 - y2 == 1 || y2 - y1 == 1) && x1 == x2);
    }

    boolean isAvailableNeighborOf(Tile tile) {
        return isNeighborOf(tile) && resident == null;
    }

    @Override
    public String toString() {
        if (resident == null) {
            return "-";
        }

        return resident.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj.getClass() != getClass()) return false;

        Tile tile = (Tile) obj;
        if (tile == null) {
            return false;
        }

        return position.equals(tile.position);
    }
}
