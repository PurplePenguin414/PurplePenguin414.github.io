import java.util.Scanner;

public class encodedmessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        String[] msg = new String[testCases];

        scanner.nextLine(); // Consume the newline after the number of test cases

        for (int i = 0; i < testCases; i++) {
            String encodedMessage = scanner.nextLine();
            int length = encodedMessage.length();
            int sideLength = (int) Math.sqrt(length);

            // Create a 2D character array to represent the square shape
            char[][] square = new char[sideLength][sideLength];

            // Fill the square by rotating the characters
            int index = 0;
            for (int col = sideLength - 1; col >= 0; col--) {
                for (int row = 0; row < sideLength; row++) {
                    square[row][col] = encodedMessage.charAt(index);
                    index++;
                }
            }

            // Convert the square back to a single line
            StringBuilder originalMessage = new StringBuilder();
            for (int row = 0; row < sideLength; row++) {
                for (int col = 0; col < sideLength; col++) {
                    originalMessage.append(square[row][col]);
                }
            }
            String transformedString = reverseString(originalMessage);
            msg[i] = transformedString;
        }
        for(int i=0; i<testCases; i++){ 
            System.out.println(msg[i]);  
        }
    }

    private static String reverseString(StringBuilder originalMessage) {
        StringBuilder reversed = new StringBuilder(originalMessage);
        return reversed.reverse().toString();
    }
}