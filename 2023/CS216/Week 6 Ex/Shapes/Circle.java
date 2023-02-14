// Delta College - CST 283 - Klingler
// This class manages attributes and functionality relavent
// to a simple circle.

public class Circle extends Shape
{
   private double radius;  

   // No-argument constructor
   public Circle()
   {
      super();
      radius = 0.0;
   } 
   
   // Parameterized constructor
   public Circle( double r, int x, int y, String c)
   {
      super(x, y, c);
      radius = r;
   } 

   // Mutator method
   public void setRadius( double r )
   {
      radius = r;
   } 

   // Accessor method
   public double getRadius()
   {
      return radius;
   } 

   // calculate and return diameter
   public double getDiameter()
   {
      return 2 * getRadius();
   } 

   // calculate and return circumference
   public double calcCircumference()
   {
      return Math.PI * getDiameter();
   } 

   // calculate and return area
   public double calcArea()
   {
      return Math.PI * getRadius() * getRadius();
   } 

   // Return String representation of Circle object
   public String toString()
   {
      return  "Circle" + "\n" +
              super.toString() +
              "Radius = " + this.getRadius();
   } 

} 

