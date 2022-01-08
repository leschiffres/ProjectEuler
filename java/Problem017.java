import java.util.HashMap;
import java.util.Map;


public class Problem17 {
	
	static Map<Integer, String> digits = new HashMap<Integer, String>();
	public static void main (String[] args){
		loadDigits();
		int sum = "onethousand".length();
		for(int i = 1; i < 1000; i++){
			sum+=getLetters(i);
		}
		
		System.out.println("Total Letters : " + sum);
	}
	
	static int getLetters(int N){
		System.out.println(N);
		int hundreds = N/100;
		N = N%100;
		int decades = N/10;
		int units = N%10;

		String s = "";
		int totaldigits = 0;
		if(hundreds > 0){
			totaldigits += digits.get(hundreds).length() + "hundred".length();
			s += digits.get(hundreds) + "hundred";

			if(!(N%100 == 0)){
				totaldigits += 3;
				s+="and";
			}
		}
		if(decades == 1){
			totaldigits += digits.get(N).length();
			s += digits.get(N);
		}
		else{
			totaldigits += digits.get(decades*10).length();
			s += digits.get(decades*10);
			totaldigits += digits.get(units).length();
			s += digits.get(units);
			
		}
		System.out.println(s + " : " + s.length());
		System.out.println("Calculated number : " + totaldigits);
		return totaldigits;
	}
	static void loadDigits(){
		
		digits.put(0, "");
		digits.put(1,"one" );
		digits.put(2, "two");
		digits.put(3, "three");
		digits.put(4, "four");
		digits.put(5, "five");
		digits.put(6, "six");
		digits.put(7, "seven");
		digits.put(8, "eight");

		digits.put(9, "nine");
		digits.put(10, "ten");
		digits.put(11, "eleven");
		digits.put(12, "twelve" );
		digits.put(13, "thirteen" );
		digits.put(14, "fourteen");
		digits.put(15, "fifteen");
		digits.put(16, "sixteen");
		digits.put(17, "seventeen");
		digits.put(18, "eighteen");
		digits.put(19, "nineteen");

		digits.put(20, "twenty");

		digits.put(30, "thirty");
		digits.put(40, "forty");
		digits.put(50, "fifty");
		digits.put(60, "sixty");
		digits.put(70, "seventy");
		digits.put(80, "eighty");
		digits.put(90, "ninety");
		
	}
}

