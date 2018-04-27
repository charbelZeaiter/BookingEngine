package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TourParser {

    private static final String FILE_PATH = "resources/tours.csv";

    public static HashMap<String, Tour> parseToursCsv() throws BookingEngineRunTimeException {

        HashMap<String, Tour> tourOffering = new HashMap<>();

        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            // Skip column headings.
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String csvLine = scanner.nextLine();
                String[] columns = csvLine.split(",");

                String id = columns[0];
                String name = columns[1];
                double price = Double.parseDouble(columns[2]);
                tourOffering.put(id, new Tour(id, name, price));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new BookingEngineRunTimeException(e);
        }

        return tourOffering;
    }

}
