
public class Problem26 {
	public static void main(String[] args){
		int N = 20;
		double dec = 1, smth;
		for(int i = 1; i <= N; i++){
			smth = i;
			dec = (double) 1 / smth;
			getRecursiveCycle(dec);
			System.out.println("1/"+ i + " : " + dec);
		}
		
	}
	static String getRecursiveCycle(double x){
		String s = String.valueOf(x);
		s = s.substring(2, s.length());
		System.out.println(s);
		int start = s.length()-1;
		int end = start -1;
		
		//int sequenceLength = ;
		while(true){
			end = start -1;
			if(String.valueOf(s.charAt(start)).equals(String.valueOf(s.charAt(end)))){
				
			}
			else{
				end--;
				if(end < 0){
					break;
				}
			}
		}
		//int start
		return s;
	}
}