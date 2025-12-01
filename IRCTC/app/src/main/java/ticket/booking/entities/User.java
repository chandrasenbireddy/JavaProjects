package ticket.booking.entities;

import java.util.List;

public class User {
    private String name;
    private String password;
    private String hashPassword;
    private List<Ticket> bookedTickets;
    private String userId;

    public User(String name, String password, String hashPassword, String userId, List<Ticket> bookedTickets) {
        this.name = name;
        this.password = password;
        this.hashPassword = hashPassword;
        this.userId = userId;
        this.bookedTickets = bookedTickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void printTickets() {
        for(Ticket ticket: bookedTickets) {
            System.out.println(ticket.getTicketInfo());
        }
    }

}
