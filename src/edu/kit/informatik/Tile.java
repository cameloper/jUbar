package edu.kit.informatik;

class Tile {
    private final Point2D position;
    private Figure resident;

    private boolean markedForVesta = false;
    private boolean markedForCeres = false;

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
     * Public setter for BFS markers
     *
     * @param stone BFS Stone
     */
    void setMarkedFor(Stone.Type stone) {
        switch (stone) {
            case CERES:
                markedForCeres = true;
                break;
            case VESTA:
                markedForVesta = true;
                break;
            default:
        }
    }

    /**
     * Public getter of BFS markers
     *
     * @param stone BFS Stone
     * @return Marker value
     */
    boolean getMarkedFor(Stone.Type stone) {
        switch (stone) {
            case CERES:
                return markedForCeres;
            case VESTA:
                return markedForVesta;
            default:
                return false;
        }
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

    /**
     * Gives whether or not the given tile is adjacent to this instance
     *
     * @param tile supposed neighbor
     * @return true if two tiles are neighbors
     */
    boolean isNeighborOf(Tile tile) {
        int x1 = position.getX();
        int x2 = tile.position.getX();

        int y1 = position.getY();
        int y2 = tile.position.getY();

        return ((x1 - x2 == 1 || x2 - x1 == 1) && y1 == y2)
                != ((y1 - y2 == 1 || y2 - y1 == 1) && x1 == x2);
    }

    /**
     * Gives whether or not the given tile is adjacent to this instance and is empty
     *
     * @param tile supposed neighbor
     * @return true if tiles are neighbors and given tile is empty
     */
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
        if (this == obj) return true;

        if (obj.getClass() != getClass()) return false;

        Tile tile = (Tile) obj;

        return position.equals(tile.position);
    }
}
