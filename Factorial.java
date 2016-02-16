
public class Factorial {
	// recursively
	/*static int factorial(int n){
	if(n == 0) return 1;
	return n * factorial(n-1);
	}*/
	
	// iteratively
	/*static int factorial(int n){
		int fact = 1;
		while(n != 0){
			fact*=n;
			n--;
		}
		return fact;
	}*/
	
	// iteratively without multiplication sign
	static int factorial(int n){
		int ans = n;
		for(int i = 0; i < n; i++){
			int tot = 0;
			for(int j = 0; j < n-1; j++){
				tot = tot + ans;
			}
			ans = tot;
			n--;
		}
		return ans;
	}
	/*
	boolean powerOfTwo(int x){
	    if(n == 0){
	        return false;
	    } else if(n == 1){
	        return true;
	    } else if(n%2 == 1){
	        return false;
	    } else {
	        return powerOfTwo(n/2);
	    }
	}

	2^0 = 1
	2^1 = 2
	2^2 = 4
	2^3 = 8
	2^4 = 16 
	2^e = 

	XOR - ^
	AND - &
	OR - |


	0000 - 0
	0001 - 1 *
	0010 - 2 *
	0011 - 3
	0100 - 4 *
	0101 - 5
	0110 - 6
	0111 - 7
	1000 - 8 *

	(x & (x-1)) == 0

	int count = 0;
	while(x != 0){
	   if(x & 1 == 1) count++;
	   x = x >>> 1;
	}*/
	public static void main(String args[]){
		//System.out.println(factorial(5));
		Integer num = Integer.MAX_VALUE;
		System.out.println(factorial(num));
	}
}
