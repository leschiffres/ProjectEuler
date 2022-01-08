/*Collatz sequence numbers*/
public class Problem14 {
	static int[] cardinality = new int[1000001];
	static int maxIterations = 0;
	static int maxID = 0;
	public static void main(String[] args){
		
		for(int i = 0; i < 1000001; i++){
			collatzSequence(i);
		}
		
		System.out.println("Max ID : " + maxID);
		System.out.println("Max Iterations : " + maxIterations);
	}
	
	static void collatzSequence(int N){
		long k = N;
		int iter = 0;
		while(k > 1){
			if(isEven(k)){
				k = k/2;
			}
			else{
				k = 3*k+1;
			}
			iter++;
		}
		
		cardinality[N] = iter;
		if(iter > maxIterations){
			maxID = N;
			maxIterations = iter;
		}
	}
	
	static boolean isEven(long N){
		return N % 2 == 0;
	} 
	
}
