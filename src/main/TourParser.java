package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TourParser {

    private static final String FILE_PATH = "resources/tours.csv";

    public static Map<String, Tour> parseToursCsv() throws BookingEngineRunTimeException {

        Map<String, Tour> tourOffering;

        try {
            Stream<String> rowsStream = Files.lines(Paths.get(FILE_PATH));
            tourOffering = rowsStream
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(cols -> {
                        cols[0] = cols[0].trim();
                        cols[1] = cols[1].trim();
                        cols[2] = cols[2].trim();
                        return cols;
                    })
                    .collect(Collectors.toMap(
                            cols -> cols[0],
                            cols -> new Tour(cols[0], cols[1], Double.parseDouble(cols[2]))));
            rowsStream.close();
        } catch (IOException e) {
            throw new BookingEngineRunTimeException(e);
        }


        return tourOffering;
    }

}
