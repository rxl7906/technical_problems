
public class ReverseWordsInString {
	 public static String reverseWords(String s) {
        // write your code
        String[] parts = s.split(" ");
        
        StringBuilder builder = new StringBuilder();
        builder.append(parts[parts.length - 1]);
    
        for (int i = parts.length - 2; i >= 0; --i) {
            builder.append(" ").append(parts[i]);
        }
    
        return builder.toString();
	 }
	 public static void main(String args[]){
		 System.out.println(reverseWords("The sky is blue"));
	 }
}
