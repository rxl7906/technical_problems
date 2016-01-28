import java.util.Vector;


public class StringProblems {
	// reverse string in place
	static String reverseString(String s){
		char[] str = s.toCharArray();
		for(int i = 0; i < str.length/2; i++){
			swap(str, i, str.length-i-1);
		}
		return new String(str);
	}
	static void swap(char[] c, int i, int j){
		char tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
	}
	
	// reverse string not in place
	/*static String reverseString(String s){
		int c = 0;
		char[] a = new char[s.length()];
		for (int i = s.length(); i > 0; i--) {
			a[c] = s.charAt(i-1);
			c+=1;
		}
		return new String(a);
	}*/
	
	// given a string, remove multiple occurrences of 
	// blank spaces by a single space in a single
	// pass of arrays
	static String compactSpaces(String s){
		StringBuilder sb = new StringBuilder();
		char[] ar = s.toCharArray();
		boolean flag = false;
		for(char c : ar){
			if(c != ' '){
				flag = false;
				sb.append(c);
			} else {
				if(!flag){
					sb.append(c);
					flag = true;
				} else {
					continue;
				}
			}
		}
		String str = sb.toString();
		return str;
	}
	/*static String compactSpaces(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
            }
            sb.append(c);
        }
        return sb.toString();
	}*/
	
	/*static String compressString(String str){
		String s = "";
		int c = 1;
		for(int i = 1; i < str.length()-1; i++){
			System.out.println(str.charAt(i));
			if(str.charAt(i) == str.charAt(i-1)){
				c++;
			} else {
				s = s + Integer.toString(c) + str.charAt(i-1);
				c = 1;
				System.out.println(s);
			}
		}
		System.out.println("-----");
		return s;
	}*/
	
	// answer
	public static String stringComp(String s) {
		String str = "";
		char letter = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == letter) {
				count++;
			} else {
				str = str + letter + count;
				letter = s.charAt(i);
				count = 1;
			}
		}
		return str;
	}
	
	// given input {}{} make sure brackets match up
	//static boolean checkValid(String s){
		
	//}
	
	/*static void test(){
		Vector v = new Vector();
		v.add(4);
		v.add("asdf");
		
		for(int i = 0; i < v.size(); i++){
			System.out.println(v.get(i));
		}
	}*/

	public static void main(String args[]){
		//System.out.println(reverseString("Animals"));
		
		//System.out.println(compactSpaces("I  am    here     buddy."));
		
		//System.out.println(compressString("WWBWWW"));
		System.out.println(stringComp("WWBWWW"));
	}
}
