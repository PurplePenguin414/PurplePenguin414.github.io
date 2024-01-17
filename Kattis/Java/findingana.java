
import java.util.Scanner;

public class findingana {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String s = input.nextLine(), temp = "";
        int index = s.indexOf( 'a' );
        temp = s.substring(index, s.length());
        System.out.println(temp);
    }
}