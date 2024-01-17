import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class pokerhand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input cards
        String[] cards = scanner.nextLine().split(" ");

        // Count the occurrences of each rank
        Map<Character, Integer> rankCount = new HashMap<>();
        for (String card : cards) {
            char rank = card.charAt(0);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        // Find the maximum count
        int maxCount = 0;
        for (int count : rankCount.values()) {
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
