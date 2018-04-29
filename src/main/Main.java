package main;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            Map<String, Tour> tourOffering = TourParser.parseToursCsv();
            List<Rule> promotionalRules = RuleParser.parseRulesCsv();

            ShoppingCart sp = new ShoppingCart(promotionalRules);
            sp.add(tourOffering.get("BC"));
            sp.add(tourOffering.get("BC"));
            sp.add(tourOffering.get("BC"));
            sp.add(tourOffering.get("BC"));
            sp.add(tourOffering.get("BC"));

            sp.add(tourOffering.get("OH"));


            sp.total();

        } catch (BookingEngineRunTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
