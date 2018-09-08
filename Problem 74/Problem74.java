import java.util.ArrayList;

public class Problem74 {

	// Digital Factorial Chains
	public static void main(String[] args) {
		int result = 0;
		for (int i = 1; i <= 1000000; i++) {
			int N = i;
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(N);
			// Find the sum of the factorial of the digits of N
			int next = sumFact(N);
			while (!a.contains(next)) {

				a.add(next);
				next = sumFact(next);
			}
			/*
			 * Once the while loop ends, we have found a chain. Therefore we
			 * need to find the length of the chain, which is the number of the
			 * elements we have added to the arraylist a.
			 */
			int lengthChain = a.size();
			
			// Count the number of 60 number chains 
			if(lengthChain == 60){
				result++;
			}
		}
		System.out.println("Number of chains that contain exactly sixty non-repeating terms : " + result);
	}

	/*
	 * Given a number N (e.g. 132), we want to compute the sum of the factorial
	 * of its digits, i.e. (sumFact(132) = 1! + 3! + 2! = 1 + 6 + 2 + 9)
	 * 
	 * Thus we need to : a. get the digits of the number N b. compute the
	 * factorial of every digit c. sum the factorials
	 */

	static int sumFact(int N) {
		int sum = 0;

		/*
		 * The following while loop is important so that we are able to locate
		 * the first digit of number N. If N = 130 then j should be 100 by the
		 * end of this loop.
		 */
		int div = 0;
		int j = 1000000;
		while (true) {
			div = N / j;
			if (div >= 1) {
				break;
			}
			j = j / 10;
		}

		// We calculate the sum of the factorial of its digits
		for (int i = j; i >= 1; i = i / 10) {
			int digit = N / i;
			sum += factorial(digit);
			N = N % i;
		}

		return sum;
	}

	// function that computes the factorial of a given number
	static int factorial(int N) {
		int sum = 1;
		for (int i = 2; i <= N; i++) {
			sum = sum * i;
		}

		return sum;
	}

}
