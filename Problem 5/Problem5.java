
public class Problem5 {
	public static void main(String[] args){
		//initializing array
		int[] a = new int [21];
		for(int i = 0; i < a.length; i++){
			a[i] = i;	
		}
		
		//
		
		int b = 2;
		int product = 1;
		boolean div;
		while(!allOne(a)){
			div = false;
			for(int i = 2; i < a.length; i++ ){
				if(a[i]%b == 0){
					a[i] = a[i]/b;
					div = true;
				}
			}
			if(div){
				product = product * b;
			}
			else{
				b++;
			}
		}
		System.out.println(product);
	}
	static boolean allOne(int[] a){
		for(int i = 2; i < a.length; i++ ){
			if(a[i]!=1){
				return false;
			}
		}
		return true;
	}
}
