package com.cameloper.jUbar;

class Bar extends Figure {
    /**
     * On-Board Position of the Bar.
     */
    private Vector2D position;
    /**
     * Symbol of the bar
     */
    private final Symbol symbol;

    /**
     * Default constructor for {@link Bar}
     * @param symbol Symbol of the bar
     */
    Bar(Symbol symbol) {
        this.position = null;
        this.symbol = symbol;
    }

    /**
     * Public getter of Symbol
     *
     * @return value of private variable Symbol
     */
    Symbol getSymbol() {
        return symbol;
    }

    /**
     * Public getter of Position
     *
     * @return value of private variable Position
     */
    Vector2D getPosition() {
        return position;
    }

    /**
     * Public setter for position
     *
     * @param position New value for variable
     */
    void setPosition(Vector2D position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "+";
    }
}
