package design.parkinglot;

public class Bus extends Vehicle {

    public Bus(String licenseNumber) {
        super(licenseNumber, VehicleSize.LARGE, 5);
    }
}
