
import java.math.BigInteger;;
public class Problem55 {

	public static void main(String[] args){
		int total = 0;
		for(int i = 1; i < 10000;i++){
			if(isLychrel(i)){
				total++;
				//System.out.println(i + " is Lychrel number.");
			}
		}
		System.out.println("Total Lychrel numbers until 10000 : " + total);
	}
	
	static boolean isLychrel(int N){
		boolean flag = true;
		BigInteger a = new BigInteger(String.valueOf(N));
		for(int i = 0; i < 50;i++){

			BigInteger b = new BigInteger(reversed(String.valueOf(a)));
			BigInteger sum = a.add(b);
			if(isPalindrome(String.valueOf(sum))){
				return false;
			}
			else{
				a = sum;
			}
		}
		
		return flag;
	}
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
}
