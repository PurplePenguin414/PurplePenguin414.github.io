// Delta College - CST 283 - Klingler & Former Deitel text
// Cylinder class inherits from Circle.

public class Cylinder extends Circle
{
   private double height;  // Cylinder's height

   // no-argument constructor
   public Cylinder()
   {
      // implicit call to Circle constructor occurs here
   } 

   // constructor
   public Cylinder( int xValue, int yValue, double radiusValue,
      double heightValue )
   {
      super( xValue, yValue, radiusValue ); // call Circle constructor
      setHeight( heightValue );
   } 

   // set Cylinder's height
   public void setHeight( double heightValue )
   {
      height = ( heightValue < 0.0 ? 0.0 : heightValue );
   } 

   // get Cylinder's height
   public double getHeight()
   {
      return height;
   } 

   // override Circle4 method getArea to calculate Cylinder area
   public double getArea()
   {
      return 2 * super.getArea() + getCircumference() * getHeight();
   } 

   // calculate Cylinder volume
   public double getVolume()
   {
      return super.getArea() * getHeight();
   } 

   // return String representation of Cylinder object
   public String toString()
   {
      return super.toString() + "; Height = " + getHeight();
   } 
	
} 

