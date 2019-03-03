package edu.kit.informatik;

class Board {
    private Tile[] tiles;

    /**
     * Default constructor for {@link Board}
     */
    Board() {
        Point2D[] coordinates = Point2D.boardPoints();
        tiles = new Tile[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            tiles[i] = new Tile(coordinates[i]);
        }
    }

    /**
     * Gives the tile with given coordinates
     *
     * @param point Coordinates of the requested Tile
     * @return Tile with given coordinates
     */
    Tile getTile(Point2D point) {
        if (point == null) {
            return null;
        }

        for (Tile tile : tiles) {
            if (tile.getPosition().equals(point)) {
                return tile;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        for (int row = 0; row < 11; row++) {
            for (int column = 0; column < 15; column++) {

            }
        }
        return "";
    }
}
