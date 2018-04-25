import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static sun.misc.Version.print;

public class RuleParser {

    private static final String FILE_PATH = "resources/rules.csv";

    public static ArrayList<Rule> parseRulesCsv() throws BookingEngineRunTimeException {

        ArrayList<Rule> rules = new ArrayList<>();

        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            // Skip column headings.
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String csvLine = scanner.nextLine();
                String[] columns = csvLine.split(",");

                HashMap<String, String> columnsObj = new HashMap<>();
                columnsObj.put("id", columns[0]);
                columnsObj.put("name", columns[1]);
                columnsObj.put("tourId", columns[2]);
                columnsObj.put("param1", columns[3]);
                columnsObj.put("param2", columns[4]);

                Rule newRule = mapToRule(columnsObj);

                rules.add(newRule);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new BookingEngineRunTimeException(e);
        }

        return rules;
    }

    private static Rule mapToRule(HashMap<String, String> columnsObj) {

        Rule rule = null;

        int id = Integer.parseInt(columnsObj.get("id"));
        String name = columnsObj.get("name");
        String tourId = columnsObj.get("tourId");


        switch (id) {
            case 1:
                int totalTicketsGiven = Integer.parseInt(columnsObj.get("param1"));
                int totalTicketsPurchased = Integer.parseInt(columnsObj.get("param2"));
                rule = new Rule1(id, name, tourId, totalTicketsGiven, totalTicketsPurchased);
                break;
            case 2:
                String freeTourId = columnsObj.get("param1");
                rule = new Rule2(id, name, tourId, freeTourId);
                break;
            case 3:
                double newTicketPrice = Double.parseDouble(columnsObj.get("param1"));
                int greaterThanThreshold = Integer.parseInt(columnsObj.get("param2"));
                rule = new Rule3(id, name, tourId, newTicketPrice, greaterThanThreshold);
                break;
        }

        return rule;
    }


}
