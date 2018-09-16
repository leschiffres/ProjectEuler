public class Problem3 {
	public static void main(String[] args){
		long N = 600851475143L;
		int a = 2;
		int gpd = 1;//greatest prime divisor of N
		while(N > 1){
			if(N%a == 0){
				N = N/a;
				if(a > gpd) {
					gpd = a;
				}
				while(N%a == 0){
					N = N/a;
				}
			}
			else{
				a = a + 1; 
			}
		}
		System.out.println("The greatest prime divisor of " + N + " is " + gpd +".");
	}
}
