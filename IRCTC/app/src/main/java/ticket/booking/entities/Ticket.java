package ticket.booking.entities;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private String travelDate;
    private Train train;

    public Ticket(String ticketId, String userId, String source, String destination, String travelDate, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
        this.train = train;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
    public String getTicketInfo() {
        return "Ticket ID: " + ticketId + ", User ID: " + userId + ", Source: " + source +
                ", Destination: " + destination + ", Travel Date: " + travelDate +
                ", Train Info: [" + train.getTrainInfo() + "]";
    }
}
