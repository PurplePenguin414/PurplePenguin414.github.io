// Delta College - CST 283 - Klingler
// This class manages attributes and functionality relavent
// to a simple circle.

public class Circle
{
   private double radius;  // Circle's radius

   // No-argument constructor
   public Circle()
   {
      radius = 0.0;
   } 
   
   // Parameterized constructor
   public Circle( double r )
   {
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
      return  "Radius = " + getRadius();
   } 

} 

