import java.math.BigInteger;
public class Problem16 {

	public static void main(String[] args){
		BigInteger a = new BigInteger(String.valueOf(1));
		
		for(int i = 1; i <=1000;i++){
			a = a.multiply(new BigInteger(String.valueOf(2)));
		}
		
		String s = a.toString();
		int res = 0;
		for(int i = 0; i < s.length();i++){
			res += Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		
		System.out.println("2 to the power of 1000 is equal to : " + a);
		System.out.println("The sum of this number's digits are : " + res);
	}
	
}
