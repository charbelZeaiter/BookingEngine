import java.util.ArrayList;
import java.util.HashMap;

public class Rule3 extends Rule {

    private double newTicketPrice;
    private int greaterThanTreshold;

    public Rule3(int id, String name, String tourId, double newTicketPrice, int greaterThanTreshold) {
        super(id, name, tourId);
        this.newTicketPrice = newTicketPrice;
        this.greaterThanTreshold = greaterThanTreshold;
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
    public double applyRule(HashMap<String, ArrayList<Tour>> toursDataSet) {
        return 0;
    }

    @Override
    public String toString() {
        return "Rule3{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", tourId='" + super.getTourId() + '\'' +
                ", newTicketPrice=" + newTicketPrice +
                ", greaterThanTreshold=" + greaterThanTreshold +
                '}';
    }
}
