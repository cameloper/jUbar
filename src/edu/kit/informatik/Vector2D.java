package edu.kit.informatik;

class Vector2D {
    /**
     * Starting point of the vector
     */
    private final Point2D head;
    /**
     * Ending point of the vector
     */
    private final Point2D end;

    /**
     * Default constructor for Vector2D
     * @param head Starting point of the vector
     * @param end Ending point of the vector
     */
    Vector2D(Point2D head, Point2D end) {
        this.head = head;
        this.end = end;
    }

    /**
     * Method to find a direct path between head and end
     * @return Array of points that form a direct vertical or horizontal path between
     * head and end of this vector
     */
    Point2D[] directPath() {
        boolean isVertical = head.getX() == end.getX();
        boolean isHorizontal = head.getY() == end.getY();

        Point2D[] out;

        if (isVertical) {
            boolean headIsHigh = head.getY() > end.getY(); // lol

            int lowerPoint = headIsHigh ? end.getY() : head.getY();
            int higherPoint = headIsHigh ? head.getY() : end.getY();
            int x = head.getX();

            out = new Point2D[higherPoint - lowerPoint + 1];
            int i = 0;
            for (int y = lowerPoint; y <=  higherPoint; y++) {
                out[i] = new Point2D(x, y);
                i++;
            }
        } else if (isHorizontal) {
            boolean headIsAhead = head.getX() > end.getX();

            int behindPoint = headIsAhead ? end.getX() : head.getX();
            int aheadPoint = headIsAhead ? head.getX() : end.getX();
            int y = head.getY();

            out = new Point2D[aheadPoint - behindPoint + 1];
            int i = 0;
            for (int x = behindPoint; x <=  aheadPoint; x++) {
                out[i] = new Point2D(x, y);
                i++;
            }
        } else {
            return null;
        }

        return out;
    }

    @Override
    public String toString() {
        return String.format("%s and %s", head, end);
    }
}
