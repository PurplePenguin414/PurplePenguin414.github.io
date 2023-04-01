// Delta College - CST 283 - Klingler                  
// This application demonstrates addition of two long integer
// objects for very long numbers.

public class TestLongNumbers
{     
    public static void main(String [] args)
    {
        LongInteger number1 = new LongInteger("number1.txt");
        // LongInteger number1 = new LongInteger("bignumber1.txt");

        LongInteger number2 = new LongInteger("number2.txt");
        // LongInteger number2 = new LongInteger("bignumber2.txt");

        LongInteger sum = number1.addTo(number2);         // Add the numbers

        sum.writeToFile("result.txt");      // Write the sum
    }
}
