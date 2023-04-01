// Delta College - CST 283 - Gibbs
public class Call {

   // Declare variables necessary
   String number;
   
   // No-Arg constructor - initialize to "dummy" values
   public Call(){
   
      number = " ";
   }

    // Parameterized constructor - initialize to specific values
   public Call(String n){
   
      number = n;
   }
   
   // Method to write basic info to console output
   @Override
    public String toString() {
        return(
        " " + number + " \n"
        );
    }
}