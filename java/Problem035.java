import java.util.LinkedList;

public class Problem35 {
	static LinkedList<Integer> perms;
	static int howmany = 0;
	public static void main(String[] args){
		perms = new LinkedList<Integer>();
		algorithm();
	}
	
	public static void circularPermutations(int i){

		perms.add(i);
		String init = String.valueOf(i);
		String newS = "", prevS = init;
		while(!newS.equals(init)){
			newS = prevS.substring(1, prevS.length());
			newS += prevS.charAt(0);
			if(!newS.equals(init)){
				perms.add(Integer.parseInt(newS));
			}
			prevS = newS;
		}
	}
	
	public static void algorithm(){
		System.out.println("Program Started");
		long start = System.currentTimeMillis();
		int N = 1000000;
		boolean a[] = new boolean[N];
		for(int i = 1; i < N; i++){
			a[i] = true;
			//System.out.println(a[i]);
		}
		for(int i = 2; i < Math.sqrt(N); i++){
			if(a[i]){
				for(int j = i*i; j <N ; j+=i){
					a[j] = false;
				}
			}
		}
		/*Counting primes until 1000000*/
		int totalprimes = 0;
		for(int i = 1; i < N; i++){
			if(a[i]){
				totalprimes++;
			}
		}
		
		System.out.println("Total Primes : " + totalprimes);
		/*--------------------------------------------*/
		
		int sum = 13;
		for(int i = 100 ; i < N; i++){
			if(a[i]){
				/*Get the digits of an integer*/
				perms = new LinkedList<Integer>();
				/*Find the circular permutations with these digits*/
				circularPermutations(i);
				boolean allPrimes = true;
				/*If the number now is prime then check the primality of all its 
				 * permutations. If they are all primes then increase by 1 + the size of this set.
				 * Then you can set of all these primes as false so that you dont have to recheck them.*/
				for(Integer k : perms){
					if(!a[k]){
						allPrimes = false;
					}
				}
				if(allPrimes){
					//System.out.println("All of these guys are primes!!! : " + i);
					sum += perms.size();
				}
				for(Integer k: perms){
					a[k] = false;
				}
				
			}
		}
		System.out.println("Total circular primes : " + sum);
		System.out.println("Total Time : " + ( (double)(System.currentTimeMillis() - start)/1000) + " seconds.");
	}
}
