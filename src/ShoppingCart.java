import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {

    // Many to many relationship
    private HashMap<String, ArrayList<Rule>> rules;
    private HashMap<String, ArrayList<Tour>> toursToBuy;

    public ShoppingCart(ArrayList<Rule> rules) {
//        this.rules = rules;
        this.toursToBuy = new HashMap<>();
    }

    public void add(Tour tour) {
        if(this.toursToBuy.containsKey(tour.getId())) {
            this.toursToBuy.get(tour.getId()).add(tour);
        } else {
            ArrayList<Tour> newList = new ArrayList<>();
            newList.add(tour);
            this.toursToBuy.put(tour.getId(), newList);
        }
    }

    public double total() {
        double currentTotal = 0.0;





        System.out.println(currentTotal);

        return currentTotal;
    }
}
