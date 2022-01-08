import java.util.ArrayList;
/*It was proposed by Christian Goldbach that every odd composite number 
can be written as the sum of a prime and twice a square.
 
 9 = 7 + 2*1
 25 = 7 + 2*9;
 
 Find smallest odd composite that cannot be written this way.
*/
public class Problem46 {

	public static void main(String[] args){
		ArrayList<Integer> list = MyFunctions.EratosthenisSieve(1000000);
		int N = 15;
		for(;;){
			/*We search for composite numbers, not prime.*/
			if(!list.contains(N)){
				boolean isTheOne = true;
				for(int i = 1; i <= Math.sqrt(N);i++){
					int prime = N - 2*i*i;
					if( list.contains(prime)){
						isTheOne = false;
						//System.out.println(N + " = " + prime + " + 2 * " + (i*i));
						break;
					}
				}
				if(isTheOne){
					System.out.println(N + " is the one!");
					break;
				}
			}
			N += 2;
		}
	}
}
