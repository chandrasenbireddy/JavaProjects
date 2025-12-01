package ticket.booking.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String, String> schedule;
    private List<String> stations;

    public Train(String trainId, String trainNo, List<List<Integer>> seats, Map<String, String> schedule, List<String> stations) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seats = seats;
        this.schedule = schedule;
        this.stations = stations;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public Map<String, String> getSchedules() {
        return schedule;
    }

    public void setSchedules(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }
    public String getTrainInfo() {
       return String.format("Train No: %s, Stations: %s, Schedules: %s", trainNo, stations.toString(), schedule.toString());
    }
}
