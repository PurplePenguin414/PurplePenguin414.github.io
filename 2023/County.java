public class County {

    private int Ccode;
    private String name;
    private String latitude;
    private String longitude;

    public County()
    {
        Ccode = 0;
        name = " ";
        latitude = " ";
        longitude = " ";
    }

    public County(int c, String n, String la, String lo)
    {
        Ccode = c;
        name = n;
        latitude = la;
        longitude = lo;
    }

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
