import java.util.Scanner;

public class triarea {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double b = 0,h = 0;
        int[] array = new int[2];
        
        for(int i=0; i<2; i++){ 
        //reading array elements from the user   
            array[i]=input.nextInt();  
        }  
        h = array[0];
        b = array[1];
        double area = ((b * h) / 2); // calculating the area using the formula
        System.out.println(area);
    }
}
