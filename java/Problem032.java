import java.util.ArrayList;
public class Problem32 {

	public static void main(String[] args){
		System.out.println(isPandigital("213465798"));
		ArrayList<Integer> productList = new ArrayList<Integer>(); 
		for(int i = 1; i < 10000; i++){
			for(int j = 1; j <10000; j++){
				int product = i*j;
				String s = i  +"" +  j +  "" +   product;
				if(isPandigital(s)&& !productList.contains(product)){
					System.out.println(i + "*" + j + " = " + product);
					productList.add(product);
				}
			}
		}
		int sum = 0;
		for(Integer i : productList){
			sum += i;
		}
		System.out.println("Total sum of products : " + sum);
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
