package edu.kit.informatik;

class Stone extends Figure {
    /**
     * Coordinates of this stone on a 2 dimensional space
     */
    private Point2D position;
    /**
     * {@link Type} of the stone
     */
    private Type type;

    /**
     * Default constructor of {@link Stone}
     * @param type {@link Type} type of the requested stone
     */
    Stone(Type type) {
        position = null;
        this.type = type;
    }

    /**
     * Public getter of Position
     *
     * @return value of private variable Position
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * Public setter for position
     *
     * @param position New value for variable
     */
    public void setPosition(Point2D position) {
        this.position = position;
    }

    enum Type {
        /**
         * Vesta stone type
         */
        VESTA,
        /**
         * Ceres stone type
         */
        CERES
    }
}
