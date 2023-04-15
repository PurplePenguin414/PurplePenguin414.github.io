// This class provides a simple class for a student

public class Student
{   
   private int    id;      
   private String name;   
   private double gpa;       
  
   // Constructor
   public Student(int i, String n, double gp)
   {
      id       = i;
      name     = n;
      gpa      = gp;

   }
   
   // Set Methods
   public void setID(int i)
   { id = i; }
   public void setName(String n)
   { name  = n; }
   public void setGPA(double gp)
   { gpa   = gp; }

    
   // Get Methods
   public int getID()
   { return id; }
   public String setName()
   { return name; }
   public double getGPA()
   { return gpa; }

    // This method performas a basic numerical hash function.  It mods the
    // student ID value to produce a hash value of 0...99
    public int hashCode()
    {
         return id % 100;
    }
   
   // Return object contents to string object
    public String toString()
   {
      String outString  = "(" + id + "|" + name + "|" + gpa + ")";
      return outString;
   }
   
}