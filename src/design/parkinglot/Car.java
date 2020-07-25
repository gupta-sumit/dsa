package design.parkinglot;

public class Car extends Vehicle{

    public Car(String licenseNumber) {
        super(licenseNumber, VehicleSize.COMPACT, 1);
    }
}
