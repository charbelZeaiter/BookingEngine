import main.Rule1;
import main.Tour;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Rule1Test {

    protected Rule1 rule;

    @Before
    public void setUp() {
        // Given
        this.rule = new Rule1(1, "A Test Rule Object", "OH", 3, 2);
    }

    @Test
    public void canGetTotalTicketsGiven() {
        // When Then
        assertThat(rule.getTotalTicketsGiven(), is(3));
    }

    @Test
    public void canSetTotalTicketsGiven() {
        // When
        rule.setTotalTicketsGiven(10);

        // Then
        assertThat(rule.getTotalTicketsGiven(), is(10));
    }

    @Test
    public void canGetTotalTicketsPurchased() {
        // When Then
        assertThat(rule.getTotalTicketsPurchased(), is(2));
    }

    @Test
    public void canSetTotalTicketsPurchased() {
        // When
        rule.setTotalTicketsPurchased(1);

        // Then
        assertThat(rule.getTotalTicketsPurchased(), is(1));
    }

    @Test
    public void canApplyRuleWhenDoesNotApply() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = new HashMap<>();

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(0.0));
    }

    @Test
    public void canApplyRuleScenario1() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(1);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(0.0));
    }

    @Test
    public void canApplyRuleScenario2() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(2);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(0.0));
    }


    @Test
    public void canApplyRuleScenario3() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(3);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-100.0));
    }

    @Test
    public void canApplyRuleScenario4() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(5);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-100.0));
    }

    @Test
    public void canApplyRuleScenario5() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(6);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-200.0));
    }

    @Test
    public void canApplyRuleScenario6() {
        // Given
        this.rule.setTotalTicketsGiven(5);
        this.rule.setTotalTicketsPurchased(1);
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(25);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-2000.0));
    }

    @Test
    public void canApplyRuleScenario7() {
        // Given
        this.rule.setTotalTicketsGiven(1);
        this.rule.setTotalTicketsPurchased(1);
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(25);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(0.0));
    }

    private HashMap<String, ArrayList<Tour>> generateToursDataSet(int numberOfTours) {
        HashMap<String, ArrayList<Tour>> toursDataSet = new HashMap<>();
        ArrayList<Tour> newList = new ArrayList<>();

        for (int i = 0; i < numberOfTours; i++) {
            newList.add(new Tour(rule.getTourId(), "A Tour", 100.00));
        }

        toursDataSet.put(rule.getTourId(), newList);

        return toursDataSet;
    }
}
