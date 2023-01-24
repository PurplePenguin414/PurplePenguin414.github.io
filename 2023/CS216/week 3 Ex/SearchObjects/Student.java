// Delta College - CST 283 - Klingler 
// This class manages the basic info for one student

public class Student
{   
   private int    id;      
   private String name;   
   private double gpa;       
   private char   grade;
   
   // Constructor
   public Student(int i, String n, double gp, char gr)
   {
      id    = i;
      name  = n;
      gpa   = gp;
      grade = gr;
   }
   
   // Set Methods
   public void setID(int i)
   { id = i; }
   public void setName(String n)
   { name  = n; }
   public void setGPA(double gp)
   { gpa   = gp; }
   public void setGrade(char gr)
   { grade = gr; }
   
   // Get Methods
   public int getID()
   { return id; }
   public String setName()
   { return name; }
   public double getGPA()
   { return gpa; }
   public char getGrade()
   { return grade; }

   // Return object contents to string object
    public String toString()
   {
      String outString  = "ID:    "  + id    + "\n" +
                          "Name:  "  + name  + "\n" +
                          "Grade: "  + grade + "\n" + 
                          "GPA:   "  + gpa   + "\n";
      return outString;
   }

   
}
