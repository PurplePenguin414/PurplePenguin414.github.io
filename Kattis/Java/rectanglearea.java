import java.util.Scanner;

public class rectanglearea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] array = new double[4];
        
        for(int i=0; i<4; i++){ 
        //reading array elements from the user   
            array[i]=input.nextDouble();  
        }

        double x1, y1, x2, y2;
        x1 = array[0];
        y1 = array[1];
        x2 = array[2];
        y2 = array[3];

        double area = Math.abs((x2 - x1) * (y2 - y1));
        System.out.println(area);
    }
}
