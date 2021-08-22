/*
https://leetcode.com/problems/design-parking-system/
*/

class ParkingSystem {

    int bigCap;
    int mediumCap;
    int smallCap;
    
    public ParkingSystem(int big, int medium, int small) {
        this.bigCap = big;
        this.mediumCap = medium;
        this.smallCap = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1) {
            if(bigCap > 0) {
                bigCap--;
            } else {
                return false;
            }
        } else if(carType == 2) {
            if(mediumCap > 0) {
                mediumCap--;
            } else {
                return false;
            }
        } else if(carType == 3) {
            if(smallCap > 0) {
                smallCap--;
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
