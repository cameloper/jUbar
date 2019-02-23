package edu.kit.informatik;

class Nature extends Player {
    Stone vesta;
    Stone ceres;

    Nature() {
        vesta = new Stone(Stone.Type.VESTA);
        ceres = new Stone(Stone.Type.CERES);
    }
}
