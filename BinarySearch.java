// Binary Search Algorithm
// Input: Sorted integer array
// Output: Return position of target value; return 0 if not found
public class BinarySearch {
	public static int binarySearch(int[] a, int k){
		int low = 1, high = a.length-1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(a[mid] == k){
				return mid;
			} else if(a[mid] < k){
				low = mid + 1;
			} else{
				high = mid - 1;
			}
		}
		return 0;
	}
	public static void main(String args[]){
		int[] a = new int[6];
		a[0] = 4;
		a[1] = 6;
		a[2] = 9;
		a[3] = 23;
		a[4] = 64;
		a[5] = 98;
		System.out.println(binarySearch(a,98));
	}
}
