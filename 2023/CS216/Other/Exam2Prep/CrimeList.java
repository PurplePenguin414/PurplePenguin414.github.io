package CS216.Other.Exam2Prep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CrimeList extends Crime{

    static String crimefile = "2023/CS216/Other/Exam2Prep/crimeCodeListMI.txt";
    static String peoplefile = "2023/CS216/Other/Exam2Prep/people.txt";

    static CrimeList[] Crime= parseCrimeFile(crimefile);
    static PeopleList[] People= PeopleList.parsePeopleFile(peoplefile);

    public static CrimeList[] parseCrimeFile(String crimefile) {
        CrimeList[] Crime= new CrimeList[700000];
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(crimefile))) {
            String line;
            while ((line = br.readLine()) != null ) {
                String[] values = line.split(",");
                CrimeList data = new CrimeList();
                data.code = values[0];
                data.description = values[1];
                data.level = values[2];
                Crime[index] = data;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Crime;
    }

    
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


    public static String codeSearch(String code2, CrimeList[] Crime) {
        for (CrimeList crime : Crime) {
            if (code2.equals(crime.code))
            code2 = crime.description;
            else code2 = null;
        }
        return code2;
    }
       
}
