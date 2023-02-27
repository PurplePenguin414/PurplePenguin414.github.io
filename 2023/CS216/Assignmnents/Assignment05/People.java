package CS216.Assignment05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class People {
    String ssn;
    String last;
    String first;

    public People()
    {
        ssn = " ";
        last = " ";
        first = " ";
    }

    public People(String s, String l, String f)
    {
        ssn = s;
        last = l;
        first = f;
    }

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

    public static String snnSearch(String ssn, People[] peopleArray) {
        for (People person : peopleArray) {  
            if (ssn.equals(person.ssn))
                ssn = person.first + " " + person.last + " (" + person.ssn + ") ";
            else ssn = null;
        }
        return ssn;
    }

    public static People[] parsePeopleFile(String peopleFile) {
        // Create an array to store the objects
        People[] peopleArray = new People[700000];
        int numElems2 = 0;

        int index2 = 0;
   
            // Try to read the file
            try (BufferedReader br = new BufferedReader(new FileReader(peopleFile))) {
                String line = br.readLine();
                while (line != null && index2 <= 700000) {
                    // Split the line by commas
                    String[] values = line.split(",");
        
                    // Create a new People object and set its properties
                    People tempdata = new People();
                    tempdata.setSocial(values[0]);
                    tempdata.setLastName(values[1]);
                    tempdata.setFirstName(values[2]);
        
                    // Add the object to the array
                    peopleArray[index2] = tempdata;
                    line = br.readLine();
                    index2++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            numElems2 = index2;
        return peopleArray;
    }
}



