package design.hotelsystem;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Tariff {
    private String id;
    private String hotelId;
    private RoomType roomType;
    private PricingDetails basePriceDetails;
    private Map<Date, PricingDetails> dayWisePriceDetails;
    private List<Inclusion> inclusions;

    public PricingDetails getPriceDetails(Date date) {
        return null;
    }
}
