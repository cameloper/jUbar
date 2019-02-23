package edu.kit.informatik;

class Nature extends Player {
    /**
     * Vesta stone
     */
    Stone vesta;
    /**
     * Ceres stone
     */
    Stone ceres;

    /**
     * Default constructor of {@link Nature}
     */
    Nature() {
        vesta = new Stone(Stone.Type.VESTA);
        ceres = new Stone(Stone.Type.CERES);
    }
}
