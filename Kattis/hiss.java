import java.util.Scanner;
public class hiss {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String str1 = input.nextLine();
		String str2 = str1.toLowerCase();
		if (str2.contains("ss")) 
			System.out.println("hiss");
		else
			System.out.println("no hiss");
			
	
	}
}