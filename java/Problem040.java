
/*Considering we have the irrational number 0.1234567891011121314151617...., 
 * consisted of the consecutive natural numbers. The 12th digit is 1.
 * Find  d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000*/

public class Problem40 {
	
	public static void main(String[] args){
		int digits = 0;
		int N = 0; // N is just a variable to parse all the natural numbers.
		int[] a = {10, 100, 1000, 10000, 100000, 1000000};
		int i = 0;
		int result = 1;
		while(digits <= a[5]){
			N++;
			digits += String.valueOf(N).length();
			if(digits > a[i]){
				int before = digits - String.valueOf(N).length();
				int characterPosition = a[i] - before;
				i++;
				System.out.println(i + " : " + String.valueOf(N).charAt(characterPosition-1));
				result *= Integer.parseInt(String.valueOf(N).charAt(characterPosition-1) + "");
			}
		}
		System.out.println("Result : " + result);
	}
	
}
 