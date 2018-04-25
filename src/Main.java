import com.sun.deploy.security.ruleset.RuleSetParser;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        try {
            HashMap<String, Tour> tourOffering = TourParser.parseToursCsv();
            ArrayList<Rule> rulesStore = RuleParser.parseRulesCsv();

            System.out.println(tourOffering.toString());
            System.out.println(rulesStore.toString());

            ShoppingCart sp = new ShoppingCart(rulesStore);
            sp.add(tourOffering.get("OH"));
            sp.add(tourOffering.get("OH"));
            sp.total();

        } catch (BookingEngineRunTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
