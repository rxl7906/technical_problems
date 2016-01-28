import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;


public class PrimeSieve {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a value: ");
		int n = input.nextInt();
		//System.out.println(findPrimes(n));
		ArrayList<Integer> ar = findPrimes(n);
		int c = 0;
		for(int i = 0; i < ar.size(); i++){
			if(ar.get(i) > 90000){
				System.out.println(ar.get(i));
				c++;
			}
		}
		System.out.println("number of primes: "+c);
	}
	/** Use an ArrayList of Integers to store the collection of numbers
	 * Implement sieve algorithm and Display list of prime numbers
	 * @param lista	list of boolean values with i and j s
	 */ 
	public static ArrayList<Integer> findPrimes(int n) {
		ArrayList<Boolean> lista = new ArrayList<Boolean>();
		for (int i = 0; i < n; i++  ) {
			lista.add(true);
		}
		for (int i = 2; i < Math.sqrt(n); i++){
			if (lista.get(i) == true){
				for (int j = i*i; j < n; j = j + i) {
					lista.set(j,false);
				}	
			}
		}
		ArrayList<Integer> listb = new ArrayList<Integer>();
		for (int k = 2; k < lista.size(); k++){
			if (lista.get(k) == true) {
				listb.add(k);
			}
		}
		return listb;
	}
}
