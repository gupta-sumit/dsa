package design.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {

    private int levelNumber;
    private List<ParkingSpot> parkingSpots = Collections.emptyList();

    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getNextFreeSpot(Vehicle vehicle) {
        int parkingSpotsRequired = vehicle.getSpotsNeeded();
        int lastAvailableSpotIndex = -1;
        int row = -1;
        for(int i=0; i < parkingSpots.size(); i++) {
            if(row == -1) {
                row = parkingSpots.get(i).getRow();
            } else {
                if(parkingSpots.get(i).getRow() != row) {
                    lastAvailableSpotIndex = -1;
                    row = parkingSpots.get(i).getRow();
                }
            }
            if(parkingSpots.get(i).isAvailable()) {
                if(lastAvailableSpotIndex == -1) {
                    lastAvailableSpotIndex = i;
                }
                if(hasEnoughSpace(parkingSpots.get(i), vehicle)) {
                    if(canVehicleFit(lastAvailableSpotIndex, i, vehicle, parkingSpots.get(i))) {
                        return lastAvailableSpotIndex;
                    }
                } else {
                    lastAvailableSpotIndex = -1;
                }
            } else {
                lastAvailableSpotIndex = -1;
            }
        }
        return -1;
    }

    private boolean hasEnoughSpace(ParkingSpot parkingSpot, Vehicle vehicle) {
        return parkingSpot.getSpotSize().compare(vehicle.getVehicleSize()) >= 0;
    }

    private boolean canVehicleFit(int lastAvailableSpotIndex, int i, Vehicle vehicle, ParkingSpot parkingSpot) {
        if(i - lastAvailableSpotIndex + 1 == vehicle.getSpotsNeeded()) {
            return true;
        }
        return false;
    }


    public boolean park(Vehicle vehicle) {
        int nextFreeSpot = getNextFreeSpot(vehicle);
        if(nextFreeSpot != -1) {
            int i = nextFreeSpot;
            int k = i;
            List<ParkingSpot> allocatedParkingSpots = new ArrayList<>();
            while(i < k + vehicle.getSpotsNeeded()) {
                parkingSpots.get(i).assign(vehicle);
                allocatedParkingSpots.add(parkingSpots.get(i));
                i++;
            }
            vehicle.park(allocatedParkingSpots);
            return true;
        }
        return false;
    }

    public void remove(Vehicle vehicle) {
        List<ParkingSpot> parkingSpots = vehicle.getParkingSpots();
        parkingSpots.forEach(parkingSpot -> parkingSpot.remove(vehicle));
        vehicle.freeParkingSpace();
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelNumber=" + levelNumber +
                '}';
    }
}
