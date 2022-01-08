/*Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.*/
public class Problem36 {

	public static void main(String[] args){
		int sum = 0;
		for(int i = 1; i < 1000000; i++ ){
			if(isPalindrome(String.valueOf(i))&& isPalindrome(binaryForm(i))){
				sum += i;
				//System.out.println(i);
			}
		}
		System.out.println("Sum of all palindrome numbers both in base 2 and 10 are : " + sum);
	}
	static String binaryForm(int n){
		String s = "";
		/*The highest power of two one number less than one million can be divided is 2 ^ 19 = 524.288*/
		int div = 524288;
		int i = n;
		while(div > 0){
			s += String.valueOf(i/div);
			i = i%div;
			div /= 2;
		}
		
		s = removeFirstZeros(s);
		return s;
	}
	static boolean isPalindrome(String t){
		boolean pal = true;
		for(int i = 0; i < t.length()/2+1;i++){
			if(t.charAt(i) != t.charAt(t.length()-1-i)){
				pal = false;
			}
		}
		return pal;
	}
	static String removeFirstZeros(String s){
		int i = 0;
		for(;;){
			if( String.valueOf(s.charAt(i)).equals("1")){
				break;
			}
			else{
				i++;
			}
		}
		return s.substring(i, s.length());
	}
}
