
import java.util.Scanner;

public class fyi {
    public static void main(String[] args) {
        int min = 1000000, max = 9999999, maxnum = 5559999, minnum = 5550000;
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();

        if (num1 >= minnum && num1 <= maxnum){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}
