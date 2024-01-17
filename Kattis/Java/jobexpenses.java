
import java.util.Scanner;

public class jobexpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int totalExpense = 0;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num < 0) {
                totalExpense += num;
            }
        }

        System.out.println(Math.abs(totalExpense));
    }
}
