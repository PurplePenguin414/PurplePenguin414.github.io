import java.util.Scanner;
public class Halloween {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String str1 = input.nextLine();
		String str2 = str1.toUpperCase();

		if (str2.equals("OCT 31"))
			System.out.println("yup");
		else if (str2.equals("DEC 25"))
				System.out.println("yup");
		else
			System.out.println("nope");
		
	}
}