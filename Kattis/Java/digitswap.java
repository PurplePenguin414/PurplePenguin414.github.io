import java.util.Scanner;

public class digitswap {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int digit = input.nextInt(), temp = 0;

        while (digit > 0){
            temp = digit % 10;
            System.out.print(temp);
            digit = digit / 10;
        }
    }
}