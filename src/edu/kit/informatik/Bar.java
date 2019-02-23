package edu.kit.informatik;

class Bar extends Figure {
    /**
     * On-Board Position of the Bar
     */
    Vector2D position;
    /**
     * Symbol of the bar
     */
    Symbol symbol;

    /**
     * Default constructor for {@link Bar}
     * @param symbol Symbol of the bar
     */
    public Bar(Symbol symbol) {
        this.position = null;
        this.symbol = symbol;
    }
}
