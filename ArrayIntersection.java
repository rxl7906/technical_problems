import java.util.ArrayList;
import java.util.HashSet;

/* given two sorted arrays; write a method that returns the intersection of the arrays
 * Ex: [2,4,3,6] and [8,9,2,4] returns 2,4
 */
public class ArrayIntersection {
	
	/*public static int[] findIntersection(int[] a, int[] b){
		int i = 0, j = 0, counter = 0;
		int[] inter = new int[Math.min(a.length,  b.length)];
		while(i < a.length && j < b.length){
			if(a[i] == b[j]){
				inter[counter] = a[i];
				counter++;
				i++;
				j++;
			} else if(a[i] > b[j]){
				j++;
			} else if(a[i] < b[j]){
				i++;
			}
		}
		return inter;
	}*/
	
	// Complexity:
	// Space: O(min(n,m))
	// Time: O(n + m)
	public static ArrayList<Integer> findIntersection(int[] a, int[] b){
		boolean aFirst = false;
		HashSet<Integer> hs = new HashSet<Integer>();
		int interPtr = 0;
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		if(a.length <= b.length){
			// go thru a first
			aFirst = true;
		} // else go thru b first
		
		if(aFirst){
			for(int i = 0; i < a.length; i++){ // go thru a first
				hs.add(a[i]);
			}
			for(int j = 0; j < b.length; j++){ // go thru b second
				if(hs.contains(b[j])){ // found intersection
					//intersection[interPtr] = b[j];
					intersection.add(b[j]);
				}
			}
		} else {
			for(int i = 0; i < b.length; i++){ // go thru b first
				hs.add(b[i]);
			}
			for(int j = 0; j < a.length; j++){ // go thru a second
				if(hs.contains(a[j])){ // found intersection
					//inter[interPtr] = b[j];
					intersection.add(a[j]);
				}
			}
		}
		return intersection;
	}
	
	public static void main(String args[]){
		int[] a = new int[] {2,4,3,6};
		int[] b = new int[] {8,9,2,4};
		/*int[] c = findIntersection(a,b);
		for(int i = 0; i < c.length; i++){
			System.out.println(c[i]);
		}*/
		ArrayList<Integer> c = findIntersection(a,b);
		for(Integer i : c){
			System.out.println(i);
		}
	}
}
