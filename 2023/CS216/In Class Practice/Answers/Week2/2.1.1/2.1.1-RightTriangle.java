// Delta College - CST 183 - Klingler                        
// This class manages a simple right triangle.

public class RightTriangle
{
   private double base;
   private double height;
   
   // Constructors
   public RightTriangle()
   {
      base   = 0;
      height = 0;
   }

   public RightTriangle(double b, double h)
   {
      base   = b;
      height = h;
   }

   // Accessors and mutators
   public void setBase(double b)
   {
      base = b;
   }

   public void setHeight(double h)
   {
      height = h;
   }

   public double getBase()
   {
      return base;
   }
   
   public double getHeight()
   {
      return height;
   }

   // Calculate the area of the right triangle
   public double getArea()
   {
      return 0.5 * base * height;
   }
   
   // Calculate and return perimeter of triangle
   public double calcPerimeter()
   {
      double side3 = Math.sqrt(base*base + height*height);
      return base + height + side3;
   }
   
      
   // Method toString for this class
   public String toString()
   {
      return "Right triangle with base " + base + 
             " and height "              + height;
   }
}
