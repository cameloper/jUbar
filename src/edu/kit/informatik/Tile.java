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
}
