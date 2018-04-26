import java.util.ArrayList;
import java.util.HashMap;

public class Rule2 extends Rule {

    private String freeTourId;

    public Rule2(int id, String name, String tourId, String freeTourId) {
        super(id, name, tourId);
        this.freeTourId = freeTourId;
    }

    public String getFreeTourId() {
        return freeTourId;
    }

    public void setFreeTourId(String freeTourId) {
        this.freeTourId = freeTourId;
    }

    @Override
    public double applyRule(HashMap<String, ArrayList<Tour>> toursDataSet) {

        double amountToAdd = 0.0;

        if(toursDataSet.containsKey(this.getTourId())) {
            ArrayList<Tour> correspondingToursList = toursDataSet.get(this.getTourId());
            int toursCount = correspondingToursList.size();

            if (toursCount / totalTicketsGiven > 0) {
                int multiplier = (totalTicketsGiven - totalTicketsPurchased);
                amountToAdd -= multiplier * ((toursCount / totalTicketsGiven) * correspondingToursList.get(0).getPrice());
            }
        }

        return amountToAdd;
    }

    @Override
    public String toString() {
        return "Rule2{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", tourId='" + super.getTourId() + '\'' +
                ", freeTourId='" + freeTourId + '\'' +
                '}';
    }
}
