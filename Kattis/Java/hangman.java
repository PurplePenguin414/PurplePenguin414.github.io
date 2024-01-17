import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String permutation = scanner.nextLine();

        int hangmanComponents = 0;
        for (char letter : permutation.toCharArray()) {
            if (word.indexOf(letter) != -1) {
                word = word.replaceAll(String.valueOf(letter), "");
                if (word.isEmpty()) {
                    System.out.println("WIN");
                    return;
                }
            } else {
                hangmanComponents++;
                if (hangmanComponents == 10) {
                    System.out.println("LOSE");
                    return;
                }
            }
        }

        System.out.println("LOSE");
    }
}
