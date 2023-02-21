public class People {
    private String ssn;
    private String last;
    private String first;

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
}
