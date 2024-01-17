
import java.util.Scanner;

public class SortTwoNum {
    public static void main(String[] args) {
        int min = -1, max = 1000000;
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt();

        if (num1 > num2){
            System.out.println(num2 + " " + num1);
        }else{
            System.out.println(num1 + " " + num2);
        }
    }
}