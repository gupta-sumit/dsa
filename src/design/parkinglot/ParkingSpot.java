package design.parkinglot;

import java.util.Arrays;

public class ParkingSpot {

    private Vehicle parkedVehicle;
    private boolean available = true;
    private Level level;
    private int row;
    private int spotNumber;
    private VehicleSize spotSize;

    public ParkingSpot(Level level, int row, int spotNumber, VehicleSize spotSize) {
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
        this.spotSize = spotSize;
    }

    public void assign(Vehicle vehicle){
        parkedVehicle = vehicle;
        available = false;
    }

    public boolean isAvailable() {
        return available;
    }

    public void remove(Vehicle vehicle) {
        if(!available && parkedVehicle != null && parkedVehicle.equals(vehicle)) {
            parkedVehicle = null;
            available = true;
        }
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "available=" + available +
                ", level=" + level +
                ", row=" + row +
                ", spotNumber=" + spotNumber +
                ", spotSize=" + spotSize +
                '}';
    }
}
