package edu.kit.informatik;

class Point2D {
    /**
     * Position on the X-Axis
     */
    private final int x;
    /**
     * Position on the Y-Axis
     */
    private final int y;

    /**
     * Default constructor for Point2D
     * @param x Position in x-Axis
     * @param y Position in y-Axis
     */
    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Generates a Point2D object using raw input String
     * @param input Input String
     * @return Point2D object
     * @throws NumberFormatException If the components of given string do not match a valid number
     */
    static Point2D parse(String input) throws NumberFormatException {
        String[] components = input.split(";");
        int x = Integer.parseInt(components[1]);
        int y = Integer.parseInt(components[0]);
        return new Point2D(x, y);
    }

    /**
     * Public getter of X
     *
     * @return value of private variable X
     */
    int getX() {
        return x;
    }

    /**
     * Public getter of Y
     *
     * @return value of private variable Y
     */
    int getY() {
        return y;
    }

    /**
     * Generates an array of Point2D objects with given number of rows and columns
     * @return One-dimensional array of Point2D objects
     */
    static Point2D[] boardPoints() {
        Point2D[] output = new Point2D[165];
        for (int row = 0; row < 11; row++) {
            for (int column = 0; column < 15; column++) {
                output[row * 15 + column] = new Point2D(column, row);
            }
        }

        return output;
    }

    /**
     * Gets all adjacent Points of this instance
     *
     * @return N, W, E, S of the center point
     */
    Point2D[] neighbors() {
        return new Point2D[]{
                west(),
                north(),
                east(),
                south()
        };
    }

    private Point2D west() {
        return new Point2D(x - 1, y);
    }

    private Point2D north() {
        return new Point2D(x, y + 1);
    }

    private Point2D east() {
        return new Point2D(x + 1, y);
    }

    private Point2D south() {
        return new Point2D(x, y - 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj.getClass() != getClass()) return false;

        Point2D point2D = (Point2D) obj;
        if (point2D == null) return false;

        return point2D.x == x && point2D.y == y;
    }
}
