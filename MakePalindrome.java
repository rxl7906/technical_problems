import java.util.HashMap;
import java.util.Map;


public class MakePalindrome {
	static String generatePalindrome(String s){
		// hashmap count number of occurrences of each char
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i=0; i<s.length();i++){
			if(hm.containsKey(s.charAt(i))){
				hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
			} else{
				hm.put(s.charAt(i), 1);
			}
		}

		// check if string has odd or even length
		boolean evenLength;
		if(s.length() % 2 == 0){
			evenLength = true;
		} else{
			evenLength = false;
		}
		// check if string is able to form palindrome
		// if evenLength=true; every char must be even
		// if evenLength=false; every char must be even except for one char
		// that char can have an odd amount of numbers
		for(Map.Entry<Character, Integer> entry : hm.entrySet()){
			int oddChar = 0;
			if(evenLength == true){
				if(entry.getValue() % 2 == 0){
					continue;
				} else{
					return "-1";
				}
			} else if(evenLength == false){
				if(oddChar > 1){
					return "-1";
				} else if(entry.getValue() % 2 == 0){
					continue;
				} else if(entry.getValue() % 2 == 1){
					oddChar++;
				} else{
					return "-1";
				}
			}
		}
		// figure out how to assemble the palindrome
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character, Integer> e: hm.entrySet()){
			sb.append
		}
		return "";
	}
	public static void main(String args[]){
		System.out.println(generatePalindrome("luala"));
	}
}
