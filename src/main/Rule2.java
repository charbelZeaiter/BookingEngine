package main;

import java.util.List;
import java.util.Map;

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
    public double applyRule(Map<String, List<Tour>> toursDataSet) {

        double discount = 0.0;

        if(toursDataSet.containsKey(getTourId())) {
            if(toursDataSet.containsKey(freeTourId)) {
                int tour1Count = toursDataSet.get(getTourId()).size();
                int tour2Count = toursDataSet.get(freeTourId).size();

                while(tour1Count > 0 && tour2Count > 0) {
                    discount += toursDataSet.get(freeTourId).get(0).getPrice();
                    tour1Count--;
                    tour2Count--;
                }
            }
        }

        return discount;
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
