package main.java;

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

        if(toursDataSet.containsKey(getTourId())) {
            if(toursDataSet.containsKey(freeTourId)) {
                int tour1Count = toursDataSet.get(getTourId()).size();
                int tour2Count = toursDataSet.get(freeTourId).size();

                while(tour1Count > 0 && tour2Count > 0) {
                    amountToAdd -= toursDataSet.get(freeTourId).get(0).getPrice();
                    tour1Count--;
                    tour2Count--;
                }
            }
        }

        return amountToAdd;
    }

    @Override
    public String toString() {
        return "main.java.Rule2{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", tourId='" + super.getTourId() + '\'' +
                ", freeTourId='" + freeTourId + '\'' +
                '}';
    }
}
