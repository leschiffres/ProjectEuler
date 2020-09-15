import java.util.ArrayList;


public class Problem4 {
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int a = 999,  c = 0;
		while(a>500){
			for(int b = 999; b > 100; b--){
				c = a*b;
				if(isPalindromeString(String.valueOf(c))){
					list.add(c);
					break;
				}
				
			}
			a--;
		}
		
		int max = findmax(list);
		System.out.println("The largest palindrome is " + max);
		
	}
	
	private static int findmax(ArrayList<Integer> list) {
		int max = 0;
		for(Integer i : list){
			if (i > max) max = i;
		}
		return max;
	}

	public static boolean isPalindromeString(String t){
		boolean pal = true;
		for(int i = 0; i < t.length()/2+1;i++){
			if(t.charAt(i) != t.charAt(t.length()-1-i)){
				pal = false;
			}
		}
		return pal;
	}
	public static boolean isPalindromeStack(String t){
		String stack = "";
		for(int i = t.length()-1; i >= 0; i--){
			stack += t.charAt(i);
		}
		System.out.println("Init : " + t);
		System.out.println("Stack : " + stack);
		if(t.equals(stack)){
			return true;
		}
		else{
			return false;
		}
	}
}
