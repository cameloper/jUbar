package edu.kit.informatik;

import java.util.HashMap;

class Board {
    private HashMap<Point2D, Tile> tiles;

    /**
     * Default constructor for {@link Board}
     */
    Board() {
        Point2D[] coordinates = Point2D.boardPoints(15, 11);
        tiles = new HashMap<>();
        for (Point2D point : coordinates) {
            tiles.put(point, new Tile());
        }
    }

    /**
     * Gives the tile with given coordinates
     * @param point Coordinates of the requested Tile
     * @return Tile with given coordinates
     */
    Tile getTile(Point2D point) {
        if (point == null) {
            return null;
        }

        return tiles.get(point);
    }
}

