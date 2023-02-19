package CS216.Assignment05;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;





public class peopleList {

        static int numElems2 = 0;
    
        static Scanner scanner = new Scanner(System.in);
            
        // Create an array to store the objects
        People[] data = new People[700000];
        int index = 0;
        String filename = "2023/CS216/Assignment05/people.txt";


            
        // Try to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null && index <= 700000) {
                // Split the line by commas
                String[] values = line.split(",");

                // Create a new People object and set its properties
                People tempdata = new People();
                tempdata.setSocial(values[0]);
                tempdata.setLastName(values[1]);
                tempdata.setFirstName(values[2]);

                // Add the object to the array
                data[index] = tempdata;
                line = br.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        numElems2 = index;
                
}

public static People[] parseFile(String fileName) {
    People[] dataArray = new People[700000];
    int index = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null ) {
            String[] values = line.split(",");
            People data = new People();
            data.ssn = values[0];
            data.last = values[1];
            data.first = values[2];
            dataArray[index] = data;
            index++;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return dataArray;
}

class People {
    private String ssn;
    private String last;
    private String first;


    public String getSocial() {
        return ssn;
    }

    public void setSocial(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return last;
    }

    public void setLastName(String last) {
        this.last = last;
    }

    public String getFirstName() {
        return first;
    }

    public void setFirstName(String first) {
        this.first = first;
    }
    
}





