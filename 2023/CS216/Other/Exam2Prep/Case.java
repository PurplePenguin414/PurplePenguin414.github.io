package CS216.Other.Exam2Prep;

public class Case {

    int i = 0;
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

    @Override
    public String toString() {
        return(
            "\n-----------------------\n" + 
            ssn +
            "\nCharge: " + code +
            "\nLocation: " + Ccode +
            "\nDate of Arrest: " + date1 +
            "\nCourt Date: " + date2
        );
    }
}
