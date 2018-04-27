import main.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {

    protected static ArrayList<Rule> ruleSet;
    protected static HashMap<String, Tour> tourSet;
    protected ShoppingCart myShoppingCart;

    @BeforeClass
    public static void setUpOnce() {
        // Given
        ruleSet = new ArrayList<>();
        ruleSet.add(new Rule1(1, "A Test Rule Object", "OH", 3, 2));
        ruleSet.add(new Rule2(2, "A Test Rule Object", "OH", "SK"));
        ruleSet.add(new Rule3(3, "A Test Rule Object", "BC", 20, 4));

        tourSet = new HashMap<>();
        tourSet.put("OH", new Tour("OH", "A Tour", 300.00));
        tourSet.put("BC", new Tour("BC", "A Tour", 110.00));
        tourSet.put("SK", new Tour("SK", "A Tour", 30.00));
    }

    @Before
    public void setUp() {
        myShoppingCart = new ShoppingCart(ruleSet);
    }

    @Test
    public void canAddTour() {
        // Given
        Tour tour = new Tour("OH", "A Name", 300.00);

        // When
        myShoppingCart.add(tour);
        double total = myShoppingCart.total();

        // When Then
        assertThat(total, is(300.00));
    }

    @Test
    public void canCalculateExample1() {
        // Given
        this.myShoppingCart.add(tourSet.get("OH"));
        this.myShoppingCart.add(tourSet.get("OH"));
        this.myShoppingCart.add(tourSet.get("OH"));
        this.myShoppingCart.add(tourSet.get("BC"));

        // When
        double total = this.myShoppingCart.total();

        // Then
        assertThat(total, is(710.00));
    }

    @Test
    public void canCalculateExample2() {
        // Given
        this.myShoppingCart.add(tourSet.get("OH"));
        this.myShoppingCart.add(tourSet.get("SK"));

        // When
        double total = this.myShoppingCart.total();

        // Then
        assertThat(total, is(300.00));
    }

    @Test
    public void canCalculateExample3() {
        // Given
        this.myShoppingCart.add(tourSet.get("BC"));
        this.myShoppingCart.add(tourSet.get("BC"));
        this.myShoppingCart.add(tourSet.get("BC"));
        this.myShoppingCart.add(tourSet.get("BC"));
        this.myShoppingCart.add(tourSet.get("BC"));
        this.myShoppingCart.add(tourSet.get("OH"));

        // When
        double total = this.myShoppingCart.total();

        // Then
        assertThat(total, is(750.00));
    }
}
