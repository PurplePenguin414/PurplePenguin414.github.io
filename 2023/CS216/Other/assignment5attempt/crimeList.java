package CS216.Other.assignment5attempt;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;





public class crimeList {
    
        static int numElems = 0;
    
        static Scanner scanner = new Scanner(System.in);

        // Create an array to store the objects
        Crime[] data = new Crime[700000];
        int index = 0;
        String filename = "2023/CS216/Assignment05/crimeCodeListMI.txt";
            
        // Try to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null && index <= 700000) {
                // Split the line by commas
                String[] values = line.split(",");

                // Create a new Crime object and set its properties
                Crime tempdata = new Crime();
                tempdata.setCode(values[0]);
                tempdata.setDescription(values[1]);
                tempdata.setLevel(values[2]);

                // Add the object to the array
                data[index] = tempdata;
                line = br.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        numElems = index;
}


public static Crime[] parseFile(String fileName) {
    Crime[] dataArray = new Crime[700000];
    int index = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null ) {
            String[] values = line.split(",");
            Crime data = new Crime();
            data.code = values[0];
            data.description = values[1];
            data.level = values[2];
            dataArray[index] = data;
            index++;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return dataArray;
}


class Crime {
    private String code;
    private String description;
    private String level;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
}





