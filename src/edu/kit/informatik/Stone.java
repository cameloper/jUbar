package edu.kit.informatik;

class Stone extends Figure {
    /**
     * Coordinates of this stone on a 2 dimensional space
     */
    Point2D position;
    Type type;

    public Stone(Type type) {
        position = null;
        this.type = type;
    }

    enum Type {
        VESTA,
        CERES
    }
}
