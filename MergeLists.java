
public class MergeLists {
	
	public static int[] mergeLists(int[] ar1, int[] ar2, int k){
		// index reference for ar and counter
		int i = 0;
		// index reference
		int a = 0;
		int b = 0;
		// lengths of ars
		int m = ar1.length;
		int n = ar2.length;
		int[] ar = new int[k];
		
		while(i < k){
			if(ar1[a] <= ar2[b] && a < m){
				ar[i] = ar1[a];
				a++;
				i++;
			} else if(ar1[a] > ar2[b] && b < n){ // ar1[a] > ar2[b]
				ar[i] = ar2[b];
				b++;
				i++;
			}
			System.out.println(ar[i]);
		}
		return ar;
	}
	
	public static void main(String args[]){
		int[] ar1 = {1,3,5,7,9};
		int[] ar2 = {2,4,6,8,10};
		int k = 5;
		int[] res = mergeLists(ar1,ar2, k);
		//System.out.println("HERE");
		/*for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}*/
	}
}
