package assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class Assignment1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String fileName = "assignment1/stormdata.txt";
        Data[] dataArray = parseFile(fileName);
        System.out.println("Data Loaded");

        System.out.print("Search Options: \n D \t List all From this Date \n S \t List all of this Type \n T \t List total occurrences of this storm type \n J \t List total of deaths or injuries for given state and year \n A \t List total number of storms that involved at least one death.");
        System.out.println("\n Select your Search:");
        String userInput = scanner.nextLine();
        if (Objects.equals(userInput, "D")){
            Dsearch(dataArray);
        }
        else if (Objects.equals(userInput, "S")) {
            Ssearch(dataArray);
        }
        else if (Objects.equals(userInput, "T")) {
            Tsearch(dataArray);
        }
        else if (Objects.equals(userInput, "J")) {
            Jsearch(dataArray);
        }
        else if (Objects.equals(userInput, "A")) {
            Asearch(dataArray);
        }else {
            System.out.println("Please select an option from above.");
        }

    }

    public static Data[] parseFile(String fileName) {
        Data[] dataArray = new Data[688049];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null && dataArray.length <= 688048 && (line = br.readLine()) != " D") {
                String[] values = line.split(",");
                Data data = new Data();
                data.field1 = Integer.parseInt(values[0]);
                data.field2 = values[1];
                data.field3 = values[2];
                data.field4 = Integer.parseInt(values[3]);
                data.field5 = Integer.parseInt(values[4]);
                data.field6 = Integer.parseInt(values[5]);
                dataArray[index] = data;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }


    public static void Dsearch(Data[] dataArray) {
        System.out.print("You Selected to search by county. This will list all store events from the first date given to the second date given \n");

        System.out.println("Enter Max Date in format 'yearMonthDay':");
        String maxDate = scanner.nextLine();
        System.out.println("Enter Min Date in format 'yearMonthDay':");
        String minDate = scanner.nextLine();
        System.out.println("Enter county code:");
        String cCode = scanner.nextLine();

        for (Data data : dataArray) {
            if (data.field1 <= Integer.parseInt(maxDate) && data.field1 >= Integer.parseInt(minDate) && data.field4 == Integer.parseInt(cCode)) {
                System.out.println("Data found: " + data.toString());
            }else{
                System.out.println("No data found");
            }
        }
    }
    public static void Ssearch(Data[] dataArray) {
        System.out.print("You Selected to search by Storm Type and State. This will list all Storm events from the state given that match the type given.");
        System.out.print("\n Valid Storm Types are: \n RF \t Heavy Rain or Flooding \n HA \t Hail \n WI \t Strong Winds \n CO \t Frozen Precipitation or Extreme Cold \n TO \t Tornado \n LI \t Lightning \n WS \t Winter Storm or Significant Snow ");

        System.out.println("Enter Storm Type:");
        String type = scanner.nextLine();
        System.out.println("Enter State using Postal Abbreviations:");
        String state = scanner.nextLine();

        for (Data data : dataArray) {
            if (Objects.equals(data.field2, type) && Objects.equals(data.field3, state)) {
                System.out.println("Data found: " + data.toString());
            }else{
                System.out.println("No data found");
            }
        }
    }
    public static void Tsearch(Data[] dataArray) {
        System.out.print("You Selected to search by Storm Type. This will list the number of Storm events that match the type given.");
        System.out.print("\n Valid Storm Types are: \n RF \t Heavy Rain or Flooding \n HA \t Hail \n WI \t Strong Winds \n CO \t Frozen Precipitation or Extreme Cold \n TO \t Tornado \n LI \t Lightning \n WS \t Winter Storm or Significant Snow ");

        System.out.println("Enter Storm Type:");
        String type = scanner.nextLine();
        int total = 0;
        for (Data data : dataArray) {
            if (Objects.equals(data.field2, type)) {
                 total++;
            }else{
                System.out.println("No data found");
            }
        }
        System.out.print(total);
    }
    public static void Jsearch(Data[] dataArray) {
        System.out.print("You Selected to search by State and Year. This will list the number of Deaths and Injuries from the year and state given.");

        System.out.println("Enter State using Postal Abbreviations:");
        String state = scanner.nextLine();
        System.out.println("Enter Year:");
        String year = scanner.nextLine();

        int totalD = 0;
        int totalI = 0;
        for (Data data : dataArray) {
            if (data.field1 == Integer.parseInt(year) && Objects.equals(data.field3, state)) {
                totalD += data.field5;
                totalI += data.field6;
            }else{
                System.out.println("No data found");
            }
        }
        System.out.print(totalD + " " + totalI);
    }
    public static void Asearch(Data[] dataArray) {
        System.out.print("You Selected to search by State Death toll. This will list the number of Storms recorded for the given state that involved at least one Death.");

        System.out.println("Enter State using Postal Abbreviations:");
        String state = scanner.nextLine();

        int totalD = 0;
        for (Data data : dataArray) {
            if (Objects.equals(data.field3, state) && data.field5 >= 1) {
                totalD ++;
            }else{
                System.out.println("No data found");
            }
    }
    System.out.print(" The number of storms that involved at least one death for the state given is: " + totalD);
    }
}
class Data {
    int field1;
    String field2;
    String field3;
    int field4;
    int field5;
    int field6;

    @Override
    public String toString() {
        return "Data{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                ", field3=" + field3 +
                ", field4=" + field4 +
                ", field5='" + field5 + '\'' +
                ", field6='" + field6 + '\'' +
                '}';
    }
}
