import java.math.BigInteger;
public class Problem6 {
	/*
	 * In order to solve this problem, one might just use int variables as indicated
	 * in the implemented code following as comment. However we prefer the BigInteger
	 * class for the declaration of values
	 * so that the problem can be solved for an arbitrary value of N. */
	
	public static void main(String[] args){
		int N = 100;
		BigInteger sumOfSquares = BigInteger.valueOf(0);
		BigInteger squareOfSum = BigInteger.valueOf(0);
		for(int i = 1; i <=N; i++){
			sumOfSquares = sumOfSquares.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(i)));
			squareOfSum = squareOfSum.add(BigInteger.valueOf(i));
		}
		squareOfSum = squareOfSum.multiply(squareOfSum);
		System.out.println("(1+2+ . . . + 100)^2 = " + squareOfSum);
		System.out.println("1^2 + 2^2 + . . . 100^2) = " + sumOfSquares);
		System.out.println(squareOfSum.subtract(sumOfSquares));
	}
	/*
	public static void main(String[] args) {
		int sumOfSquares = 0; // 1^2 + 2^2 + ... 100^2
		int squareOfSum = 0; // (1 + 2 + ... + 100)^2
		for(int i = 1; i <= 100; i++){
				sumOfSquares += i*i;
				squareOfSum += i;
		}
		squareOfSum = squareOfSum * squareOfSum;
		int result = squareOfSum - sumOfSquares;
		System.out.println("Result : " + result );
	}*/
}
