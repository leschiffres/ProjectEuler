import java.util.ArrayList;
import java.util.StringTokenizer;

/*Exactly same problem as problem 18*/
public class Problem67 {

	public static void main(String[] args){
		
		ArrayList<String> list = FileManager.load("./Data/problem0067.txt");

		int[] a = new int[arrayLength(list.size())];
		int[] row = new int[arrayLength(list.size())];
		int n = 0;
		for(int i = 0; i < list.size(); i++){
			String s = list.get(i);
			StringTokenizer st = new StringTokenizer(s);
			String token = "";
			while(st.hasMoreTokens()){
				token = st.nextToken();
				n++;
				a[n] = Integer.parseInt(token);
				row[n] = i + 1;
			}
		}
		
		int[] best = new int [arrayLength(list.size())];
		
		for(int j = best.length - 1 ; j >= 1; j--){
			best[j] = a[j] + max(best, j + row[j], j + row[j] +1);
		}
		
		System.out.println("Best : " + best[1]);
		
	}
	
	static int max( int[] a, int i, int j){
		if(i < a.length){
			if(j < a.length){
				if(a[i] > a[j] ){
					return a[i];
				}
				else{
					return a[j];
				}
			}
			return j;
		}
		else{
			if(j < a.length){
				return a[j];
			}
			else{
				return 0;
			}
		}
	}
	static int arrayLength(int size){
		int length = 0;
		for(int i = 1; i <= size; i++){
			length += i ;
		}
		length++;
		return length;
	}
}
