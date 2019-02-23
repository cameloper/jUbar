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
