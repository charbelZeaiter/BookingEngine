package main;

import java.util.List;
import java.util.Map;

public class Rule1 extends Rule {

    private int totalTicketsGiven;
    private int totalTicketsPurchased;

    public Rule1(int id, String name, String tourId, int totalTicketsGiven, int totalTicketsPurchased) {
        super(id, name, tourId);
        this.totalTicketsGiven = totalTicketsGiven;
        this.totalTicketsPurchased = totalTicketsPurchased;
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
    public double applyRule(Map<String, List<Tour>> toursDataSet) {

        double discount = 0.0;

        if (toursDataSet.containsKey(getTourId())) {
            List<Tour> correspondingToursList = toursDataSet.get(getTourId());
            int toursCount = correspondingToursList.size();

            if (toursCount / totalTicketsGiven > 0) {
                int multiplier = (totalTicketsGiven - totalTicketsPurchased);
                discount += multiplier * ((toursCount / totalTicketsGiven) * correspondingToursList.get(0).getPrice());
            }
        }

        return discount;
    }

    @Override
    public String toString() {
        return "Rule1{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", tourId='" + super.getTourId() + '\'' +
                ", totalTicketsGiven=" + totalTicketsGiven +
                ", totalTicketsPurchased=" + totalTicketsPurchased +
                '}';
    }
}
