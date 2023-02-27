// Delta College - CST 283 - Klingler
// This file defines the specifications for a class to store
// a basic shape object for a hypothetical computer graphics application.
// This parent class contains the general atttributes of any 
// shape including color and pixel coordinates.

public class Shape
{
    protected int centerX;
    protected int centerY;
    protected String color;
    
    Shape()                  
    {
        color = "none";
        centerX = 0;
        centerY = 0;
    }

    // Parameterized constructor
    Shape(int x, int y, String s)             
    {
        color = s;
        centerX = x;
        centerY = y;
    }
        
    // SET/GET methods 
    public void setColor(String s)
    {    color = s;     }
    public void setX(int x)
    {    centerX = x;    }
    public void setY(int y)
    {    centerY = y;    }

    public String getColor()
    {   return color;   }
    public int getX()
    {   return centerX;  }
    public int getY()
    {   return centerY;  }

    // Return basic Shape info as string
    public String toString()
    { 
        return "Center: (" + centerX + ", " + centerY + ")" + "\n" +
               "Color: " + color + "\n";
    }
}

