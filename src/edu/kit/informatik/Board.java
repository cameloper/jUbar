package edu.kit.informatik;

import java.util.ArrayList;

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
        ArrayList<Tile> tiles = new ArrayList<>();
        for (Point2D point : points) {
            Tile tile = getTile(point);
            if (tile != null) {
                tiles.add(tile);
            }
        }
        return tiles.toArray(new Tile[tiles.size()]);
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        for (int row = 0; row < 11; row++) {
            StringBuilder rowstring = new StringBuilder();
            for (int column = 0; column < 15; column++) {
                Tile tile = getTile(new Point2D(column, row));
                if (column != 0) {
                    rowstring.append(" ");
                }

                rowstring.append(tile);
            }

            outString.append(rowstring);

            if (row != 10) {
                outString.append("\n");
            }
        }

        return outString.toString();
    }
}
