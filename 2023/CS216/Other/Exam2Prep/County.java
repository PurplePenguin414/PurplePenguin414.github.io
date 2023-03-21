package CS216.Other.Exam2Prep;

public class County {
    String Ccode;
    String name;
    String latitude;
    String longitude;

    public County()
    {
        Ccode = " ";
        name = " ";
        latitude = " ";
        longitude = " ";
    }


    public County(String c, String n, String la, String lo)
    {
        Ccode = c;
        name = n;
        latitude = la;
        longitude = lo;
    }

}
