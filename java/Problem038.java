import java.util.ArrayList;

public class Problem38 {
	
	public static void main(String[] args){

		ArrayList<Integer> pandigitals = new ArrayList<Integer>(); 
		for(int i = 1; i < 100000; i++){
			String s = "";
			int j = 1;
			while(s.length()<9){
				s += String.valueOf(i*j);
				j++;
			}
			if(isPandigital(s)){
				pandigitals.add(Integer.parseInt(s));
			}
		}
		
		int max = 0;
		for(Integer i : pandigitals){
			if(i > max){
				max = i;
			}
		}
		
		System.out.println("Max Pandigital : " + max);
	}
	
	static boolean isPandigital(String s){
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			list.add(String.valueOf(s.charAt(i)));
		}
		for(int i = 1; i < 10; i++){
			if(list.contains(String.valueOf(i))){
				list.remove(String.valueOf(i));
			}
			else{
				return false;
			}
		}
		if(!list.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
}
