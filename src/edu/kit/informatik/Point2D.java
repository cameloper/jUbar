package edu.kit.informatik;

class Point2D {
    /**
     * Position on the X-Axis
     */
    private int x;
    /**
     * Position on the Y-Axis
     */
    private int y;

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
     * @return
     */
    static Point2D parse(String input) {
        String[] components = input.split(";");
        int x = Integer.parseInt(components[0]);
        int y = Integer.parseInt(components[1]);
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
                output[row * 11 + column] = new Point2D(column, row);
            }
        }

        return output;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        Point2D point2D = (Point2D) obj;
        if (point2D == null) {
            return false;
        }

        return point2D.x == x && point2D.y == y;
    }
}
