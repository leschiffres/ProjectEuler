
public class Problem10 {
	public static void main(String[] args){
		
		int N = 2000000;
		boolean a[] = new boolean[N];
		for(int i = 1; i < N; i++){
			a[i] = true;
			//System.out.println(a[i]);
		}
		for(int i = 2; i < Math.sqrt(N); i++){
			if(a[i]){
				//System.out.println("mphke");
				for(int j = i*i; j <N ; j+=i){
					a[j] = false;
				}
			}
		}
		int counter = 0;
		long sum = 0;
		for(int i = 2; i < N; i++){
			if(a[i] ) {
				counter++;
				sum += i;
				System.out.println(counter + " : " + i);
				
			}
			//System.out.println(a[i]);
		}
		System.out.println("Sum = " + sum);
	}
	
}
