package design.parkinglot;

public class Bike extends Vehicle {

    public Bike(String licenseNumber) {
        super(licenseNumber, VehicleSize.SMALL, 1);
    }
}
