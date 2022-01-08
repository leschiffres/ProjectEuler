import java.math.BigInteger;


public class Problem65 {

	public static void main(String[] args){
		int term = 10;
		
		int N = 100;
		
		/*Load the sequence matrix*/
		int[] seq = new int[N];
		seq[0] = 2;
		int k = 1;
		for(int i = 1; i < N; i++){
			if(i%3 == 2){
				seq[i] = 2*k;
				k++;
			}
			else{
				seq[i] = 1;
			}
		}
		

		BigInteger left;
		/*The  right most fraction in the whole sequence is 1/seq[lastIndex]*/
		BigInteger nominator = new BigInteger("1");
		BigInteger denominator = new BigInteger(String.valueOf(seq[seq.length-1]));
		for(int i = seq.length-2; i >= 0; i--){
			left = new BigInteger(String.valueOf(seq[i]));
			BigInteger newDenominator = new BigInteger(nominator.add(denominator.multiply(left)).toString());
			
			if(i == 0){
				nominator = newDenominator;
			}
			else{

				nominator = denominator;
				denominator = newDenominator;
			}
			
		}
		

		System.out.println(nominator + "/" + denominator);
		
		System.out.println("Sum of nominators digits : " + sum(nominator.toString()));
	}
	static int sum(String s){
		int total = 0;
		for(int i = 0; i < s.length(); i++){
			total += Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		return total;
	}
}
