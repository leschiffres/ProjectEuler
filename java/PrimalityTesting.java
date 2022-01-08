import java.math.BigInteger;
import java.util.Random;
public class PrimalityTesting {
	public static void main(String[] args){
		
		int N = 7; //enter prime number here
		Random r = new Random();
		
		int iterations = 10, i = 0, a = 0;
		boolean flag = true;
		while(flag && i < iterations){
			a = r.nextInt(N-2)+2;
			if(FermatTest(a, N)){
				System.out.println("a = " + a + " N = " + N + " is prime");
			}
			else{
				System.out.println("a = " + a + " N = " + N + " is not prime");
				flag = false;
			}
			i++;
		}
	}
	
	public static boolean FermatTest(int a,int N){
		boolean result;
		if(power(a,N-1).mod(BigInteger.valueOf(N)).equals(BigInteger.valueOf(1))){
			result = true;
		}
		
		else{
			result = false;
		}
		System.out.println(a + "^"+ (N-1) + " = " + power(a,N-1));
		return result;
	}
	public static BigInteger power(int a, int b){
		BigInteger result = BigInteger.valueOf(a);
		for(int i = 1; i < b; i++){
			result = result.multiply(BigInteger.valueOf(a));
		}
		return result;
	}
}
