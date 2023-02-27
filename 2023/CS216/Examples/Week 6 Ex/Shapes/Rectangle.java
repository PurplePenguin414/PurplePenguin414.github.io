// Delta College - CST 283 - Klingler                 
// This class manages a simple rectangle.

public class Rectangle extends Shape
{
   private double length;
   private double width;

   // Constructors
   public Rectangle()
   {
      super();
      length = 0;
      width  = 0;
   }
   
   public Rectangle(double len, double wid, int x, int y, String c)
   {
      super(x, y, c);
      length = len;
      width = wid;
   }

   // Accessors and mutators
   public void setLength(double len)
   { length = len; }
   public void setWidth(double w)
   { width = w; }
   public double getLength()
   { return length; }
   public double getWidth()
   { return width; }

    // Returns a Rectangle object's area.
   public double getArea()
   {
      return length * width;
   }
   
   // Return String representation of Circle object
   public String toString()
   {
      return  "Rectangle" + "\n" +
              super.toString() +
              "Dimensions: " + this.getLength() +
              " X " + this.getWidth();
   } 

}
