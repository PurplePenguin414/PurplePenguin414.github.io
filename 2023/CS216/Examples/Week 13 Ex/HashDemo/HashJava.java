// Delta College - CST 283 - Klingler                  
// This application demonstrates basic linked list operations
// Version 2

public class HashJava
{     
    public static void main(String [] args)
    {
        Integer anInteger = new Integer(283);
        System.out.println("Object: " + anInteger.toString() +
                         "| hashcode: " + anInteger.hashCode());     

        String aString = new String("CST 183");
        System.out.println("Object: " + aString.toString() +
                         "| hashcode: " + aString.hashCode());       
               
        Object anObject = new Object();
        System.out.println("Object: " + anObject.toString() +
                         "| hashcode: " + anObject.hashCode());

        Data data = new Data(666,777777);
        System.out.println("Object: " + data.toString() +
                         "| hashcode: " + data.hashCode());  
    }  
}
