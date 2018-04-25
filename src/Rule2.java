public class Rule2 {

    private int id;
    private String name;
    private String tourId;
    private String freeTourId;

    public Rule2(int id, String name, String tourId, String freeTourId) {
        this.id = id;
        this.name = name;
        this.tourId = tourId;
        this.freeTourId = freeTourId;
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

    public String getFreeTourId() {
        return freeTourId;
    }

    public void setFreeTourId(String freeTourId) {
        this.freeTourId = freeTourId;
    }

    @Override
    public String toString() {
        return "Rule2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tourId='" + tourId + '\'' +
                ", freeTourId='" + freeTourId + '\'' +
                '}';
    }
}
