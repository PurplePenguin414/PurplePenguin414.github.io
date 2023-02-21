public class Crime {
    private String code;
    private String description;
    private String level;

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

    
}
