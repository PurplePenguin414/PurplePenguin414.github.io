import java.util.Scanner;
public class TwoStone {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		if ((1 <= num) && (num <= 10000000)) {
		
			if ((num % 2) == 0) {
				System.out.println("Bob");
			}
			else 
				System.out.println("Alice");
			
		}
	}
}
