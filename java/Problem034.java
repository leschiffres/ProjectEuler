import java.util.ArrayList;
public class Problem34 {
	public static void main(String[] args){

		System.out.println("Program Started");
		long start = System.currentTimeMillis();
		int sum = 0;
		for(int i = 3; i < 30000000;i++){
			if(isCurious(i)){
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println("Sum of all curious numbers : " + sum);
		System.out.println((double)(System.currentTimeMillis() - start)/1000 + " Seconds");
	}
	static boolean isCurious(int N){
		boolean flag = false;
		ArrayList<Integer> digits = getDigits(N);
		int sum = 0;
		for(int i = 0; i < digits.size();i++){
			sum += factorial(digits.get(i));
		}
		if(sum == N){
			flag = true;
		}
		return flag;
	}
	static ArrayList<Integer> getDigits(int N){
		ArrayList<Integer> digits = new ArrayList<Integer>();
		String s = String.valueOf(N);
		for(int i = 0; i < s.length(); i++){
			digits.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		}
		
		return digits;
	}
	static int factorial(int N){
		int total = 1;
		for(int i = 1; i <=N; i++){
			total *=i;
		}
		return total;
	}
}
