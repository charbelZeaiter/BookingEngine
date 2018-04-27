package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Rule3 extends Rule {

    private double discount;
    private int threshold;

    public Rule3(int id, String name, String tourId, double discount, int threshold) {
        super(id, name, tourId);
        this.discount = discount;
        this.threshold = threshold;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public double applyRule(HashMap<String, ArrayList<Tour>> toursDataSet) {

        double amountToAdd = 0.0;

        if(toursDataSet.containsKey(this.getTourId())) {
            ArrayList<Tour> tourList = toursDataSet.get(this.getTourId());
            if(tourList.size() > threshold) {
                amountToAdd -= discount*tourList.size();
            }
        }

        return amountToAdd;
    }

    @Override
    public String toString() {
        return "Rule3{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", tourId='" + super.getTourId() + '\'' +
                ", discount=" + discount +
                ", threshold=" + threshold +
                '}';
    }
}
