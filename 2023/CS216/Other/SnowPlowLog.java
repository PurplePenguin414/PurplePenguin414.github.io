// Delta College - CST 283 - Gibbs 
// This class manages the basic info for one log

public class SnowPlowLog
{   
   private double    miles;      
   private String    name;
   private double    tMiles;
   public static int numElements = 0;
   
   // Constructor
   public SnowPlowLog(double m, String n)
   {
      name  = n;
      miles = m;
   }
   
   // Set Methods
   public void setName(String n)
   { name  = n; }
   public void setMiles(double m)
   { miles   = m; }
   
   // Get Methods
   public String getName()
   { return name; }
   public double getMiles()
   { return miles; }
   
   //
   public static void update() {
      numElements++;
   }

   //
   public static void show() {
      for (int i = 0; i < numElements; i++){
      }
   }

   //
   public static void clear() {
   }
   // Return object contents to string object
    public String toString()
   {
      String outString  = name  + ", " + miles + " miles";
      return outString;
   }

}
