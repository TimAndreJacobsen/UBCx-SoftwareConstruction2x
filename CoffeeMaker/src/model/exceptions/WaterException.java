package model.exceptions;

public class WaterException extends Exception {

    private double waterAsCups;  // volume of water in format cups

    public WaterException(double waterAsCups) {
        super(waterAsCups + " is not enough water");
    }
}
