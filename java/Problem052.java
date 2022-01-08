import java.util.HashSet;

public class Problem52 {

	static HashSet<Integer> numbers = new HashSet<Integer>();

	public static void main(String[] args) {

		int i;
		boolean flag = false;
		for(int length = 2; length < 10 && !flag; length++ ){
			i = tenpow(length-1);
			System.out.println(i);
			double bound = (double) tenpow(String.valueOf(i).length()) / 6;
			while(i < bound){
				numbers.clear();
				addNumbers(i);
				// Adding the numbers in the set
				boolean sameDigits = true;
				for(int j = 2; j < 7; j++){
					int initSize = numbers.size();
					addNumbers(i*j);
					if(initSize < numbers.size()){
						sameDigits = false;
						break;
					}
				}
				
				
				if(sameDigits){
					System.out.println("Vrethike o arithmos kwstaki " + i);
					flag = true;
					break;
				}
				i++;
			}
		}
			
	}
	
	static int tenpow(int a){
		int n = 1;
		for(int i = 0; i < a; i++){
			n *= 10;
		}
		return n;
	}
	
	static void addNumbers(int N) {
		String s = String.valueOf(N);
		for(int i = 0; i < s.length(); i++){
			numbers.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		}
	}

}
