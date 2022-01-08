
public class Problem9 {

	public static void main(String[] args){
		
		boolean found = false;
		int iterations = 0;
		/*When searching for pythagorean triplets, i.e. a^2 = b^2 + c^2 such that a + b + c = 1000
		 * we start by considering in decreasing order every possible 
		 * triplet. To accelarate the whole process we realize that if a = 600 there is no point having
		 * b greater than 399, since c would have to be 0 after that.
		 * 
		 * (iterations this far = 164650)
		 * 
		 * In addition b does not have to be lower than 1000-a/2 since after wards we are doing double calculations.
		 * For example if a = 600 then if b < 200 is just like doing the same computations twice.
		 * for example b = 150 then c = 250 (we searched this case when b = 250 and c = 150)
		 * 
		 * (iterations = 82743 )
		 * */
		for(int a = 997; a > 0 && !found; a--){
			for(int b = (1000 - a)/2 ; b < 1000 - a && !found; b++){
				iterations++;
				int c = 1000 - a - b;
				if(a*a == b*b + c*c){
					found = true;
					System.out.println("found");
					System.out.println("a : " + a);
					System.out.println("b : " + b);
					System.out.println("c : " + c);
					System.out.println("Product : " + (a* b * c));
				}
			}
		}
		System.out.println("Total number of iterations : " + iterations);
		
	}
	
}
