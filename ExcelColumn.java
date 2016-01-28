import java.util.Scanner;


// find excel column name from given column number
// find column number given excel column name
public class ExcelColumn {
	
	// find excel column name from given column number
	static void findName(int n){
		String str = "";
		while(n > 0){
			int rem = n%26;
			if(rem == 0){
				str = str + 'Z';
				n = (n/26)-1;
			} else {
				//char ch = 'A';
				///ch = (char) ((rem-1) + ch);
				char ch = (char) ((rem-1) + 'A');
				str = ch + str;
				n = n/26;
			}
		}
		for(int i = 0; i < str.length(); i++){
			System.out.print(str.charAt(i));
		}
	}
	
	// find column number given excel column name
	static void findNumber(String s){
		int len = s.length();
		int i;
		if(len == 1){
			i = 0;
		} else {
			i = 1;
		}
		for(int j = 0; j < len; j++){
			char c = s.charAt(j);
			if(j != len-1){
				i *= ((c-'a' + 1)*26);
			} else {
				i += c-'a'+1;
			}
		}
		System.out.println(i-1);
		
	}
	
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		//int n = s.nextInt();
		//findName(n);
		String name = s.next();
		findNumber(name);
	}
}
