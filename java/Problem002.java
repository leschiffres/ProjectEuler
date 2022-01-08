
public class Problem2 {
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		int help;
		int evenSum = 0;
		while(b <= 4000000){
			if (b % 2 == 0){
				evenSum += b;
			}
			help = a;
			a = b;
			b = help+b;
			
		}
		System.out.println("The total sum of the even fibonacci numbers is " + evenSum);
	}
}
