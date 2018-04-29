package main;

import java.util.*;

public class ShoppingCart {

    private List<Rule> rules;
    private Map<String, List<Tour>> toursDataSet;

    public ShoppingCart(List<Rule> rules) {
        this.rules = rules;
        this.toursDataSet = new HashMap<>();
    }

    public void add(Tour tour) {
        if (this.toursDataSet.containsKey(tour.getId())) {
            this.toursDataSet.get(tour.getId()).add(tour);
        } else {
            List<Tour> newList = new ArrayList<>();
            newList.add(tour);
            this.toursDataSet.put(tour.getId(), newList);
        }
    }

    public double total() {

        StringBuilder strBuilder = new StringBuilder();

        double currentTotal = this.runEngine(strBuilder);

        System.out.println("Items added to the cart:");
        System.out.println(strBuilder.toString() + " - Total expected: $" + currentTotal);

        return currentTotal;
    }

    private double runEngine(StringBuilder strBuilder) {
        double currentTotal = 0.0;

        Iterator it = this.toursDataSet.values().iterator();
        if (it.hasNext()) {
            while (it.hasNext()) {
                List<Tour> toursTypeList = (List<Tour>) it.next();

                // Apply all prices
                for (Tour entry : toursTypeList) {
                    strBuilder.append(entry.getId() + ", ");
                    currentTotal += entry.getPrice();
                }
            }
            strBuilder.delete(strBuilder.lastIndexOf(","), strBuilder.length());
        }

        // Apply discounts
        for (Rule entry : rules) {
            currentTotal += entry.applyRule(toursDataSet);
        }

        return currentTotal;
    }
}
