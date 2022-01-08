import java.util.ArrayList;

/*We are trying to find truncatable primes i.e. 3797 is prime itself but also
 * 797, 97, 7 are prime (deleting numbers left to right). Also 379, 37, 7 are primes
 * (right to left deletion). There are only 11 numbers having this property.
 * Find their sum*/
public class Problem37 {
	static ArrayList<Integer> list;
	public static void main(String[] args){
		list = MyFunctions.EratosthenisSieve(1000000);
		System.out.println("List Size : " + list.size());
		int sum = 0;
		for(Integer N : list){
			if(N >= 10){
				if(isTruncatablePrime(N)){
					System.out.println(N + " is prime");
					sum += N;
				}
			}
		}
		System.out.println("Total sum of truncatable primes : " + sum);
	}
	
	static boolean isTruncatablePrime(int n){
		boolean flag = true;
		int init = 10000000;
		// Left to right
		int i = n;
		while(flag && init > 1){
			//System.out.println(i);
			if(isPrime(i)){
				init /= 10;
			}
			else{
				flag = false;
				break;
			}
			i =  i % init;
		}
		init = 10;
		//right to left
		i = n;
		while(flag && i > 0){
			if(isPrime(i)){
			}
			else{
				flag = false;
				break;
			}
			i = i/init;
		}
		return flag;
	}
	
	static boolean isPrime(int n){
		return list.contains(n);
	}
}
