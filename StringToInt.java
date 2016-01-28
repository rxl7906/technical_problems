import java.util.Scanner;

public class StringToInt {
	/*public static int stringToInt(String s){
		// if negative; set bool flag to true and move i pointer
		// if negativeFlag = true; take answer and multiply by -1
		int i = 0, answer = 0;
		boolean isNegative = false;
		if(s.charAt(i) == '-'){
			isNegative = true;
			i++;
		}

		// multiply by 10 to add a 0 digit
		// add the characters from the string one by one
		// char - '0' converts into an integer answer
		// i++ move pointer in string
		while(i < s.length()){
			answer *= 10;
			answer += (s.charAt(i) - '0');
			i++;
		}
		// if negative; multiply answer by -1
		if(isNegative) answer *= -1;
		return answer;
	}*/
	
	public static int stringToInt(String s){
		int answer = 0;
		int i = 0;
		boolean isNegative = false;
		if(s.charAt(i) == '-'){
			isNegative = true;
			i++;
		}
		
		while(i < s.length()){
			answer = answer * 10;
			answer = answer + (s.charAt(i) - '0');
			i++;
		}
		
		if(isNegative) answer *= -1;
		
		return answer;
	}
	
	public static long stringToLong(String s){
		long n = 0;
		int i = 0;
		boolean isNegative = false;
		if(s.charAt(i) == '-'){
			isNegative = true;
			i++;
		}
		while(i < s.length()){
			n *= 10;
			n += (s.charAt(i) - '0');
			i++;
		}
		if(isNegative) n *= -1;
		return n;
	}
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		//System.out.println(stringToInt(s.next()));
		System.out.println(stringToLong(s.next()));
	}
}



// other solution
/*for(int i = s.length()-1; i > 0; i--){
c = s.charAt(i);
System.out.println("c: "+c);
// 0 -> 48; 9 -> 57
if(c < 48 || c > 57){
	System.out.println(s+" is not a valid number");
	//throw new NumberFormatException(s+" is not a valid number");
}
n += (c - 48) * factor;
factor *= 10;
}
c = s.charAt(0);
if(c == '-'){
return -n;
} else {
n += (c-48) * factor;
}*/
