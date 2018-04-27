import main.Rule3;
import main.Tour;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Rule3Test {

    protected Rule3 rule;

    @Before
    public void setUp() {
        // Given
        this.rule = new Rule3(3, "A Test Rule Object", "BC", 20, 4);
    }

    @Test
    public void canGetDiscount() {
        // When Then
        assertThat(rule.getDiscount(), is(20.00));
    }

    @Test
    public void canSetDiscount() {
        // When
        rule.setDiscount(100.00);

        // Then
        assertThat(rule.getDiscount(), is(100.00));
    }

    @Test
    public void canGetThreshold() {
        // When Then
        assertThat(rule.getThreshold(), is(4));
    }

    @Test
    public void canSetThreshold() {
        // When
        rule.setThreshold(10);

        // Then
        assertThat(rule.getThreshold(), is(10));
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
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(4);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(0.0));
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
        assertThat(discount, is(-120.0));
    }

    @Test
    public void canApplyRuleScenario6() {
        // Given
        this.rule.setThreshold(1);

        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(2);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-40.0));
    }

    @Test
    public void canApplyRuleScenario7() {
        // Given
        this.rule.setThreshold(1);
        this.rule.setDiscount(100.00);
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(25);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-2500.0));
    }

    private HashMap<String, ArrayList<Tour>> generateToursDataSet(int numberOfTours) {
        HashMap<String, ArrayList<Tour>> toursDataSet = new HashMap<>();
        ArrayList<Tour> newList = new ArrayList<>();

        for (int i = 0; i < numberOfTours; i++) {
            newList.add(new Tour(rule.getTourId(), "A Tour", 110.00));
        }

        toursDataSet.put(rule.getTourId(), newList);

        return toursDataSet;
    }
}
