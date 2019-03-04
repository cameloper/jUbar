package edu.kit.informatik;

class Bar extends Figure {
    /**
     * On-Board Position of the Bar
     */
    private Vector2D position;
    /**
     * Symbol of the bar
     */
    private Symbol symbol;

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

    @Override
    public String toString() {
        return "+";
    }
}
