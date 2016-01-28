
public class FindDuplicate {
	
	static int findDuplicate(int[] ar){
		boolean[] arr = new boolean[ar.length];
		int ans = 0;
		for(int i = 0; i < ar.length; i++){
			if(arr[i] == false){
				arr[ar[i]] = true;
			} else{
				ans = ar[i];
			}
		}
		return ans;
	}
	public static void main(String args[]){
		int[] ar = new int[5];
		ar[0] = 2;
		ar[1] = 3;
		ar[2] = 3;
		ar[3] = 4;
		ar[4] = 5;
		System.out.println(findDuplicate(ar));
	}
}
