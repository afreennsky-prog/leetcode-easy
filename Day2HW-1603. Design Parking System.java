class ParkingSystem {
    // Variables to store available slots
    private int big;
    private int medium;
    private int small;

    // Constructor to initialize the parking slots
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    // Method to add a car of given type
    public boolean addCar(int carType) {
        if (carType == 1) { // Big car
            if (big > 0) {
                big--; // occupy one slot
                return true;
            } else {
                return false;
            }
        } else if (carType == 2) { // Medium car
            if (medium > 0) {
                medium--;
                return true;
            } else {
                return false;
            }
        } else if (carType == 3) { // Small car
            if (small > 0) {
                small--;
                return true;
            } else {
                return false;
            }
        }
        return false; // Invalid carType
    }
}
