package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        try {
            HashMap<String, Tour> tourOffering = TourParser.parseToursCsv();
            ArrayList<Rule> promotionalRules = RuleParser.parseRulesCsv();

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
