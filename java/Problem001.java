public class Problem1 {
	public static void main(String[] args) {
		int sum = 0;
		// Add all multiplicatives of 3
		for (int i = 3; i < 1000; i = i + 3) {
			sum += i;
		}
		// Add only the multiplicatives of 5 that are not multiplicatives of 3
		// since they have already been added.
		for (int i = 5; i < 1000; i = i + 5) {
			if (i % 3 != 0) {
				sum += i;
			}
		}
		System.out.println("The total sum = " + sum);
	}
}
