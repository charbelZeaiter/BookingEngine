package main;

import java.util.List;
import java.util.Map;

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
    public double applyRule(Map<String, List<Tour>> toursDataSet) {

        double discount = 0.0;

        if (toursDataSet.containsKey(this.getTourId())) {
            List<Tour> tourList = toursDataSet.get(this.getTourId());
            if (tourList.size() > threshold) {
                discount += this.discount * tourList.size();
            }
        }

        return discount;
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
