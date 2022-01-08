import java.math.BigInteger;


public class Problem100 {
	final static BigInteger EIGHT = new BigInteger("8");
	final static BigInteger FOUR = new BigInteger("4");
	final static BigInteger THREE = new BigInteger("3");
	
	final static BigInteger TWO = new BigInteger("2");
	final static BigInteger SIXTEEN = new BigInteger("16");
	final static BigInteger THIRTYTWO = new BigInteger("32");
	final static BigInteger SIXTYFOUR = new BigInteger("64");
	public static void main(String[] args){
		BigInteger threshold = new BigInteger("1");
		for(int i = 0; i < 12; i++){
			threshold = threshold.multiply(BigInteger.TEN);
		}
		
		BigInteger x = new BigInteger("15");
		BigInteger n = new BigInteger("21");
		
		
		//System.out.println(xtemp.toString());
		//System.out.println(ytemp.toString());
		
		while(n.compareTo(threshold) < 0){
			BigInteger xtemp = x.multiply(THREE).add(TWO.multiply(n)).subtract(TWO);
			BigInteger ntemp = x.multiply(FOUR).add(THREE.multiply(n)).subtract(THREE);
			
			x = xtemp;
			n = ntemp;
		}
		System.out.println("n : " + n.toString());
		System.out.println("blue disks : " + x.toString());
		
		/* First exhaustive way. We increase n by 1 in each iteration until we find the number that
		 * makes 4 + 8n(n-1) a perfect square 
		while(true){
			BigInteger delta = diakrinousa1(n);
			if(isPerfectSquare(delta)){
				System.out.println("Found!");
				System.out.println("Number of total discs : " + n.toString());
				System.out.println("Blue Discs : " + solution(sqrt(delta)));
				System.out.println("Diakrinousa : " + delta.toString());
				break;
			}
			else{
				n = n.add(BigInteger.ONE);
			}
		}
		*/
		
		/*Second method where we try to find the Delta such that the equation 8n^2 - 8n + 4 - Delta = 0
		 * has as a solution n a positive real number.*/
		/*BigInteger root = sqrt(diakrinousaX(n));
		
		System.out.println("Started for n : " + n);
		System.out.println("and the square root of " + diakrinousaX(n) + " is : " + root);
		*/
		/*Now root variable contains the lower possible root of DeltaX such that N > 10^12*/
		/*while(true){
			BigInteger deltaN = diakrinousaN(root.multiply(root));
			
			//if deltaN is a perfect square, this means that n is a positive integer.
			if(isPerfectSquare(deltaN)){
				n = solN(deltaN);
				BigInteger x = solution(root);
				System.out.println("Finally! Blue Discs : " + x);
				System.out.println("and total discs n : " + n);
				break;
			}
			else{
				root = root.add(BigInteger.ONE);
			}
		}*/
		
	}
	// returns (8 + delta)/16 solution to the equation 8n^2 - 8n + 4 - Delta = 0
	static BigInteger solN(BigInteger delta){
		return EIGHT.add(delta).divide(SIXTEEN);
	}
	
	static boolean isPerfectSquare(BigInteger n){
		BigInteger root = sqrt(n);
		if(root.multiply(root).equals(n)){
			return true;
		}
		else{
			return false;
		}
	}
	static BigInteger sqrt(BigInteger n)
	{
	    if (n.signum() >= 0)
	    {
	        final int bitLength = n.bitLength();
	        BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

	        while (!isSqrt(n, root))
	        {
	            root = root.add(n.divide(root)).divide(TWO);
	        }
	        return root;
	    }
	    else
	    {
	        throw new ArithmeticException("square root of negative number");
	    }
	}


	static boolean isSqrt(BigInteger n, BigInteger root)
	{
	    final BigInteger lowerBound = root.pow(2);
	    final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
	    return lowerBound.compareTo(n) <= 0
	        && n.compareTo(upperBound) < 0;
	}
	
	//Computes diakrinousa Delta =  4 + 8 * n *(n-1) which corresponds to the equation 2x^2-2x-n(n-1) = 0
	static  BigInteger diakrinousaX(BigInteger n){
		return EIGHT.multiply(n).multiply(n.subtract(BigInteger.ONE)).add(FOUR);
		
	}
	//Computes diakrinousa Delta' = 64 + 32(Delta-4) which corresponds to the equation 8n^2 - 8n + 4 - Delta = 0
	static  BigInteger diakrinousaN(BigInteger Delta){
		return THIRTYTWO.multiply(Delta.subtract(FOUR)).add(SIXTYFOUR);
		
	}
	static BigInteger solution(BigInteger delta){
		//Computes (2 + delta)/4;
		return delta.add(TWO).divide(FOUR);
	}
}
