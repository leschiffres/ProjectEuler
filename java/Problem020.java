import java.math.BigInteger;
import java.util.ArrayList;

/*The factorial of a number n is n! = 1 * 2 * 3 * ..... * n-1 * n 
 * 
 * for example 10! = 3628800. The sum of this digits = 3 + 6 + 2 + 8 + 8 = 27
 * 
 * Find the sum of digits of 100!*/ 

class Problem20 {

	public static void main(String[] args){
		
		BigInteger result = new BigInteger("1");
		for(int i = 1; i <= 100; i++){
			result = result.multiply(new BigInteger(String.valueOf(i)));
		}
		System.out.println(result.toString());
		String s = result.toString();
		int sum = 0;
		for(int i = 0; i < s.length(); i++){
			sum += Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		System.out.println(sum);
	}
	
}
