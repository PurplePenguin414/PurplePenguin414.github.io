import java.util.Scanner;

public class grading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int aLimit = scanner.nextInt();
        int bLimit = scanner.nextInt();
        int cLimit = scanner.nextInt();
        int dLimit = scanner.nextInt();
        int eLimit = scanner.nextInt();

        int score = scanner.nextInt();

        if (score >= aLimit) {
            System.out.println("A");
        } else if (score >= bLimit) {
            System.out.println("B");
        } else if (score >= cLimit) {
            System.out.println("C");
        } else if (score >= dLimit) {
            System.out.println("D");
        } else if (score >= eLimit) {
            System.out.println("E");
        } else {
            System.out.println("F");
        }
    }
}

