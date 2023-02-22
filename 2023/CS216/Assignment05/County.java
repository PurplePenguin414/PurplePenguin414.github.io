package CS216.Assignment05;
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

    public String getCcode() {
        return Ccode;
    }

    public void setCode(String Ccode) {
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

    public static String ccodeSearch(String ccode2, County[] MIArray) {
        for (County county : MIArray) {  
            if (ccode2.equals(county.Ccode))
                ccode2 = county.name;
            else ccode2 = null;
        }
        return ccode2;
    }
}
