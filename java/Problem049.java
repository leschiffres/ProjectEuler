
import java.util.ArrayList;
import java.util.LinkedList;
public class Problem49 {
	/*This list contains all the primes up until 10000*/
	static ArrayList<Integer> primes ;
	
	/*Numbers that have already been checked (for example when we check 1234 we also
	 * check for 2134, so there is no point rechecking all its possible permutations)*/
	static ArrayList<Integer> numbersChecked = new ArrayList<Integer>();
	
	/*For every integer we keep a list of all its candidate permutations that are 
	 * primes and > 1000*/
	static ArrayList<Integer> candidates;
	public static void main(String[] args){
		
		primes = MyFunctions.EratosthenisSieve(9999);
		
		for(int i = 1000; i < 10000 ; i++){
			if(!numbersChecked.contains(i) && primes.contains(i)){
				LinkedList<String> list = getDigits(i);
				perms = new LinkedList<Integer>();
				permutations(list, "");
				int totalPrimes = howmanyPrimes();
				if(totalPrimes >= 3){
					//System.out.println(i + " : " + totalPrimes);
					checkProperty();
				}
			}
		}
		
		
		
	}
	static LinkedList<String> getDigits(int i){
		LinkedList<String> list = new LinkedList<String>();
		
		String s = String.valueOf(i);
		list.add(String.valueOf(s.charAt(0)));
		list.add(String.valueOf(s.charAt(1)));
		list.add(String.valueOf(s.charAt(2)));
		list.add(String.valueOf(s.charAt(3)));
		
		return list;
	}
	static LinkedList<Integer> perms;
	public static void permutations(LinkedList<String> list, String str){
		
		for(int i = 0; i < list.size(); i++){

			LinkedList<String> newList = new LinkedList<String>();
			for(String s : list){
				newList.add(s);
			}
			
			String first = newList.remove(i);
			String newStr = str + first;
			if(newList.isEmpty()){
				if(!perms.contains(Integer.parseInt(newStr)))
					perms.add(Integer.parseInt(newStr));
			}
			else{
				permutations(newList, newStr);
			}
		}
	}
	/*Returns the of primes in a possible permutation*/
	public static int howmanyPrimes(){
		candidates = new ArrayList<Integer>();
		int total = 0;
		for(Integer i : perms){
			
			if (i > 1000 && primes.contains(i)){
				numbersChecked.add(i);
				candidates.add(i);
				total++;
			}
		}
		return total;
	}
	
	/*In order to check the desire property we take the first  element in the list
	 * for example 1487 and we check it with the following one suppose 4817. Then 
	 * we measure their distance 4817 - 1487 = 3330 and if
	 * 4817 + 3330 = 8147 is in the list, then we have our three numbers. */
	public static void checkProperty(){
		for(int i = 0; i < candidates.size()-2; i++){
			for(int j = i+1; j < candidates.size()-1; j++){
				int distance = candidates.get(j) - candidates.get(i);
				if(candidates.contains(candidates.get(j) + distance)){
					System.out.println(candidates.get(i) + " " + candidates.get(j) + " " + (candidates.get(j) + distance ) );
					System.out.println("with distance : " + distance);
				}
			}
		}
		
	}
}
