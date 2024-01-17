import java.util.Scanner;

public class cold {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int temp0 = 0, count = 0,numTemp = input.nextInt();
        int[] array = new int[numTemp];
        
        for(int i=0; i<numTemp; i++){ 
        //reading array elements from the user   
            array[i]=input.nextInt();  
            if (array[i] < 0){
                count++;
            }else;
        }  
        System.out.println(count);
    }
    
    
}