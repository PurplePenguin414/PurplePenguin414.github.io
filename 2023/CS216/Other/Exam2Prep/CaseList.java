package CS216.Other.Exam2Prep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CaseList extends Case{

    static String fileAccused = "2023/CS216/Other/Exam2Prep/accused.txt";
    static Case[] CaseList = parseCaseFile(fileAccused);

    public static void main(String[] args)
    {
        cleanData(CaseList, PeopleList.People, CountyList.County, CrimeList.Crime);
        System.out.println("Cases Loaded");
        System.out.println("The Accused List is Provided Here: \nData found: ");
        for (Case data : CaseList) {
            if (data != null){
                System.out.println(data.toString());
            }else;
        }

    }


    public static Case[] parseCaseFile(String fileAccused) {
        // Create an array to store the objects
        Case[] CaseList = new Case[100];
        int index = 0;

        // Try to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileAccused))) {
            String line;
            while ((line = br.readLine()) != null ) {
                // Split the line by commas
                String[] values = line.split(",");

                // Create a new Case object and set its properties
                Case data = new Case();
                data.code = values[0];
                data.ssn = values[1];
                data.Ccode = values[2];
                data.date1 = values[3];
                data.date2 = values[4];

                // Add the object to the array
                CaseList[index] = data;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CaseList;
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

    private static void cleanData(Case[] caseList2, PeopleList[] People, CountyList[] County, CrimeList[] Crime) {
        for (Case data : CaseList) {
            if(data.ssn != null){
                data.ssn = (PeopleList.snnSearch(data.ssn, People));
            }else if (data.Ccode != null){
                data.Ccode = (CountyList.ccodeSearch(data.Ccode, County));
            }else if (data.code != null){
                data.code = (CrimeList.codeSearch(data.code, Crime));
            }else;
        }
    }

}
