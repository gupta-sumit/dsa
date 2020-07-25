package design.hotelsystem;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HotelRoomInventoryManager {


    public List<Room> findAvailableRooms(SearchCriteria searchCriteria);

    public void reserveRooms(List<RoomBooking> roomBookings);

}
