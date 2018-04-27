package test.java;

import main.java.Tour;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TourTest {

    protected Tour tour;

    @Before
    public void setUp() {
        // Given
        this.tour = new Tour("OH", "A Test Tour Object", 100.00);
    }

    @Test
    public void canGetTourId() {
        // When Then
        assertThat(tour.getId(), is("OH"));
    }

    @Test
    public void canGetTourName() {
        // When Then
        assertThat(tour.getName(), is("A Test Tour Object"));
    }

    @Test
    public void canGetTourPrice() {
        // When Then
        assertThat(tour.getPrice(), is(100.00));
    }

    @Test
    public void canSetTourId() {
         // When
        tour.setId("ZZ");

        // Then
        assertThat(tour.getId(), is("ZZ"));
    }

    @Test
    public void canSetTourName() {
        // When
        tour.setName("Another name");

        // Then
        assertThat(tour.getName(), is("Another name"));
    }

    @Test
    public void canSetTourPrice() {
        // When
        tour.setPrice(5.00);

        // Then
        assertThat(tour.getPrice(), is(5.00));
    }
}
