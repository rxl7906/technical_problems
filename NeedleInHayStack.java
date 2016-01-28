
public class NeedleInHayStack {
	public static int strStr(String haystack, String needle){
		
		for(int i = 0; i < haystack.length(); i++){
			if(i + needle.length() > haystack.length()){
				return -1;
			}
			int m = i;
			for(int j = 0; j < needle.length(); j++){
				if(needle.charAt(j) == haystack.charAt(m)){
					if(j == needle.length() - 1){
						return i;
					}
					m++;
				} else {
					break;
				}
			}
		}
		return -1;
	}
	public static void main(String args[]){
		System.out.println(strStr("Theskyisbluetoday","is"));
	}
}
