package test.java;

import main.java.Rule2;
import main.java.Tour;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Rule2Test {

    protected Rule2 rule;

    @Before
    public void setUp() {
        // Given
        this.rule = new Rule2(2, "A Test Rule Object", "OH", "SK");
    }

    @Test
    public void canGetFreeTourId() {
        // When Then
        assertThat(rule.getFreeTourId(), is("SK"));
    }

    @Test
    public void canSetFreeTourId() {
        // When
        rule.setFreeTourId("JH");

        // Then
        assertThat(rule.getFreeTourId(), is("JH"));
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
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(1, 0);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(0.0));
    }

    @Test
    public void canApplyRuleScenario2() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(1, 1);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-50.0));
    }


    @Test
    public void canApplyRuleScenario3() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(0, 1);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(0.0));
    }

    @Test
    public void canApplyRuleScenario4() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(5, 5);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-250.00));
    }

    @Test
    public void canApplyRuleScenario5() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(1, 10);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(-50.0));
    }

    @Test
    public void canApplyRuleScenario6() {
        // Given
        HashMap<String, ArrayList<Tour>> toursDataSet = generateToursDataSet(0, 0);

        // When
        double discount = rule.applyRule(toursDataSet);

        // Then
        assertThat(discount, is(0.0));
    }

    private HashMap<String, ArrayList<Tour>> generateToursDataSet(int numOfXTours, int numOfYTours) {
        HashMap<String, ArrayList<Tour>> toursDataSet = new HashMap<>();
        ArrayList<Tour> listX = new ArrayList<>();
        ArrayList<Tour> listY = new ArrayList<>();

        for (int i = 0; i < numOfXTours; i++) {
            listX.add(new Tour(rule.getTourId(), "A Tour", 100.00));
        }

        for (int i = 0; i < numOfYTours; i++) {
            listY.add(new Tour(rule.getFreeTourId(), "A Tour", 50.00));
        }

        toursDataSet.put(rule.getTourId(), listX);
        toursDataSet.put(rule.getFreeTourId(), listY);

        return toursDataSet;
    }
}
