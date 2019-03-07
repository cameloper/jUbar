package edu.kit.informatik;

import java.util.Arrays;

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

    /**
     * Gives the tiles with given coordinates
     *
     * @param points Coordinates of the requested Tiles
     * @return Tiles with given coordinates
     */
    Tile[] getTiles(Point2D[] points) {
        return Arrays.stream(points).map(this::getTile).toArray(Tile[]::new);
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        for (int row = 0; row < 11; row++) {
            StringBuilder rowString = new StringBuilder();
            for (int column = 0; column < 15; column++) {
                Tile tile = getTile(new Point2D(column, row));
                rowString.append(tile);
            }

            outString.append(rowString);

            if (row != 10) {
                outString.append("\n");
            }
        }

        return outString.toString();
    }
}
