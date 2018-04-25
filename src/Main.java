import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        try {
            HashMap<String, Tour> tourOffering = TourParser.parseToursCsv();


            System.out.println(tourOffering.toString());


        } catch (BookingEngineRunTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
