import java.util.ArrayList;


public class Problem41 {

	public static void main(String[] args){
		ArrayList<Integer> primes = MyFunctions.EratosthenisSieve(10000000);
		for(int i = primes.size() - 1; i >= 0 ; i--){
			if(isPandigital(String.valueOf(primes.get(i)))){
				System.out.println("Largest pandigital prime : " + primes.get(i));
				break;
			}
		}
	}
	static boolean isPandigital(String s){
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			list.add(String.valueOf(s.charAt(i)));
		}
		for(int i = 1; i <= s.length(); i++){
			if(list.contains(String.valueOf(i))){
				list.remove(String.valueOf(i));
			}
			else{
				return false;
			}
		}
		if(!list.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
}
