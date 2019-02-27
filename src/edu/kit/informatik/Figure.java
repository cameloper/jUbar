package edu.kit.informatik;

abstract class Figure {
    /**
     * Casts the instance to a {@link Stone} object
     *
     * @return this instance as a stone
     */
    Stone toStone() {
        return (Stone) this;
    }

    /**
     * Casts this instance to a {@link Bar} object
     *
     * @return this instance as a bar
     */
    Bar toBar() {
        return (Bar) this;
    }

    /**
     * Gives which type of figure this instance is
     *
     * @return Type of this instance
     */
    Type type() {
        if (getClass() == Stone.class) {
            return Type.STONE;
        } else if (getClass() == Bar.class) {
            return Type.BAR;
        } else {
            return null;
        }
    }

    enum Type {
        STONE,
        BAR
    }
}
