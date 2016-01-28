
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
	public static void main(String args[]){
		//System.out.println(factorial(5));
		Integer num = Integer.MAX_VALUE;
		System.out.println(factorial(num));
	}
}
