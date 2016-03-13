import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
* <h1>Array functions</h1>
* The Array class implements methods that manipulate 
* integer arrays. 
* <p>
* 
* @author  Robin Li
* @since   2015-09-05
*/

public class Array {
	
	/** 
	 * Partition integer array with odd integers to left of array; even integers on right
	 * <p>
	 * First Solution:
	 * Complexity:
	 * - Time: O(n) (one pass thru array a, one pass adding to array b)
	 * - Space: O(n) (array b)
	 * <p>
	 * Second Solution: (In-place solution)
	 * - Time: O(n) (one pass thru array a)
	 * - Space: O(1) (constant space)
	 * 
	 * @param	array of integers to be partitioned
	 * @return	array of odd integers partitioned to the left and even integers to the right
	 */
	public static int[] partition(int[] a){
		/*int[] b = new int[a.length];
		int c = 0;
		for(int i = 0; i < a.length; i++){
			if((a[i] % 2) == 1){
				b[c] = a[i];
				c++;
			}
		}
		for(int j = 0; j < a.length; j++){
			if((a[j] % 2) == 0){
				b[c] = a[j];
				c++;
			}
		}
		return b;*/
		int l = 0, r = a.length-1;
		while(l < r){
			while(a[l]%2==1 && l < r) l++;
			while(a[r]%2==0 && l < r) r--;
			if(l < r){
				int tmp = a[l];
				a[l] = a[r];
				a[r] = tmp;
				l++;
				r--;
			}
		}
		return a;
	}
	
	/** 
	 * Problem:
	 * - Find all repeating elements in array; print them
	 * First Solution:
	 * Complexity:
	 * - Time: O(n)
	 * - Space: O(n)
	 * Improvement:
	 * - Solve in O(n) time and O(1) constant space
	 * 
	 * @param	array of integers
	 */
	public static void findRepeats(int[] a){
		int[] c = new int[a.length];
		for(int i = 0; i < a.length; i++){
			if(c[a[i]] == 1) System.out.print(a[i]+" ");
			else c[a[i]]++;
		}
		// following works if array elements is less than size
		/*for(int i = 0; i < a.length; i++){
			System.out.println(i+" a[i]: "+a[i]);
			if(a[Math.abs(a[i])] >= 0){
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			} else {
				System.out.print(Math.abs(a[i])+" ");
			}
		}*/
	}
	
	/**
	 * Problem:
	 * - Remove duplicates in array
	 * First Solution:
	 * Complexity:
	 * - Time: O(n)
	 * - Space: O(n)
	 * Improvement:
	 * Merge sort (O(nlogn) time) then pass thru array?
	 * 
	 * @param	integer array
	 * @return	nothing
	 */
	public static void removeDuplicates(int[] a){
		Set<Integer> s = new HashSet<Integer>();
		for(int i : a) s.add(i);
		for(int i: s) System.out.print(i+" ");
	}
	
	/**
	 * Problem:
	 * - Given string of digits and integer n, delete n characters from string s.t. result string
	 * contains minimal number representation.
	 * Test Case:
	 * - Input: s = "121198", n = 2
	 * - Output: "1118"
	 * - Input: s = "4325043", n = 3
	 * - Output: "2043"
	 * - Input: s = "765028321", n = 5
	 * - Output: "0221"
	 * Status:
	 * IN PROGRESS
	 * 
	 * @param s
	 * @param n
	 * @return
	 */
	public static String buildLowestNumber(String s, int n){
		String res = "";
		if(n == 0) return res+s;
		int len = s.length();
		if(len <= n) return res;
		int c = 0;
		char[] a = s.toCharArray();
		while(res.length() < n+1){
			int lowest = Integer.MAX_VALUE;
			for(int i = 0; i < (n+1); i++){
				System.out.println(s.charAt(i));
				if(s.charAt(i) < lowest){
					lowest = (int)s.charAt(i);
					System.out.println(lowest);
				}
			}
			
			res = "" + (char)lowest;
		}
		return res;
	}
	
	/**
	 * Problem:
	 * - Reverse integer array
	 * First Solution:
	 * Complexity:
	 * - Time: O(n) (half a pass)
	 * - Space: O(1) (constant space)
	 * 
	 * @param integer array
	 * @return reversed integer array
	 */
	public static int[] reverse(int[] a){
		for(int i = 0; i < a.length/2; i++){
			int tmp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length-i-1] = tmp;
		}
		return a;
	}
	
	// Problem: 
	// - Find the maximum product of any two integers in array
	// Assumption:
	// - Account for negative numbers as well
	// Test Cases:
	// - Input: a = [5,8,0,9,1]
	// - Output: 72
	// Complexity:
	// Time: O(n) (one pass thru a)
	// Space: O(1) (constant space)
	public static int maxProduct(int[] a){
		int high1 = Integer.MIN_VALUE;
		int high2 = Integer.MIN_VALUE;
		int low1 = Integer.MAX_VALUE;
		int low2 = Integer.MAX_VALUE;
		for(int i : a){
			if(i > high1){
				high2 = high1;
				high1 = i;
			} else if(i > high2){
				high2 = i;
			}
			if(i < low1){
				low2 = low1;
				low1 = i;
			} else if(i < low2){
				low2 = i;
			}
		}
		int res1 = high1*high2;
		int res2 = low1*low2;
		if(res1 < res2){
			return res2;
		}
		return res1;
	}
	
	// given 2 sorted arrays and integer k, merge lists up to a max of k elements
	public static int[] getLeastkNums(int[] ar1, int[] ar2, int k){
		int m = ar1.length, n = ar2.length, a = 0, b = 0, len = 0, i = 0;
		if(k > (m+n)){ // if k is greater than # of integers in array
			len = m+n;
		} else { // if k is less than equal to # of integers in array
			len = k;
		}
		int[] ar = new int[len];
		while(i < len){
			if(a < m && b < n){
				if(ar1[a] <= ar2[b]){
					ar[i] = ar1[a];
					a++;
				} else{
					ar[i] = ar2[b];
					b++;
				}
			} else {// either a or b is at the end
				if(a == m && b < n){
					// add b
					ar[i] = ar2[b];
					b++;
				} else {
					ar[i] = ar1[a];
					a++;
				}
			}
			i++;
		}
		return ar;
	}
	
	// Problem:
	// - Find all integers that appear an odd number of times in array
	// First Solution:
	// Complexity:
	// - Time: O(n) (one pass thru a, one pass thru hashmap)
	// - Space: O(n) (hashmap space)
	public static void oddNumber(int[] a){
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i : a){
			if(hm.containsKey(i)) hm.put(i, hm.get(i)+1);
			else hm.put(i, 1);
		}
		for(Map.Entry<Integer, Integer> e : hm.entrySet()){
			if(e.getValue() % 2 == 1){
				System.out.println(e.getKey());
			}
		}
	}
	
	// Find second maximum integer in array
	public static void secondMax(int[] a){
		int maxOne = Integer.MIN_VALUE;
		int maxSecond = Integer.MIN_VALUE;
		for(int i : a){
			if(i > maxOne){
				maxSecond = maxOne;
				maxOne = i;
			} else if(i > maxSecond){
				maxSecond = i;
			}
		}
		System.out.println(maxSecond);
	}
	
	// Find the second minimum in array
	public static void secondMin(int[] a){
		int minOne = Integer.MAX_VALUE;
		int minSecond = Integer.MAX_VALUE;
		for(int i : a){
			if(i < minOne){
				minSecond = minOne;
				minOne = i;
			} else if(i < minSecond){
				minSecond = i;
			}
		}
		System.out.println(minSecond);
	}
	
	// (Compass)
	// Problem: 
	// - Find missing integer from integer array
	/*static void findMissing(int[] a){
		int n = a.length;
		int sum = (n+1)*(n+2)/2;
		for(int i : a){
			sum = sum - i;
		}
		System.out.println(sum);
	}*/
	// Problem:
	// - Find missing integers from integer array
	public static void findMissing(int[] a, int lower, int upper){
		/*ArrayList<Integer> ar = new ArrayList<Integer>();
		Arrays.sort(a);
		int expected = 0, i = 0;
		while(i < a.length){
			if(expected == a[i]){
				i++;
				expected++;
			} else {
				ar.add(expected);
				//System.out.println(expected);
				expected++;
			}
		}
		for(Integer j : ar){
			System.out.println(j);
		}
		System.out.println(expected);*/
		
		// use boolean array
		boolean[] ar = new boolean[upper+1];
		for(int i : a){
			ar[i] = true;
		}
		for(int j = 0; j < ar.length; j++){
			if(!ar[j]){
				System.out.println(j);
			}
		}
	}
	
	// Problem: 
	// - Determine if the 2 given integer arrays have same set of integers
	public static boolean sameIntegers(int[] a, int[] b){
		HashSet<Integer> hs = new HashSet<Integer>();
		if(a.length < b.length){
			for(int i : a) hs.add(i);
			for(int j : b){
				if(hs.contains(j)) continue;
				else return false;
			}
		} else {
			for(int i : b) hs.add(i);
			for(int j : a){
				if(hs.contains(j)) continue;
				else return false;
			}
		}
		return true;
	}
	
	// find non repeating element in an array
	// int[] a = new int[]{3,4,1,3,1,7,2,2,4};
	public static int nonRepeatingElement(int[] a){
		int ele = 0;
		for(int i : a){
			ele^=i;
			System.out.println(ele);
		}
		return ele;
	}
	
	// Problem:
	// - Find all pairs in integer array whose sum is equal to given number
	// 1st Solution: (Brute Force)
	// Complexity:
	// - Time: O(n^2)
	// - Space: O(1) (constant space)
	// 2nd Solution: (Use Hashset)
	// - Time: O(n) 
	// - Space: O(n) (hashset space)
	// 3rd Solution: (sort, then left/right pointers find pairs)
	// - Time: O(NlogN) + O(N) (sort + one pass)
	// - Space: O(1) (constant space)
	public static void findPairs(int[] a, int n){
		/*for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				if(a[i] == a[j]){
					continue;
				} else {
					if(a[i]+a[j] == n){
						System.out.println("("+a[i]+","+a[j]+")");
					}
				}
				if(a[i]+a[j] == n){
					System.out.println("("+a[i]+","+a[j]+")");
				}
			}
		}*/
		// hashset
		/*if(a.length < 2) return;
		Set<Integer> hs = new HashSet<Integer>();
		for(int i : a){
			int target = n - i;
			if(!hs.contains(target)) hs.add(i);
			else System.out.println(i+" "+target);
		}*/
		if(a.length < 2) return;
		Arrays.sort(a);
		int l = 0, r = a.length-1, sum = 0;
		while(l<r){
			sum = a[l]+a[r];
			if(sum == n){
				System.out.println(a[l]+" "+a[r]);
				l++;
				r--;
			} else if(sum < n){ // move left ptr
				l++;
			} else { // move right ptr
				r--;
			}
		}
	}
	
	// Problem:
	// - Given integer array (positive and negative), find the maximum sum of consecutive integers
	// Status:
	// IN PROGRESS
	public static int maxSum(int[] a){
		// testing commit
		for(int i : a){
			System.out.println(i);
		}
		return 0;
	}
	
	// EOPI Problem 6.1
	// Write a function that takes an array A of length n and an index i into A,
	// and rearranges the elements such that all elements less than A[i] appear first,
	// followed by elements equal to A[i], followed by elements greater than A[i]. 
	//static int[] 
	
	// testing commit
	
	public static void main(String args[]){
		int[] a = new int[] {2,4,3,6,7,9,13,17,14,18,19};
		int[] b = partition(a);
		for(int i : b) System.out.print(i+" ");
		
		//int[] a = new int[] {5,2,8,3,4,1,8,5,4,2,1,0,0};
		//int[] a = new int[] {5,4,6,3,5,4};
		//findRepeats(a);
		//removeDuplicates(a);
		
		//System.out.println(buildLowestNumber("121198",2));
		
		/*int[] b = reverse(a);
		for(int i : b) System.out.println(i);*/
		
		//int[] a = new int[] {5, 8, 0, 9, 1};
		//int[] a = new int[] {-50, 4, 3, -1};
		//System.out.println(maxProduct(a));
		
		// get least k numbers
		/*int[] ar1 = {1, 4, 6, 8};
		int[] ar2 = {5, 7, 9, 10};
		int[] res = getLeastkNums(ar1, ar2, 15);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}*/
		
		//int[] a = new int[]{3,7,3,7,3,7,8,9,8,9};
		//oddNumber(a);
		
		//int[] a = new int[]{4,9,3,1,6};
		//secondMax(a);
		//secondMin(a);
		
		//int[] a = new int[]{0,5,2,3,7};
		//findMissing(a,0,8);
		
		//int[] a = new int[]{5,4,7,2,6,3};
		//int[] b = new int[]{7,4,5,2,3,6};
		//System.out.println(sameIntegers(a,b));
		
		//int[] a = new int[]{3,4,1,3,1,7,2,2,4};
		//int[] a = new int[]{2,4,7,2,4};
		//System.out.println(nonRepeatingElement(a));
		//System.out.println(2^4);
		
		//int[] a = new int[]{2,6,3,9,11};
		//int[] a = new int[]{12,14,17,15,19,20,-11};
		//findPairs(a, 9);
		
		//int[] a = new int[]{2,6,3,9,11};
		//maxSum(a);
	}
}
