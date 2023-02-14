// Delta College - CST 283 - Klingler  
// This application drives a simple demonstrates of circle and rectangle
// objects inherited from the general Shape class.

public class DoShapes 
{
    public DoShapes() 
    { 
        // Create a rectangle object, assign attributes, and summarize
        Rectangle aRect = new Rectangle();

        aRect.setColor("red");
        aRect.setX(10);
        aRect.setY(20);
        aRect.setWidth(100);
        aRect.setLength(200);

        System.out.println(aRect.toString());
        System.out.println("\n");

        // - - - - - - - - - - - - - - - - 
        // Create a right triangle object, assign attributes, and summarize
        Circle aCircle = new Circle();

        aCircle.setColor("blue");
        aCircle.setX(250);
        aCircle.setY(350);
        aCircle.setRadius(30);

        System.out.println(aCircle.toString());
        System.out.println("\n");

        // - - - - - - - - - - - - - - - - 
        // Test behavior of default constructor
        Rectangle anotherRect = new Rectangle(50, 60, 40, 60, "green");

        System.out.println(anotherRect.toString());
        System.out.println("\n");

    }  // end main function

    public static void main(String args[]) 
    {
        DoShapes theApp = new DoShapes();
    }
}
