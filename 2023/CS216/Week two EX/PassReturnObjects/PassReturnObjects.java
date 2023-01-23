/**
   Delta College - CST 283 - Klingler
   This program passing objects to methods and returning objects
   from methods.
*/

public class PassReturnObjects
{
   public static void main(String[] args)
   {
      // Create a Rectangle object.
      Circle aCircle = new Circle(12.0);

      // Display the object's contents
      System.out.println("My circle: " + aCircle.toString());

      // Pass a reference to the object to a method that changes the radius
      doubleCircle(aCircle);

      // Display the object's contents again
      System.out.println("My circle after doubling: " + aCircle.toString());

      // Reset the object reference to a unit circle (radius 1)
      aCircle = unitCircle();

      // Display the object's contents again
      System.out.println("My unit circle: " + aCircle.toString());
   }

   // This method doubles the radius of a Circle object passed in as
   // a parameter
   public static void doubleCircle(Circle c)
   {
      c.setRadius(2.0 * c.getRadius());
   }
   
   // This method instantiates a unit circle (radius 1) and returns it
   public static Circle unitCircle()
   {
      Circle unit = new Circle(1.0);
      return unit;
   }
}
