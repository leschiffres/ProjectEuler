public class Problem7 {
	/* This problem is solved by using Eratosthenis algorithm to find all the prime numbers.
	 * Basically after implementing the algorithm we end up with a boolean matrix, where for
	 * every number i, if a[i] is true then i is a prime number.
	 * 
	 * More details about the algorithm can be found in the following link.
	 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * 
	 * Thus, we just need to find the 10001-th number and we just count them one by one
	 * until we reach the indicated prime number. Hence, we set up a large value 
	 * e.g N = 150000 so that at least 10001 prime numbers are contained.
	 * */
	
	public static void main(String[] args){
		int N = 150000;
		boolean a[] = new boolean[N];
		for(int i = 1; i < N; i++){
			a[i] = true;
		}
		for(int i = 2; i < Math.sqrt(N); i++){
			if(a[i]){
				for(int j = i*i; j <N ; j+=i){
					a[j] = false;
				}
			}
		}
		int counter = 0;
		for(int i = 2; i < N; i++){
			if(a[i] ) {
				counter++;
				
			}
			
			if(counter == 10001){
				System.out.println("The 10001-th prime number is : "  + i);
				break;
			}
		}
	}
	
}
