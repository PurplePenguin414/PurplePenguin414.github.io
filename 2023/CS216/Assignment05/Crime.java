package CS216.Assignment05;
public class Crime {
    String code;
    String description;
    String level;

    public Crime()
    {
        code = " ";
        description = " ";
        level = " ";
    }

    public Crime(String c, String d, String l)
    {
        code = c;
        description = d;
        level = l;
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

    public static String codeSearch(String code2, Crime[] crimeArray) {
        for (Crime crime : crimeArray) {  
            if (code2.equals(crime.code))
                code2 = crime.description;
            else code2 = null;
        }
        return code2;
    }


}
