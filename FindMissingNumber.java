
public class FindMissingNumber {
	public static int fmn(int[] ar, int n){
		int total = (n+1)*(n+2)/2;
		for(int i = 0; i < n; i++){
			total = total - ar[i];
		}
		return total;
	}
	public static void main(String args[]){
		int a[] = {1,2,4,5,6};
		
		int miss =fmn(a, 5);
		System.out.println(miss);
	}
}
