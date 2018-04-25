public class Rule1 {

    private int id;
    private String name;
    private String tourId;
    private int totalTicketsGiven;
    private int totalTicketsPurchased;

    public Rule1(int id, String name, String tourId, int totalTicketsGiven, int totalTicketsPurchased) {
        this.id = id;
        this.name = name;
        this.tourId = tourId;
        this.totalTicketsGiven = totalTicketsGiven;
        this.totalTicketsPurchased = totalTicketsPurchased;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public int getTotalTicketsGiven() {
        return totalTicketsGiven;
    }

    public void setTotalTicketsGiven(int totalTicketsGiven) {
        this.totalTicketsGiven = totalTicketsGiven;
    }

    public int getTotalTicketsPurchased() {
        return totalTicketsPurchased;
    }

    public void setTotalTicketsPurchased(int totalTicketsPurchased) {
        this.totalTicketsPurchased = totalTicketsPurchased;
    }

    @Override
    public String toString() {
        return "Rule1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tourId='" + tourId + '\'' +
                ", totalTicketsGiven=" + totalTicketsGiven +
                ", totalTicketsPurchased=" + totalTicketsPurchased +
                '}';
    }
}
