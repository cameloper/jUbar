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
}
