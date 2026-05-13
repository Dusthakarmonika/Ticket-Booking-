package ticket.booking.entites;

import java.util.List;
import java.util.Map;

public class Train {

    private String trainNo;
    private String trainID;
    private List<List<Integer>> seats;
    private Map<String,String> stationTimes;
    private List<String> stations;

    public String getTrainNo(){
        return trainNo;
    }
    public String getTrainID(){
        return trainID;
    }
    public List<List<Integer>> getSeats(){
        return seats;
    }
    public Map<String,String> getStationTimes(){
        return stationTimes;
    }
    public List<String> getStations(){
        return stations;
    }
    public void setTrainNo(){
        this.trainNo = trainNo;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public void setStationTimes(Map<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }
    public String getTrainInfo(){
        return String.format("Train ID : %s TrainNo : %s", trainID,trainNo);
    }
}
