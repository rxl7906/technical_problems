import java.util.Scanner;


public class CheckPalindrome {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		String string = input.next();
		System.out.println(isPalindrome(string));
	}
	
	public static boolean isPalindrome(String str) {
		int size = str.length();
		for (int i = 0; i < (size/2)+1 ; i++) { // go up to the median
			//System.out.println("how many");
			if (str.charAt(i) != str.charAt(size - i - 1)) {
				return false;
			}	
		}
		return true;
	}
}
