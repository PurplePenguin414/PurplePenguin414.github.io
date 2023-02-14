// Delta College - CST 283 - Klingler                              
// This program demonstrates the various examples of output formatting using
//   1) DecimalFormat class
//   2) printf()
//   3) String.Format()

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class StringFormat 
{
    public static void main(String args[]) 
    {
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // DECIMALFORMAT CLASS

        DecimalFormat formatterA = new DecimalFormat("#0.00");
        DecimalFormat formatterB = new DecimalFormat("000.00");
        DecimalFormat formatterC = new DecimalFormat("#,##0.00");       
        DecimalFormat formatterD = new DecimalFormat("#0%");

        double number1 = 123456.899;
        double number2 = 2.49584;
        double number3 = 0.12;      
        
        System.out.println(formatterA.format(number1));
        System.out.println(formatterB.format(number1));
        System.out.println(formatterC.format(number1));
        System.out.println();


        System.out.println(formatterA.format(number2));
        System.out.println(formatterB.format(number2));
        System.out.println(formatterC.format(number2));
        System.out.println();
        
        System.out.println(formatterD.format(number3));
        System.out.println();

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // Using printf()

        // Various examples using the printf
        int kids = 2, pets = 5;
        System.out.printf("We have %d kids and %d pets.\n", kids, pets);

        double grossPay = 2874.12;
        System.out.printf("My paycheck this week is %f.\n", grossPay);
        System.out.printf("Really, I\'m being paid %6.2f\n", grossPay);


        String name = "Jane Doe";
        System.out.printf("Your name is %s.\n", name);

        int numDays = 31;
        System.out.printf("There are %2d days in this month\n", numDays);


        int month = 1;
        int day = 1;
        int year = 2016;

        System.out.printf("Today is: %02d/%02d/%02d\n\n", month, day, year%2000);

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // Using String.format

        String outputMsg = String.format("Seriously, we have %d kids and %d pets.\n", kids, pets);
        System.out.println(outputMsg);

        double salary = 12387456.7899;
        System.out.println(String.format("My annual salary is $%,.2f\n", salary));

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        
        System.exit(0);
    }
}