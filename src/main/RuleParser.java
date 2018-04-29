package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RuleParser {

    private static final String FILE_PATH = "resources/rules.csv";

    public static List<Rule> parseRulesCsv() throws BookingEngineRunTimeException {

        List<Rule> rules;

        try {
            Stream<String> rowsStream = Files.lines(Paths.get(FILE_PATH));
            rules = rowsStream
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(cols -> {
                        cols[0] = cols[0].trim();
                        cols[1] = cols[1].trim();
                        cols[2] = cols[2].trim();
                        cols[3] = cols[3].trim();
                        cols[4] = cols[4].trim();
                        return cols;
                    })
                    .map(cols -> mapToRule(cols))
                    .collect(Collectors.toList());
            rowsStream.close();
        } catch (IOException e) {
            throw new BookingEngineRunTimeException(e);
        }

        return rules;
    }

    private static Rule mapToRule(String[] columnsObj) {
        Rule rule = null;
        int id = Integer.parseInt(columnsObj[0]);
        String name = columnsObj[1];
        String tourId = columnsObj[2];

        switch (id) {
            case 1:
                int totalTicketsGiven = Integer.parseInt(columnsObj[3]);
                int totalTicketsPurchased = Integer.parseInt(columnsObj[4]);
                rule = new Rule1(id, name, tourId, totalTicketsGiven, totalTicketsPurchased);
                break;
            case 2:
                String freeTourId = columnsObj[3];
                rule = new Rule2(id, name, tourId, freeTourId);
                break;
            case 3:
                double discount = Double.parseDouble(columnsObj[3]);
                int threshold = Integer.parseInt(columnsObj[4]);
                rule = new Rule3(id, name, tourId, discount, threshold);
                break;
        }
        return rule;
    }


}
