
import java.util.Scanner;

public class whichisgreater {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt();

        if (num1 > num2){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}