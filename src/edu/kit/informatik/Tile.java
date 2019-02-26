package edu.kit.informatik;

class Tile {
    private Figure resident;

    /**
     * Public getter of Resident
     *
     * @return value of private variable Resident
     */
    public Figure getResident() {
        return resident;
    }

    /**
     * Public setter for resident
     *
     * @param resident New value for variable
     */
    public void setResident(Figure resident) {
        this.resident = resident;

    }
}
