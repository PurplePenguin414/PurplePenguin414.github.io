import java.util.Scanner;

public class twosum {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int temp0 = 0, sum = 0;
        int[] array = new int[2];
        
        for(int i=0; i<2; i++){ 
        //reading array elements from the user   
            array[i]=input.nextInt();  
            if (array[i] > 0){
                sum += array[i];
            }else;
        }  
        System.out.println(sum);
    }
}