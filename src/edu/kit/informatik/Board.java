package edu.kit.informatik;

import java.util.Arrays;

class Board {
    private final Tile[] tiles;

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

        return Arrays.stream(tiles).filter(t -> t.getPosition().equals(point)).findFirst().orElse(null);
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

    private Tile getIfAvailable(Point2D point2D) {
        Tile tile = getTile(point2D);
        if (tile == null) return null;
        return tile.isFull() ? null : tile;
    }

    /**
     * Does a BFS and returns results
     *
     * @param point Center point
     * @param type  For which type of stone the BFS will be
     *              executed
     * @return All reachable tiles
     */
    Tile[] getReachablePoints(Point2D point, Stone.Type type) {
        markReachablePoints(point, type);

        return Arrays.stream(tiles).filter(t -> t.getMarkedFor(type)).toArray(Tile[]::new);

    }

    private void markReachablePoints(Point2D point2D, Stone.Type type) {
        Point2D[] neighbors = point2D.neighbors();
        for (Point2D neighbor : neighbors) {
            Tile tile = getIfAvailable(neighbor);
            if (tile != null && !tile.getMarkedFor(type)) {
                tile.setMarkedFor(type);
                markReachablePoints(neighbor, type);
            }
        }
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
