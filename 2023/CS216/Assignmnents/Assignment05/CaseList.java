package CS216.Assignment05;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class CaseList {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String fileName = "2023/CS216/Assignment05/accused.txt";
        String peoplefile = "2023/CS216/Assignment05/people.txt";
        String MIfile = "2023/CS216/Assignment05/micounties.txt";
        String crimefile = "2023/CS216/Assignment05/crimeCodeListMI.txt";

        Case[] dataArray = parseCaseFile(fileName);
        People[] peopleArray = People.parsePeopleFile(peoplefile);
        County[] MIArray = parseCountyFile(MIfile);
        Crime[] crimeArray = parseCrimeFile(crimefile);

        System.out.println("Cases Loaded");

        System.out.println("The Accused List is Provided Here: ");

        //cleanData(dataArray, peopleArray, MIArray, crimeArray);

        for (Case data : dataArray) {

            System.out.println("Data found: " + data.toString());
            
        }
    }



    private static void cleanData(Case[] dataArray, People[] peopleArray, County[] MIArray, Crime[] crimeArray) {
        for (Case data : dataArray) {
            if(data.ssn != null){
                data.ssn = (People.snnSearch(data.ssn, peopleArray));
            }else if (data.Ccode != null){
                data.Ccode = (County.ccodeSearch(data.Ccode, MIArray));
            }else if (data.code != null){
                data.code = (Crime.codeSearch(data.code, crimeArray));
            }else;
        }
    }



    public static Case[] parseCaseFile(String fileName) {
        Case[] dataArray = new Case[100];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null ) {
                String[] values = line.split(",");
                Case data = new Case();
                data.code = values[0];
                data.ssn = values[1];
                data.Ccode = values[2];
                data.date1 = values[3];
                data.date2 = values[4];
                dataArray[index] = data;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }

    

    public static Crime[] parseCrimeFile(String crimefile) {
        Crime[] crimeArray = new Crime[700000];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(crimefile))) {
            String line;
            while ((line = br.readLine()) != null ) {
                String[] values = line.split(",");
                Crime data = new Crime();
                data.code = values[0];
                data.description = values[1];
                data.level = values[2];
                crimeArray[index] = data;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crimeArray;
    }

    public static County[] parseCountyFile(String MIfile) {
        County[] MIArray = new County[700000];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(MIfile))) {
            String line;
            while ((line = br.readLine()) != null ) {
                String[] values = line.split(",");
                County data = new County();
                data.Ccode = values[0];
                data.name = values[1];
                data.latitude = values[2];
                data.longitude = values[3];
                MIArray[index] = data;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MIArray;
    }

}

class Case {
    String ssn;
    String code;
    String Ccode;
    String date1;
    String date2;

    public Case()
    {
        ssn = " ";
        code = " ";
        Ccode = " ";
        date1 = " ";
        date2 = " ";
    }

    public Case(String s, String c, String C, String d1, String d2)
    {
        ssn = s;
        code = c;
        Ccode = C;
        date1 = d1;
        date2 = d2;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCcode() {
        return Ccode;
    }

    public void setCcode(String Ccode) {
        this.Ccode = Ccode;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }
    
    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    @Override
    public String toString() {
        return "\n-----------------------\n" + "Case # \n" +
                ssn +
                "\nCharge: " + code +
                "\nLocation: " + Ccode +
                "\nDate of Arrest: " + date1 +
                "\nCourt Date: " + date2;
    }
}

