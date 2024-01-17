import java.util.Scanner;

public class batterup {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int walk = -1,atbattemp = 0,atbats = input.nextInt();
        int[] array = new int[atbats];
        double avg = 0.0000000000000, sum = 0.0;
        atbattemp = atbats;
        for(int i=0; i<atbats; i++){ 
        //reading array elements from the user   
            array[i]=input.nextInt();  
            if (array[i] == walk){
                atbattemp--;
                array[i] = 0;
            }else;
        }  
        
        for(int i=0; i<atbats; i++){  
            sum += array[i]; 
        }  
        avg = sum / atbattemp;
        System.out.println(String.format("%,.010f", avg));
    }
}
