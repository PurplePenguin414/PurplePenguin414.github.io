// Delta College - CST 283 - Gibbs 
// This class manages the basic info for one athlete

public class Player
{   
         
   private String name;   
   private double reb;       
   private double ppg;
   private double ast;
   
   // Constructor
   public Player(String n, double r, double pt, double a)
   {
      name  = n;
      reb    = r;
      ppg   = pt;
      ast = a;
   }
   
   // Set Methods
   public void setName(String n)
   { name  = n; }
   public void setReb(double r)
   { reb = r; }
   public void setPpg(double pt)
   { ppg   = pt; }
   public void setAst(double a)
   { ast = a; }
   
   // Get Methods
   public String setName()
   { return name; }
   public double getReb()
   { return reb; }
   public double getPpg()
   { return ppg; }
   public double getAst()
   { return ast; }

   // Return object contents to string object
    public String toString()
   {
      String outString  = "Name:    "  + name    + "\n" +
                          "Points per game:  "  + reb  + "\n" +
                          "Rebounds per game: "  + ppg + "\n" + 
                          "Assist per game:   "  + ast   + "\n";
      return outString;
   }

   
}
