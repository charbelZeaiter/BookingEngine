public class Rule3 {

    private int id;
    private String name;
    private String tourId;
    private double newTicketPrice;
    private int greaterThanTreshold;

    public Rule3(int id, String name, String tourId, double newTicketPrice, int greaterThanTreshold) {
        this.id = id;
        this.name = name;
        this.tourId = tourId;
        this.newTicketPrice = newTicketPrice;
        this.greaterThanTreshold = greaterThanTreshold;
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

    public double getNewTicketPrice() {
        return newTicketPrice;
    }

    public void setNewTicketPrice(double newTicketPrice) {
        this.newTicketPrice = newTicketPrice;
    }

    public int getGreaterThanTreshold() {
        return greaterThanTreshold;
    }

    public void setGreaterThanTreshold(int greaterThanTreshold) {
        this.greaterThanTreshold = greaterThanTreshold;
    }

    @Override
    public String toString() {
        return "Rule3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tourId='" + tourId + '\'' +
                ", newTicketPrice=" + newTicketPrice +
                ", greaterThanTreshold=" + greaterThanTreshold +
                '}';
    }
}
