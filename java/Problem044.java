import java.util.ArrayList;
public class Problem44 {
	static ArrayList<Integer> a = new ArrayList<Integer>();
	public static void main(String[] args){
		System.out.println("Program Started");
		long start = System.currentTimeMillis();
		int N = 10000;
		for(int i = 1; i <= N;i++){
			int pn = (3*i-1)*i/2;
			a.add(pn);
			//System.out.println(i+" : " + pn);
		}
		findSolution();
		System.out.println((double)(System.currentTimeMillis() - start)/1000 + " Seconds");
		
	}
	static void findSolution(){
		//both codes work
		/*for(int i = 2; i < a.size(); i++){
			if(i % 100 == 0){
				System.out.println(i);
			}
			for(int j = i-1; j>=0; j--){

				//System.out.println(a.get(i) + " " + a.get(j));
				int difference = a.get(i)-a.get(j);
				int sum = a.get(i) + a.get(j);
				if(a.contains(difference) && a.contains(sum)){
					System.out.println("Pj : " + a.get(i) + " Pk" + a.get(j));
					System.out.println("Difference : " + difference);
					System.out.println("Sum : " + sum);
					return;
				}
			}
		}*/
		for(int i = 2; i < a.size(); i++){
			for(int j = 0; j< i; j++){

				//System.out.println(a.get(i) + " " + a.get(j));
				int difference = a.get(i)-a.get(j);
				int sum = a.get(i) + a.get(j);
				if(sum > a.get(a.size()-1)){
					break;
				}
				if(a.contains(difference) && a.contains(sum)){
					System.out.println("Pj : " + a.get(i) + " Pk : " + a.get(j));
					System.out.println("Difference : " + difference);
					System.out.println("Sum : " + sum);
					return;
				}
			}
		}
	}
}
