package CS216.Assignment05;
public class People {
    static String ssn;
    static String last;
    static String first;

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
        People.ssn = ssn;
    }

    public String getLastName() {
        return last;
    }

    public void setLastName(String last) {
        People.last = last;
    }

    public String getFirstName() {
        return first;
    }

    public void setFirstName(String first) {
        People.first = first;
    }
}
