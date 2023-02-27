// Delta College - CST 283 - Klingler & Former Deitel text
// Circle class inherits from Point and accesses Point's
// private x and y via Point's public methods.

public class Circle extends Point 
{
   private double radius;  // Circle's radius

   // no-argument constructor
   public Circle()
   {
      // implicit call to Point constructor occurs here
   } 
   
   // constructor
   public Circle( int xValue, int yValue, double radiusValue )
   {
      super( xValue, yValue );  // call Point constructor explicitly
      setRadius( radiusValue );
   } 

   // set radius
   public void setRadius( double radiusValue )
   {
      radius = radiusValue;
   } 

   // return radius
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
   public double getCircumference()
   {
      return Math.PI * getDiameter();
   } 

   // calculate and return area
   public double getArea()
   {
      return Math.PI * getRadius() * getRadius();
   } 

   // return String representation of Circle4 object
   public String toString()
   {
      return "Center = " + super.toString() + "; Radius = " + getRadius();
   } 

} 

