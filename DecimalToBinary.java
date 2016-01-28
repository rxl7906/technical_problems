import java.util.Scanner;

public class DecimalToBinary {
	public static String toBinary(int n){
		if(n == 0) return "0";
		String b = "";
		while(n > 0){
			int r = n%2;
			b = r+b;
			n = n/2;
		}
		return b;
	}
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(toBinary(n));
	}
}
