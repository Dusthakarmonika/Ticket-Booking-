package ticket.booking.entites;

import java.util.List;

public class Train {

    private String trainNo;
    private String trainID;
    private List<List<Integer>> seats;
    private Map<String,Time> stationTimes;
    private List<String> stations;
}
