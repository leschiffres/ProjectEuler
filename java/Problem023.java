
public class Problem23 {

	public static void main(String[] args){
		long start = System.currentTimeMillis();
		int[] divisorsSum = new int[28123 + 1];
		boolean[] isAbundant = new boolean[28123 + 1];
		for(int N = 1; N <= 28123; N++){
			boolean[] div = new boolean[N/2 + 1];
			for(int i = 2; i < div.length;i++){
				div[i] = true;
			}
			divisorsSum[N]++;
			for(int i = 2; i <= N/2;i++){
				if(div[i]){
					if(N % i == 0){
						divisorsSum[N] += i;
						//System.out.println(i);
					}
					else{
						int index = i;
						while(index < div.length){
							div[index] = false;
							index += i;
						}
					}
				}
			}
			if(divisorsSum[N] > N){
				isAbundant[N] = true;
				//System.out.println(N + " : is abundant" );
			}
		}	
		int totalSum = 0;
		for(int N = 1; N <= 28123; N++ ){
			boolean found = false;
			for(int i = 1; i <= N/2 && !found ; i++){
				if(isAbundant[i] && isAbundant[N-i]){
					found = true;
				}
			}
			if(!found){
				totalSum+= N;
				//System.out.println(N);
			}
		}
		System.out.println("Total sum of numbers that cannot written as the sum of two abundant numbers : " + totalSum);
		
		System.out.println((double)(System.currentTimeMillis() - start)/1000 + " sec");
	}
	
}
