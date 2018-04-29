package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        double total = this.runEngine();

        System.out.println("Items added to the cart:");
        toursDataSet.values().stream()
                .forEach(x -> {
                    x.stream()
                        .forEach(y -> System.out.print(y.getId()+", "));
                });
        System.out.println(" - Total expected: $" + total);

        return total;
    }

    private double runEngine() {
        double currentTotal = toursDataSet.values().stream()
                .map(x -> x.stream()
                        .map(y -> y.getPrice())
                        .mapToDouble(Double::doubleValue).sum())
                .mapToDouble(Double::doubleValue).sum();

        double discount = rules.stream()
                .map(x -> x.applyRule(toursDataSet))
                .mapToDouble(Double::doubleValue).sum();

        currentTotal -= discount;

        return currentTotal;
    }
}
