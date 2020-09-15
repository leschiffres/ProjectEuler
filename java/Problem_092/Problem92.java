import java.util.ArrayList;



public class Problem92 {

	// Square Digit Chains
	
	/*This solution is similar to the one used in problem 74. It uses the same method
	 * in order to compute the chain. However this is not necessary in this problem, 
	 * as we can just get new elements until we end up in element 1 or 89.
	 * 
	 * Of course, this method does unnecessary computation and its solution could be 
	 * much simpler, but it's nice using existing code.*/
		public static void main(String[] args) {
			int result = 0;
			for (int i = 1; i <= 10000000; i++) {
				int N = i;
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(N);
				// Find the sum of the square of the digits of N
				int next = sumSquare(N);
				while (!a.contains(next)) {

					a.add(next);
					next = sumSquare(next);
				}
				if(a.contains(89)){
					result++;
				}
			}
			System.out.println("Number of starting numbers arriving at 89 : " + result);
		}

		/*
		 * Given a number N (e.g. 132), we want to compute the sum of the square
		 * of its digits, i.e. (sumFact(132) = 1*1 + 3*3 + 2*2 = 1 + 9 + 4 = 14)
		 * 
		 * Thus we need to : 
		 * a. get the digits of the number N 
		 * b. compute the square of every digit
		 * c. sum the square
		 */

		static int sumSquare(int N) {
			int sum = 0;

			/*
			 * The following while loop is important so that we are able to locate
			 * the first digit of number N. If N = 130 then j should be 100 by the
			 * end of this loop.
			 */
			int div = 0;
			int j = 10000000;
			while (true) {
				div = N / j;
				if (div >= 1) {
					break;
				}
				j = j / 10;
			}

			// We calculate the sum of the square of its digits
			for (int i = j; i >= 1; i = i / 10) {
				int digit = N / i;
				sum += square(digit);
				N = N % i;
			}
			return sum;

		}
		
		static int square(int d){
			return d*d;
		}

}
