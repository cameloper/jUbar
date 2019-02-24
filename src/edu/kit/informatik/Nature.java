package edu.kit.informatik;

class Nature extends Player {

    /**
     * Vesta stone
     */
    private Stone vesta;
    /**
     * Ceres stone
     */
    private Stone ceres;

    /**
     * Default constructor of {@link Nature}
     */
    Nature() {
        vesta = new Stone(Stone.Type.VESTA);
        ceres = new Stone(Stone.Type.CERES);
    }

    /**
     * Public getter of Vesta
     * @return value of private variable Vesta
     */
    public Stone getVesta() {
        return vesta;
    }

    /**
     * Public getter of Ceres
     * @return value of private variable Ceres
     */
    public Stone getCeres() {
        return ceres;
    }

}
