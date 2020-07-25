package design.hotelsystem;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelRoomInventoryManagerImpl implements HotelRoomInventoryManager {

    private String hotelId;
    private Map<Date, DayRoomInventory> availabilityMap = new HashMap<>();

    public HotelRoomInventoryManagerImpl(String hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public List<Room> findAvailableRooms(SearchCriteria searchCriteria) {
        return null;
    }

    public void addAvailability(AvailabiltyUpdateRequest availabilityFillRequest) {

    }

    @Override
    public void reserveRooms(List<RoomBooking> rooms) {

    }


}
