import java.util.Scanner;


public class Palindrome {

	// tripadvisor interview question
	public static boolean isPalin(String s){
		int a = 0;
		int b = s.length() - 1;
		while(a < b){
			if(s.charAt(a) == ' '){
				a++;
			} 
			if(s.charAt(b) == ' '){
				b--;
			}
			
		}
		return true;
	}
	public static boolean isPalindrome(String str) {
		int size = str.length();
		for (int i = 0; i < (size/2)+1 ; i++) { // go up to the median
			if (str.charAt(i) != str.charAt(size - i - 1)) {
				return false;
			}
		}
		return true;
	}
	// 1) null
	// 2) empty string
	// 3) even # chars
	// 4) odd # chars
	// 5) upper case/lower case
	// 6) spaces
	// 7) palindrome
	// 8) not a palindrome
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String string = input.next();
		System.out.println(isPalin(string));
		//System.out.println(isPalindrome(string));
	}
}
