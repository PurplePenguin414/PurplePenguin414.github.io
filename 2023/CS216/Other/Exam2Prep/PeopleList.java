package CS216.Other.Exam2Prep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PeopleList extends People {

    public static PeopleList[] People;
    String peoplefile = "2023/CS216/Other/Exam2Prep/people.txt";

    public static People[] parsePeopleFile(String peopleFile) {
        // Create an array to store the objects
        PeopleList[] People = new PeopleList[700000];
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
                ((PeopleList) tempdata).setSocial(values[0]);
                ((PeopleList) tempdata).setLastName(values[1]);
                ((PeopleList) tempdata).setFirstName(values[2]);

                // Add the object to the array
                People[index2] = (PeopleList) tempdata;
                line = br.readLine();
                index2++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        numElems2 = index2;
        return People;
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


    public static String snnSearch(String ssn, PeopleList[] People) {
        for (PeopleList Person : People) {
            if (Person != null){
                if (ssn.equals(Person.ssn))
                    ssn = Person.first + " " + Person.last + " (" + Person.ssn + ") ";
                else ssn = null;
            }else;
                
        }
        return ssn;
    }


    
}
