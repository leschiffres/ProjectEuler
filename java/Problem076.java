import java.util.Arrays;

public class Problem76 {
	/*static int n = 100;
	static int[][] C = new int[n + 1][n + 1];*/
	
	static long countWays(int S[], int m, int n) {
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]];

		return table[n];
	}
	
	public static void main(String args[]) {
		int N = 100;
		int arr[] = new int[N - 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		int m = arr.length;

		System.out.println(countWays(arr, m, N));
	}
}
