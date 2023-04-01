// Delta College - CST 283 - Gibbs
// This file define a class to manage data 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CallManager extends Call{

   // Declare variables necessary
   static String fileName = "/Users/megangibbs/Downloads/Exam2/calls.txt";
   
   static CallManager[] Call = parseCallFile(fileName);
   static int index = 0;
   static int top;
   static String type = "";
   
   //Main method
   public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Calls Loaded.");
      System.out.println("Voicemail: \n-----------------------");
      
      //Display call log
      for (CallManager data : Call){
         if (data != null){
            System.out.println(data.toString());
         }else;
      }

      //Ask what changes to be made
      System.out.println("Please Enter 'L' for LIFO \t or \t'F' for FIFO");
      String type = scanner.next();
      
      //if l is entered take last entry out if f take first
      if(type.equalsIgnoreCase("L")){
         for (CallManager data : Call){
            index++;
            if (data == null){
               Call[index-2]=null;
            }else;
         }
      }else if(type.equalsIgnoreCase("F")){
         for (CallManager data : Call){
            if (data == null){
               Call[index]=null;
            }else;
         }
      }else{
      //if none of options are seleceted prompt user
      System.out.println("Invalid Selection ");
      }
      
      //show updated call log
      System.out.println("Calls Updated.");
      System.out.println("Voicemail: \n-----------------------");
      
      for (CallManager data : Call){
         if (data != null){
            System.out.println(data.toString());
         }else;
      }
   }
   
   
   
   // Constructor:  Load data from file into list
   public static CallManager[] parseCallFile(String file){
   
      CallManager[] Call = new CallManager[100];
      int index = 0;
      top = 0;
      
      // Open file.
       try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null ) {
            
                String[] values = line.split(",");
                // Create a new Case object and set its properties
                CallManager data = new CallManager();
                data.number = values[0];

                // Add the object to the array
                Call[index] = data;
                index++;
            }
        } catch (IOException e) {   // If file error, reset list status flag
            e.printStackTrace();
        }
        return Call;
   }
   
   // Get/Set Methods
   public String getNumber(){
      return number;
   }
   
   public void setNumber(String n){
      this.number = n;
   }
}