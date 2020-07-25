package design.parkinglot;

import algo.utils.ConsolePrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotTesting {

    public static void main(String[] args) {

        Level level = new Level(1);
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.addAll(createParkingSpots(1,10,VehicleSize.SMALL, level));
        parkingSpots.addAll(createParkingSpots(2,10,VehicleSize.COMPACT, level));
        parkingSpots.addAll(createParkingSpots(3,10,VehicleSize.LARGE, level));
        level.setParkingSpots(parkingSpots);

        ParkingLot parkingLot = new ParkingLot(Arrays.asList(level));

        Vehicle vehicle = new Car("1234");

        boolean available = parkingLot.isAvailable(vehicle);
        if(available) parkingLot.assignParking(vehicle);
        ConsolePrinter.out(vehicle);

        Vehicle bus = new Bus("1235");
        available = parkingLot.isAvailable(bus);
        if(available) parkingLot.assignParking(bus);
        ConsolePrinter.out(bus);


        for(int i=0 ; i< 12; i++) {
            Vehicle car = new Car("123ac" + i);

            available = parkingLot.isAvailable(car);
            if(available) parkingLot.assignParking(car);
            ConsolePrinter.out(car);
        }
        parkingLot.remove("1235");
        ConsolePrinter.out(bus);


        available = parkingLot.isAvailable(bus);
        if(available) parkingLot.assignParking(bus);
        ConsolePrinter.out(bus);

    }

    public static List<ParkingSpot> createParkingSpots(int row, int spots, VehicleSize size, Level level) {
        List<ParkingSpot> parkingSpots = new ArrayList<>(spots);
        for(int i=0; i < spots; i++) {
            parkingSpots.add(new ParkingSpot(level, row, i, size));
        }
        return parkingSpots;
    }
}
