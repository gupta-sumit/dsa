package design.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Vehicle {

    private List<ParkingSpot> parkingSpotList = new ArrayList<>();
    private final String licenseNumber;
    private final VehicleSize vehicleSize;
    private final int spotsNeeded;

    public Vehicle(String licenseNumber, VehicleSize vehicleSize, int spotsNeeded) {
        this.licenseNumber = licenseNumber;
        this.vehicleSize = vehicleSize;
        this.spotsNeeded = spotsNeeded;
    }

    public void park(List<ParkingSpot> parkingSpots) {
        this.parkingSpotList = parkingSpots;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }


    public VehicleSize getVehicleSize(){
        return vehicleSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(licenseNumber, vehicle.licenseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseNumber);
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpotList;
    }

    public void freeParkingSpace() {
        parkingSpotList = Collections.emptyList();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "parkingSpotList=" + parkingSpotList +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", vehicleSize=" + vehicleSize +
                ", spotsNeeded=" + spotsNeeded +
                '}';
    }
}
