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
     * @param width Width of the board
     * @param height Height of the board
     * @return One-dimensional array of Point2D objects
     */
    static Point2D[] boardPoints(int width, int height) {
        Point2D[] output = new Point2D[165];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                output[row * 11 + column] = new Point2D(column, row);
            }
        }

        return output;
    }
}
