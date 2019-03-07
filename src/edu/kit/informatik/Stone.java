package edu.kit.informatik;

class Stone extends Figure {
    /**
     * Coordinates of this stone on a 2 dimensional space
     */
    private Point2D position;
    /**
     * {@link Type} of the stone
     */
    private final Type type;

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
    Point2D getPosition() {
        return position;
    }

    /**
     * Public setter for position
     *
     * @param position New value for variable
     */
    void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public String toString() {
        switch (type) {
            case VESTA:
                return "V";
            case CERES:
                return "C";
            default:
                return "";
        }
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
