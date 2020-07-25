package design.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<String, ParkedVehicle> parkedVehicleRepo = new HashMap<>();
    private List<Level> levels;

    public ParkingLot(List<Level> levels) {
        this.levels = levels;
    }

    public boolean isAvailable(Vehicle vehicle) {
        for(Level level : levels) {
            int nextFreeSpot = level.getNextFreeSpot(vehicle);
            if(nextFreeSpot != -1) {
                return true;
            }
        }
        return false;
    }


    public boolean assignParking(Vehicle vehicle) {
        int i = 0;
        for(Level level : levels) {
            int nextFreeSpot = level.getNextFreeSpot(vehicle);
            if(nextFreeSpot != -1) {
                boolean parked = level.park(vehicle);
                if(parked) {
                    parkedVehicleRepo.put(vehicle.getLicenseNumber(), new ParkedVehicle(i, vehicle));
                }
            }
            i++;
        }
        return false;
    }

    public boolean remove(String licenseNumber) {
        if(parkedVehicleRepo.containsKey(licenseNumber)) {
            ParkedVehicle parkedVehicle = parkedVehicleRepo.get(licenseNumber);
            levels.get(parkedVehicle.level).remove(parkedVehicle.vehicle);
            return true;
        }
        return false;
    }

    private static class ParkedVehicle {
        private final int level;
        private final Vehicle vehicle;

        public ParkedVehicle(int level, Vehicle vehicle) {
            this.level = level;
            this.vehicle = vehicle;
        }
    }
}
