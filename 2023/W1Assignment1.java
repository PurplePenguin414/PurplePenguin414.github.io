
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class W1Assignment1 {

    static int numElems = 0;

    static Scanner scanner = new Scanner(System.in);
	    public static void main(String[] args) {
	        // Create an array to store the objects
	        StormData[] data = new StormData[700000];
	        int index = 0;
            String filename = "data.txt";


                
	        // Try to read the file
	        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	            String line = br.readLine();
	            while (line != null && index <= 700000) {
	                // Split the line by commas
	                String[] values = line.split(",");

	                // Create a new StormData object and set its properties
	                StormData tempdata = new StormData();
	                tempdata.setDate(Integer.parseInt(values[0]));
	                tempdata.setType(values[1]);
	                tempdata.setValue3(values[2]);
	                tempdata.setCode(Integer.parseInt(values[3]));
	                tempdata.setDeaths(Integer.parseInt(values[4]));
	                tempdata.setInjuries(Integer.parseInt(values[5]));

	                // Add the object to the array
	                data[index] = tempdata;
                    line = br.readLine();
	                index++;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

            numElems = index;

            System.out.print("Search Options: \n D \t List all From this Date \t \t \t \t \t \t \t \t \t \t Format: D,20120301,20121031,26111 \n S \t List all of this Type \t \t \t \t \t \t \t \t \t \t \t Format: S,HA,MI \n T \t List total occurrences of this storm type \t \t \t \t \t \t \t \t Format: T,TO,2014 \n J \t List total of deaths or injuries for given state and year \t \t \t \t \t \t Format: J,OH,2015 \n A \t This will list the number of Storms recorded for the given state that involved at least one Death. \t Format: A,MI ");
            System.out.println("\n Submit Your Query: ");
            String userInput = scanner.nextLine();
            String[] inputs = userInput.split(",");
            
            if (inputs[0].equals("D") ){
                Dsearch(data, inputs);
            }
            else if (inputs[0].equals("S")) {
                Ssearch(data, inputs);
            }
            else if (inputs[0].equals("T")) {
                Tsearch(data, inputs);
            }
            else if (inputs[0].equals("J")) {
                Jsearch(data, inputs);
            }
            else if (inputs[0].equals("A")){
                Asearch(data, inputs);
            }else {
                System.out.println("Please input a valid selection.");
            }

	        /* Print out the contents of the array to check that it worked  */
	        for (int i = 0; i < inputs.length; i++) { 
	            System.out.println(inputs[i]);
	        }
            
	    }

        public static void Asearch(StormData[] data, String[] inputs) {
            int totalD = 0;
            StormData tempData;
            for( int i = 0; i < numElems; i++){
                tempData = data[i];
                if ( inputs[1].equalsIgnoreCase(tempData.getState()) && tempData.getDeaths() >= 1) {
                    totalD ++;
                }else;
        }
        System.out.println(" The number of storms that involved at least one death for the state given is: " + totalD);
        }

        public static void Jsearch(StormData[] data, String[] inputs) {
            int totalD = 0;
            int totalI = 0;
            StormData tempData;
            for (int i = 0; i < numElems; i++) {
                tempData = data[i];
                if (Integer.parseInt(inputs[2]) == tempData.getDate() && inputs[1].equalsIgnoreCase(tempData.getState())) {
                totalD += tempData.getDeaths();
                totalI += tempData.getInjuries();
                }else;
        }
        System.out.print(totalD + " " + totalI);
        }

        public static void Tsearch(StormData[] data, String[] inputs) {
            int total = 0;
            StormData tempData;
            for (int i = 0; i < numElems; i++) {
                tempData = data[i];
                if (tempData.getType().equalsIgnoreCase(inputs[1]) && Integer.parseInt(inputs[2]) == tempData.getDate()) {
                 total++;
                }else;
        }
        System.out.print(total);
        }

        public static void Ssearch(StormData[] data, String[] inputs) {
            StormData tempData;
            for (int i = 0; i < numElems; i++) {
                tempData = data[i];
                if (tempData.getType().equalsIgnoreCase(inputs[1]) && tempData.getState().equalsIgnoreCase(inputs[2])) {
                    convertData(data);
                }else;
            }
        }

        public static void Dsearch(StormData[] data, String[] inputs) {
            StormData tempData;
            for (int i = 0; i < numElems; i++) {
                tempData = data[i];
                if ((tempData.getDate() <= Integer.parseInt(inputs[2])) && (tempData.getDate() >= Integer.parseInt(inputs[1])) && (tempData.getCode() == Integer.parseInt(inputs[3]))) {
                    System.out.println("Data found: " + i);
                    convertData(data);
                }else;
            }
        }
        public static void convertData(StormData[] data) {
        Map<String, String> states = new HashMap<String, String>() {{
            put("AL", "Alabama");
            put("AK", "Alaska");
            put("AZ", "Arizona");
            put("AR", "Arkansas");
            put("CA", "California");
            put("CO", "Colorado");
            put("CT", "Connecticut");
            put("DE", "Delaware");
            put("DC", "District of Columbia");
            put("FL", "Florida");
            put("GA", "Georgia");
            put("HI", "Hawaii");
            put("ID", "Idaho");
            put("IL", "Illinois");
            put("IN", "Indiana");
            put("IA", "Iowa");
            put("KS", "Kansas");
            put("KY", "Kentucky");
            put("LA", "Louisiana");
            put("ME", "Maine");
            put("MD", "Maryland");
            put("MA", "Massachusetts");
            put("MI", "Michigan");
            put("MN", "Minnesota");
            put("MS", "Mississippi");
            put("MO", "Missouri");
            put("MT", "Montana");
            put("NE", "Nebraska");
            put("NV", "Nevada");
            put("NH", "New Hampshire");
            put("NJ", "New Jersey");
            put("NM", "New Mexico");
            put("NY", "New York");
            put("NC", "North Carolina");
            put("ND", "North Dakota");
            put("OH", "Ohio");
            put("OK", "Oklahoma");
            put("OR", "Oregon");
            put("PA", "Pennsylvania");
            put("PR", "Puerto Rico");
            put("RI", "Rhode Island");
            put("SC", "South Carolina");
            put("SD", "South Dakota");
            put("TN", "Tennessee");
            put("TX", "Texas");
            put("UT", "Utah");
            put("VT", "Vermont");
            put("VA", "Virginia");
            put("VI", "Virgin Islands");
            put("WA", "Washington");
            put("WV", "West Virginia");
            put("WI", "Wisconsin");
            put("WY", "Wyoming");
        }};
        Map<String, String> stormTypes = new HashMap<String, String>() {{
            put("RF","Heavy Rain/Flooding");
            put("HA","Hail");
            put("WI","Strong Winds");
            put("CO","Freeze/Extreme Cold");
            put("TO","Tornado");
            put("LI", "Lightning");
            put("WS","Winter Storm");
        }};
        for (StormData tempdata : data) {
            int date = tempdata.getDate();
            String stormType = tempdata.getType();
            String state = tempdata.getState();
            int countyCode = tempdata.getCode();
            int deaths = tempdata.getDeaths();
            int injuries = tempdata.getInjuries();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateString = String.valueOf(date);
            Date dateObject = null;
            try {
                dateObject = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
            String formattedDate = outputFormat.format(dateObject);
            String stateFullName = states.get(state);
            String stormTypeFullName = stormTypes.get(stormType);
            String output = formattedDate + " - " + stormTypeFullName + " - " + stateFullName + " - County " + countyCode + " - Deaths: " + deaths + " - Injuries: " + injuries;
            System.out.println(output);
        }
    }

}
class StormData {
    private int date;
    private String type;
    private String state;
    private int code;
    private int deaths;
    private int injuries;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setValue3(String state) {
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getInjuries() {
        return injuries;
    }

    public void setInjuries(int injuries) {
        this.injuries = injuries;
    }
    
}




