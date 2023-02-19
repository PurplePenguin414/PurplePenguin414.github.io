package CS216.Assignment05;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class countyList {

        static int numElems3 = 0;
    
        static Scanner scanner = new Scanner(System.in);
            
        // Create an array to store the objects
        County[] data = new County[700000];
        int index = 0;
        String filename = "2023/CS216/Assignment05/micounties.txt";


            
        // Try to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null && index <= 700000) {
                // Split the line by commas
                String[] values = line.split(",");

                // Create a new County object and set its properties
                County tempdata = new County();
                tempdata.setCode(Integer.parseInt(values[0]));
                tempdata.setName(values[1]);
                tempdata.setLatitude(values[2]);
                tempdata.setLongitude(values[3]);

                // Add the object to the array
                data[index] = tempdata;
                line = br.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        numElems3 = index;
                
}

public static County[] parseFile(String fileName) {
    County[] dataArray = new County[700000];
    int index = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null ) {
            String[] values = line.split(",");
            County data = new County();
            data.Ccode = Integer.parseInt(values[0]);
            data.name = values[1];
            data.latitude = values[2];
            data.longitude = values[3];
            dataArray[index] = data;
            index++;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return dataArray;
}

class County {
    private int Ccode;
    private String name;
    private String latitude;
    private String longitude;

    public int getCcode() {
        return Ccode;
    }

    public void setCode(int Ccode) {
        this.Ccode = Ccode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
}
