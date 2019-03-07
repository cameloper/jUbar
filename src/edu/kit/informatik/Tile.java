package edu.kit.informatik;

class Tile {
    private Point2D position;
    private Figure resident;

    /**
     * Default constructor for Tile
     * @param position position of the tile
     */
    public Tile(Point2D position) {
        this.position = position;
    }

    /**
     * Public getter of Position
     *
     * @return value of private variable Position
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * Public getter of Resident
     *
     * @return value of private variable Resident
     */
    public Figure getResident() {
        return resident;
    }

    /**
     * Public setter for resident
     *
     * @param resident New value for variable
     */
    public void setResident(Figure resident) {
        this.resident = resident;

    }

    /**
     * Gives if the tile is occupied by a {@link Figure} or not
     *
     * @return true or false
     */
    public boolean isFull() {
        return resident != null;
    }

    public boolean isNeighborOf(Tile tile) {
        int x1 = position.getX();
        int x2 = tile.position.getX();

        int y1 = position.getY();
        int y2 = tile.position.getY();

        return x1 - x2 == 1 || x2 - x1 == 1 || y1 - y2 == 1 || y2 - y1 == 1;
    }

    public boolean isAvailableNeighborOf(Tile tile) {
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

        Tile tile = (Tile) obj;
        if (tile == null) {
            return false;
        }

        return position.equals(tile.position);
    }
}
