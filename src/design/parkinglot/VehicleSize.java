package design.parkinglot;

public enum VehicleSize {
    SMALL(1),//to park motorcycle
    COMPACT(2),// to park car
    LARGE(3); // to park bus in one or more large spots

    private Integer value;

    VehicleSize(int val) {
        this.value = val;
    }

    public int compare(VehicleSize vehicleSize) {
        return this.value.compareTo(vehicleSize.value);
    }
}
