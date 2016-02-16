import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Array {
	
	// partition an array of integers with odd on left; even on right
	public static int[] partition(int[] a){
		int[] b = new int[a.length];
		int c = 0;
		for(int i = 0; i < a.length; i++){
			if((a[i] % 2) == 0){
				b[c] = a[i];
				c++;
			}
		}
		for(int j = 0; j < a.length; j++){
			if((a[j] % 2) == 1){
				b[c] = a[j];
				c++;
			}
		}
		return b;
	}
	
	// find all repeating elements in array; print them
	// Complexity:
	// Time: O(n)
	// Space: O(n)
	public static void findRepeats(int[] a){
		int[] c = new int[a.length];
		for(int i = 0; i < a.length; i++){
			if(c[a[i]] == 1){
				System.out.println(a[i]);
			} else {
				c[a[i]]++;
			}
		}
	}
	
	// remove duplicates in array
	static int[] removeDuplicates(int[] a){
		int[] b = null;
		Set<Integer> s = new HashSet<Integer>();
		for(int i : a){
			s.add(i);
		}
		for(int i: s){
			System.out.println(i);
		}
		return b;
	}
	
	// given string of digits, and int n, delete n characters from string s.t. result string
	// contains minimal number representation
	static String buildLowestNumber(String s, int n){
		String res = "";
		while(res.length() < n+1){
			int lowest = Integer.MAX_VALUE;
			for(int i = 0; i < (n+1); i++){
				if(s.charAt(i) < lowest){
					lowest = (int)s.charAt(i);
				}
			}
			res = "" + (char)lowest;
		}
		System.out.println(res);
		return res;
	}
	
	// reverse array
	public static int[] reverse(int[] a){
		for(int i = 0; i < a.length/2; i++){
			int tmp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length-i-1] = tmp;
		}
		return a;
	}
	
	// Given an array of integers, find the maximum product of
	// any two integers in the array.
	// test cases:
	// [5,8,0,9,1]
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
		// find product
		int res1 = high1*high2;
		int res2 = low1*low2;
		if(res1 < res2){
			return res2;
		}
		return res1;
	}
	
	// given 2 sorted arrays and integer k, merge lists up to a max of k elements
	static int[] getLeastkNums(int[] ar1, int[] ar2, int k){
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
	
	// Given array of integers, find the duplicates
	static void findDuplicate(int[] a){
		int repeat = 0;
		/*for(int i = 0; i < a.length; i++){
			if(a[i] >= 0){
				a[i] = -a[i];
			} else {
				// this element is the repeat
				repeat = a[i];
			}
		}*/
		for(int i = 0; i < a.length; i++){
			if(a[Math.abs(a[i])] >= 0){
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			} else{
				System.out.println(a[i]);
			}
		}
	}
	
	// find all numbers that occurred an odd-number of
	// of times in an array
	static void oddNumber(int[] a){
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i : a){
			if(hm.containsKey(i)){
				hm.put(i, hm.get(i)+1);
			} else{
				hm.put(i, 1);
			}
		}
		for(Map.Entry<Integer, Integer> e : hm.entrySet()){
			if(e.getValue() % 2 == 1){
				System.out.println(e.getKey());
			}
		}
	}
	
	// find second max integer in array
	static void secondMax(int[] a){
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
	
	// find the second minimum in array
	static void secondMin(int[] a){
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
	// find missing integer from an array of integers
	// find the missing integers from array of integers
	/*static void findMissing(int[] a){
		int n = a.length;
		int sum = (n+1)*(n+2)/2;
		for(int i : a){
			sum = sum - i;
		}
		System.out.println(sum);
	}*/
	static void findMissing(int[] a, int lower, int upper){
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
	
	// given 2 arrays of numbers find if each of the two arrays have the
	// same set of integers
	static boolean sameIntegers(int[] a, int[] b){
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
	static int nonRepeatingElement(int[] a){
		int ele = 0;
		for(int i : a){
			ele^=i;
			System.out.println(ele);
		}
		return ele;
	}
	
	// find all pairs in array of integers whose sum
	// is equal to a given number
	// 3 solutions:
	// 1) Brute force: Time: O(N^2)
	// 2) Hashset: Time: O(N) Space: O(N)
	// 3) Sort: sort, then left/right ptr find pairs
	// Time: O(NlogN) + O(N)
	static void findPairs(int[] a, int n){
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
		if(a.length < 2) return;
		/*Set<Integer> hs = new HashSet<Integer>();
		for(int i : a){
			int target = n - i;
			if(!hs.contains(target)) hs.add(i);
			else System.out.println(i+" "+target);
		}*/
		
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
	
	// given array of integers (positive and negative), find the maximum sum of consecutive integers
	static int maxSum(int[] a){
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
	
	public static void main(String args[]){
		/*int[] a = new int[] {2,4,3,6,7,9,13,17,14,18,19};
		int[] b = partition(a);
		for(int i : b){
			System.out.println(i);
		}*/
		//int[] a = new int[] {5,2,8,3,4,1,8,5,4,2};
		//findRepeats(a);
		//removeDuplicates(a);
		/*int[] b = reverse(a);
		for(int i : b){
			System.out.println(i);
		}
		buildLowestNumber("121198",2);*/
		
		// test cases for maxProduct
		//int[] a = new int[] {5, 8, 0, 9, 1};
		//int[] a = new int[] {-2, 1, 0};
		//int[] a = new int[] {-50, 4, 3, -1};
		//System.out.println(maxProduct(a));
		
		// get least k numbers
		/*int[] ar1 = {1, 4, 6, 8};
		int[] ar2 = {5, 7, 9, 10};
		int[] res = getLeastkNums(ar1, ar2, 15);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}*/
		
		// find duplicate in O(n) and constant space
		//int[] a = new int[]{5,3,7,1,8,4,3};
		//findDuplicate(a);
		
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
		
		int[] a = new int[]{2,6,3,9,11};
		maxSum(a);
	}
}
