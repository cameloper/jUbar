package com.cameloper.jUbar;

class Nature extends Player {

    /**
     * Vesta stone
     */
    private final Stone vesta;
    /**
     * Ceres stone
     */
    private final Stone ceres;

    /**
     * Default constructor of {@link Nature}
     */
    Nature() {
        vesta = new Stone(Stone.Type.VESTA);
        ceres = new Stone(Stone.Type.CERES);
    }

    /**
     * Public getter of Vesta
     *
     * @return value of private variable Vesta
     */
    Stone getVesta() {
        return vesta;
    }

    /**
     * Public getter of Ceres
     *
     * @return value of private variable Ceres
     */
    Stone getCeres() {
        return ceres;
    }

}
