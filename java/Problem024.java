import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
/*We want to find the 1000000 alphabetically ordered permutation of the digits 0123456789.
 * If we count every permutation from 1 --> 1000000 the computation will need 2 hours approx
 * by applying a brute force recursive algorithm of finding every possible permutation until
 * the 1000000th.
 * 
 * However, we know that the possible number of permutations starting with 0 is 9! = 362880.
 * Thus the permutations from 0 - 362880 will start with 0.
 * The permutations from 3622881 - 2*362880 will start with 1 and so on. 
 * 
 * Thus our number will start with 2 since 1,000,000 is contained in the range between
 * 725760 - 1088640.
 * 
 * Then we search the 1000000 - 725760 = 274240th alphabetically ordered permutation
 * that starts with 2. 
 * 
 * Similarily the possible number of permutations starting with 20 is 8! = 40320.
 * We compute again the range for every possible number and we can see that 274240
 * is in the range between 241921 - 282240 which corresponds to the 6th digit in the
 * sequence (remember 2 is not a possible option) thus 7.
 * 
 *  Therefore the number starts with 27.
 *  
 *  Then procedure goes on similarily.  */
public class Problem24 {
	public static void main(String[] args){
		
		thirdWay(1000000);
	}
	/*all possible permutations of a string */
	static LinkedList<Integer> perms = new LinkedList<Integer>();
	public static void permutations(LinkedList<String> list, String str){
		
		for(int i = 0; i < list.size(); i++){

			LinkedList<String> newList = new LinkedList<String>();
			for(String s : list){
				newList.add(s);
			}
			
			String first = newList.remove(i);
			String newStr = str + first;
			if(newList.isEmpty()){
				if(!perms.contains(Integer.parseInt(newStr))){
					perms.add(Integer.parseInt(newStr));
					if(perms.size() % 10000 == 0){
						System.out.println(perms.size() + " : " + newStr);
					}
				}
			}
			else{
				permutations(newList, newStr);
			}
		}
	}
	/*The second way starts by the number 0123456789 and considers every possible
	 * number until we reach 1.000.000 iteration. Similar to the above recursion method*/
	static void secondWay(){
		int total = 0;
		BigInteger N = new BigInteger("123456789");
		while(total <= 1000000){
			N = N.add(new BigInteger("1"));
			if(isPermutation(N.toString())){
				total++;
				System.out.println(total + " : " + N.toString());
			}
		}
	}
	
	static boolean isPermutation(String s){
		boolean flag = true;
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			if(!list.contains(String.valueOf(s.charAt(i)))){

				list.add(String.valueOf(s.charAt(i)));
			}
			else{
				flag = false;
				break;
			}
		}
		if(list.contains("1") && list.contains("2") && list.contains("3")&& list.contains("4")
				&& list.contains("5")&& list.contains("6")&& list.contains("7")&& list.contains("8")
				&& list.contains("9")){
			
		}
		else{
			flag = false;
		}
		return flag;
	}
	
	static void thirdWay(int permutationIndex){
		String s = "";
		int digit = 1;
		int factorialNumber = 9;
		int f ;
		LinkedList<String> mylist = new LinkedList<String>();
		mylist.add("0");
		mylist.add("1");
		mylist.add("2");
		mylist.add("3");
		mylist.add("4");
		mylist.add("5");
		mylist.add("6");
		mylist.add("7");
		mylist.add("8");
		mylist.add("9");
		int resting = permutationIndex;
		String newDigit = "";
		while(digit <= 10){
			f = factorial(factorialNumber);
			int i = 0;
			while(i < mylist.size()){
				if((i+1)*f < resting){
					i++;
				}
				else if((i+1)*f ==  resting){
					resting  = resting / (i+1);
					break;
				}
				else{
					resting  = resting % f;
					break;
				}
			}
			
			newDigit = mylist.remove(i);
			System.out.println("The " + digit + "th digit is " + newDigit);
			s += newDigit;
			
			System.out.println("Now we search for the " +  resting + "th alphabetically ordered permutation starting with "+ s);
			factorialNumber--;
			digit++;
		}
		System.out.println("\nThe millionth permutation is " + s);
	}
	
	static int factorial(int N){
		int res = 1;
		for(int i = 2; i <= N; i++){
			res *= i;
		}
		return res;
	}
	
}
