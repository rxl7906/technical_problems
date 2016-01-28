
public class MergeSort {
	/*public static int[] subArray(int[] ar, int lb, int ub){
		int[] arr = new int[ub];
		for(int i = 0; i < ub; i++){
			arr[i] = ar[i]; 
		}
		return arr;
	}
	public static int[] mergeSort(int[] ar){
		if(ar.length == 1) return ar; // if array has 1 element, return array
		int mid = ar.length / 2;
		int[] left = mergeSort(subArray(ar, 0, mid ));
		int[] right = mergeSort(subArray(ar, mid, ar.length - 1));
		int[] res = new int[ar.length];
		int aPtr = 0, lPtr = 0, rPtr = 0;
		while(aPtr < ar.length){
			if(lPtr == left.length){
				res[aPtr] = right[rPtr];
				rPtr++;
			} else if (rPtr == right.length){
				res[aPtr] = left[lPtr];
				lPtr++;
			} else if (left[lPtr] < right[rPtr]){
				res[aPtr] = left[lPtr];
				lPtr++;
			} else {
				res[aPtr] = right[rPtr];
				rPtr++;
			}
			aPtr++;
		}
		return res;
	}*/
	
	public static int[] mergeSort(int[] ar){
		if(ar.length <= 1){
			return ar;
		}
		// split array in half
		int[] a = new int[ar.length/2];
		int[] b = new int[ar.length - a.length];
		System.arraycopy(ar, 0, a, 0, a.length);
		System.arraycopy(ar, a.length, b, 0, b.length);
		
		// sort each half
		mergeSort(a);
		mergeSort(b);
		
		// merge halves together, overwriting original array
		merge(a,b,ar);
		return ar;
	}
	
	public static void merge(int[] a, int[] b, int[] res){
		// merge both halves into result array
		// next element to consider in first array
		int i = 0; // pointer for array a
		int j = 0; // pointer for array b
		
		// next open position in the result
		int k = 0;
		
		while(i < a.length && j < b.length){
			if(a[i] < b[j]){
				res[k] = a[i];
				i++;
			} else {
				res[k] = b[j];
				j++;
			}
			k++;
		}
		System.arraycopy(a, i, res, k, a.length - i);
		System.arraycopy(b, j, res, k, b.length - j);
		
	}
	
	public static void printAr(int[] ar){
		for(int i = 0; i < ar.length; i++){
			System.out.print(ar[i] + " ");
		}
	}
	public static void main(String args[]){
		int[] ar = new int [6];
		ar[0] = 10;
		ar[1] = 4;
		ar[2] = 6;
		ar[3] = 8;
		ar[4] = 35;
		ar[5] = 14;
		printAr(mergeSort(ar));
	}
}
