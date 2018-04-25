import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class RuleParser {

    private static final String FILE_PATH = "resources/rules.csv";

    public static HashMap<String, Tour> parseToursCsv() throws BookingEngineRunTimeException {

        HashMap<String, Tour> rules = new HashMap<>();

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

                //rules.put(id, new Tour(id, name, price));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new BookingEngineRunTimeException(e);
        }

        return rules;
    }

    private Rule mapToRule(HashMap<String, String> columnsObj) {

//        switch () {
//            case:
//                ;
//                case:
//
//        }
        return null;
    }


}
