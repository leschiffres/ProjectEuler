import java.util.LinkedList;


public class Problem30 {
	public static void main(String[] args){
		int sum = 0;
		for(int i = 2; i < 1000000; i++){
			if(isFifthPower(i)){
				sum += i;
			}
		}
		System.out.println("Their sum : " + sum);
		
	}
	static boolean isFifthPower(int N){
		int sum = 0;
		for(Integer i : getDigits(N)){
			sum+= pow(i,5);
		}
		if(sum == N){
			System.out.println(N  +" is  one");
			return true;
		}
		else{
			return false;
		}
	}
	public static LinkedList<Integer> getDigits(int N){
		//This method is way faster and better
		LinkedList<Integer> digits = new LinkedList<Integer>();
		String s = String.valueOf(N);
		for(int i = 0; i < s.length(); i++){
			digits.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		}
		
		return digits;
	}
	static int pow(int N, int a){
		int total = N;
		for(int i = 1; i < a; i++){
			total *= N;
		}
		return total;
	}
}
