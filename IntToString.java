
public class IntToString {
	
	public static String intToString(int n){
		if(n == 0) return "0";
		StringBuilder sb = new StringBuilder();
		while(n > 0){
			int cur = n % 10;
			sb.append(cur);
			n = n/10;
		}
		String s = sb.substring(0);
		sb = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--){
			sb.append(s.charAt(i));
		}
		return sb.substring(0);
	}
	
	public static void main(String args[]){
		String s = intToString(567);
		System.out.println(s);
	}
}
