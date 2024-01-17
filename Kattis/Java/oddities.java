import java.util.Scanner;

public class oddities {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int temp = 0, nums = input.nextInt();
        Boolean[] evenOrOdd = new Boolean[nums];
        int[] array = new int[nums];
        
        for(int i=0; i<nums; i++){ 
        //reading array elements from the user   
            array[i]=input.nextInt();  
            temp = array[i] % 2;
            if (temp != 0){
                evenOrOdd[i] = false;
            }else{
                evenOrOdd[i] = true;
            }
        }  

        for(int j=0; j<nums; j++){  
                if (evenOrOdd[j] != true){
                    System.out.println(array[j] + " is odd");
                }else
                    System.out.println(array[j] + " is even");
            } 
    }
}