package main;

import java.util.List;
import java.util.Map;

public abstract class Rule {

    private int id;
    private String name;
    private String tourId;

    public Rule(int id, String name, String tourId) {
        this.id = id;
        this.name = name;
        this.tourId = tourId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public abstract double applyRule(Map<String, List<Tour>> toursDataSet);
}
