import java.util.ArrayList;
import java.util.LinkedList;
public class MyFunctions {
	/*Calculates all the prime numbers*/
	public static ArrayList<Integer> EratosthenisSieve(int N){
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
		
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		
		for(int i = 2; i < N; i++){
			if(a[i]){
				mylist.add(i);
			}
		}
		return mylist;
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
				if(!perms.contains(Integer.parseInt(newStr)))
					perms.add(Integer.parseInt(newStr));
			}
			else{
				permutations(newList, newStr);
			}
		}
	}
	
	/*Creates a list with the digits of an integer*/
	public static LinkedList<Integer> getDigits(int N){
		//This method is way faster and better
		LinkedList<Integer> digits = new LinkedList<Integer>();
		String s = String.valueOf(N);
		for(int i = 0; i < s.length(); i++){
			digits.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		}
		
		return digits;
	}
	/**LinkedList<String> list = new LinkedList<String>();
	String s = String.valueOf(N);
	int dec = 1;
	for(int i = 1 ; i < s.length();i++){
		dec *= 10;
	}
	
	while(dec > 0){
		list.add(String.valueOf(N / dec));
		N = N % dec;
		dec = dec/10;
	}*/
	static String reversed(String N){
		String s = String.valueOf(N);
		String rever = "";
		for(int i = s.length()-1; i >= 0;i--){
			rever += String.valueOf(s.charAt(i));
		}
		return rever;
	}
	static boolean isPalindrome(String t){
		String s = String.valueOf(reversed(t));
		if(t.equals(s)){
			return true;
		}
		else{
			return false;
		}
	}
	static boolean isPandigital(String s){
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			list.add(String.valueOf(s.charAt(i)));
		}
		for(int i = 1; i < 10; i++){
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
