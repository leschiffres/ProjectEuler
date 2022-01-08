import java.math.BigInteger;
/*In this problem we want to find the first number with 1000 digits in the fibonacci sequence*/
public class Problem25 {
	
	public static void main(String[] args){
		BigInteger first = new BigInteger("1");
		BigInteger second = new BigInteger("1");
		int i = 2;
		BigInteger newNumber = new BigInteger("2");
		while(newNumber.toString().length() < 1000){
			newNumber = first.add(second);
			i++;
			first = second;
			second = newNumber;
		}
		System.out.println("The index of the first 1000 digit number is : " + i);
	}
	
}
