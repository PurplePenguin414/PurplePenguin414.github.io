/**
   Delta College - CST 283 - Klingler
   This program passing objects to methods and returning objects
   from methods.
*/

public class EqualsTest
{
   public static void main(String[] args)
   {
      // Create string objects
      String string1 = new String("Delta");
      String string2 = new String("Delta");

      System.out.println("string1: " + string1);
      System.out.println("string2: " + string2);
      if (string1 == string2)
          System.out.println("TRUE  <-- string1 == string2");
      else
          System.out.println("FALSE <-- string1 == string2");

      if (string1.equals(string2))
          System.out.println("TRUE  <-- string1.equals(string2)");
      else
          System.out.println("FALSE <-- string1.equals(string2)");
      System.out.println("\n");      

      //-----------------------------------------------------------

      // Create objects
      Circle circle1 = new Circle(12.0);
      Circle circle2 = new Circle(12.0);

      System.out.println("circle1: " + circle1.toString());
      System.out.println("circle2: " + circle2.toString());
      if (circle1 == circle2)
          System.out.println("TRUE  <-- circle1 == circle2");
      else
          System.out.println("FALSE <-- circle1 == circle2");

      if (circle1.equals(circle2))
          System.out.println("TRUE  <-- circle1.equals(circle2)");
      else
          System.out.println("FALSE <-- circle1.equals(circle2)");
      System.out.println("\n");      
        
   }

}
