package CS216.Other.Exam2Prep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountyList extends County {

    static String MIfile = "2023/CS216/Other/Exam2Prep/miCounties.txt";
    static CountyList[] County = parseCountyFile(MIfile);

    public static CountyList[] parseCountyFile(String MIfile) {
        CountyList[] County = new CountyList[700000];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(MIfile))) {
            String line;
            while ((line = br.readLine()) != null ) {
                String[] values = line.split(",");
                CountyList data = new CountyList();
                data.Ccode = values[0];
                data.name = values[1];
                data.latitude = values[2];
                data.longitude = values[3];
                County[index] = data;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return County;
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


    public static String ccodeSearch(String ccode2, CountyList[] MIArray) {
        for (CountyList County : MIArray) {
            if (ccode2.equals(County.Ccode))
            ccode2 = County.name;
            else ccode2 = null;
        }
        return ccode2;
    }
}
