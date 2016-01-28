import java.util.HashMap;
import java.util.Map;


public class CheckAnagram {
	static boolean isAnagram(String str1, String str2){
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 != len2){
			return false;
		}
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		for(int i = 0; i < len1; i++){
			if(hm1.containsKey(str1.charAt(i))){
				hm1.put(str1.charAt(i), hm1.get(str1.charAt(i)+1));
			} 
			if(hm2.containsKey(str2.charAt(i))){
				hm2.put(str2.charAt(i), hm2.get(str1.charAt(i))+1);
			}
			hm1.put(str1.charAt(i), 1);
			hm2.put(str2.charAt(i), 1);
		}
		
		// loop thru hm1, take the entry's key, use it to look up in hm2 compare entry's value against hm2's value
		for(Map.Entry<Character,Integer> entry : hm1.entrySet()){
			if(hm2.containsKey(entry.getKey())){ // if hm2 has the entry's key
				// compare values
				if(hm2.get(entry.getKey()) == entry.getValue() ){ // if equal values
					continue; // continue proving anagram
				} else{
					return false;
				}
			} else{
				return false;
			}
		}
		
		return true;
	}
	public static void main(String args[]){
		System.out.println(isAnagram("asdf","fdsaf"));
	}
}
