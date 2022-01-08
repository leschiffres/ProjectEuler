import java.util.ArrayList;
public class Problem50 {
	
	//static ArrayList<Integer> primes;
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static ArrayList<ArrayList<Integer>> termsList = new ArrayList<ArrayList<Integer>>();
	static int maxPrime ;
	static int maxLength;
	public static void main(String[] args){
		
		primes = MyFunctions.EratosthenisSieve(1000000);
		//primes = MyFunctions.EratosthenisSieve(1000);
		System.out.println("Total Primes : " + primes.size());
		int bound = 100000;
		int j = 1;
		for(int i = 0; i < primes.size();i++){
			if(primes.get(i) > bound){
				System.out.println(primes.get(i));
				j++;
				bound  = 100000*j;
			}
			findConsecutivePrimes(primes.get(i));
		}
		System.out.println("Max prime : " + maxPrime + " with sequence length : " + maxLength);	
		
	}
	
	static void findConsecutivePrimes(int N){
		int start = 0;
		int end = -1;
		int i = 0;
		int sum = 0;
		while(primes.get(start) < N){
			if(sum < N){
				end++;
				if(end < primes.size()){
					i = primes.get(end);
					sum += i;
				}
				else{
					return;
				}
			}
			else if(sum == N){
				int length = 0;
				//System.out.print( N +  " :" );
				for(int iter = start; iter <= end; iter++){
					length++;
					//System.out.print( " " + primes.get(iter));
				}
				//System.out.println();
				if(length > maxLength){
					maxPrime = N;
					maxLength = length;
				}
				return;
			}
			else{
				sum -= primes.get(start);
				start++;
			}
		}
		
	}
	
	
	/*Forget about it*/
	static void findConsecutivePrimesReversed(int N){

		ArrayList<Integer> terms = new ArrayList<Integer>();
		//System.out.println("\nGoing in for : " + N);
		int start = primes.indexOf(N)-1;
		int end = start + 1;
		int i = 0;
		int sum = 0;
		while(true){
			if(sum < N){
				end--;
				if(end >= 0){
					i = primes.get(end);
					sum += i;
				}
				else{
					break;
				}
			}
			else if(sum == N){
				int length = 0;
				System.out.print(  N + " :");
				for(int iter = start; iter >= end; iter--){
					System.out.print( " " + primes.get(iter));
					terms.add(primes.get(iter));
					if(termsList.get(iter).size() > 0){
						length += termsList.get(iter).size();
					}
					else{
						length++;
					}
				}
				System.out.println();
				termsList.add(terms);
				if(length > maxLength){
					maxPrime = N;
					maxLength = length;
				}
				
				return;
			}
			else{
				/*System.out.println("Sum : " + sum + " is greater than " + N);
				System.out.println("Removing number : " + primes.get(start));*/
				sum -= primes.get(start);
				start--;
				/*
				System.out.println("and starting from : " + primes.get(start));
				System.out.println("Sum : " + sum);*/
			}
		}
		termsList.add(terms);
	}
}
