package CS216.Other.Exam2Prep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CaseDriver {

    public static void main(String[] args)
    {
    
    final String fileAccused = "2023/CS216/Other/Exam2Prep/accused.txt";
    final Case[] CaseList = CaseList.parseCaseFile(fileAccused);
    
        //cleanData(CaseList, PeopleList.People, CountyList.County, CrimeList.Crime);
        System.out.println("Cases Loaded");
        System.out.println("The Accused List is Provided Here: \nData found: ");
        for (Case data : CaseList) {
            if (data != null){
                System.out.println(data.toString());
            }else;
        }

    }
}