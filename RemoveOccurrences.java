
public class RemoveOccurrences {

	public static String removeOccurrences(String s, char b){
		String str = "";
	    for (int i = 0; i < s.length(); i++){
	        if (s.charAt(i) != b){
	            str += s.charAt(i);
	        }
	    }

	    return str;
	}
	public static void main(String args[]){
		String s = "this,is,some,text";
		System.out.println(removeOccurrences(s, ','));
	}
}
