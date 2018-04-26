import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ShoppingCart {

    private ArrayList<Rule> rules;
    private HashMap<String, ArrayList<Tour>> toursDataSet;

    public ShoppingCart(ArrayList<Rule> rules) {
        this.rules = rules;
        this.toursDataSet = new HashMap<>();
    }

    public void add(Tour tour) {
        if (this.toursDataSet.containsKey(tour.getId())) {
            this.toursDataSet.get(tour.getId()).add(tour);
        } else {
            ArrayList<Tour> newList = new ArrayList<>();
            newList.add(tour);
            this.toursDataSet.put(tour.getId(), newList);
        }
    }

    public double total() {
        double currentTotal = 0.0;
        StringBuilder strBuilder = new StringBuilder();

        Iterator it = this.toursDataSet.values().iterator();
        while(it.hasNext()) {
            ArrayList<Tour> toursTypeList = (ArrayList<Tour>) it.next();

            // Apply all prices
            for(Tour entry : toursTypeList) {
                strBuilder.append(entry.getId()+", ");
                currentTotal += entry.getPrice();
            }
        }
        strBuilder.delete(strBuilder.lastIndexOf(","), strBuilder.length());

        // Apply discounts
        for(Rule entry : rules){
            currentTotal += entry.applyRule(toursDataSet);
        }

        System.out.println("Items added to the cart:");
        System.out.println(strBuilder.toString() + " - Total expected: $" + currentTotal);

        return currentTotal;
    }
}
