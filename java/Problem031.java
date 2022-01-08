import java.util.ArrayList;


/*Suppose you want to get 2 euros with the coins 2E, 1E, 0.50E, 0.20E, 0.10E, 0.05E, 0.02E, 0.01E.
 * Find every possible way to achieve that*/

public class Problem31 {
	static ArrayList<String> write = new ArrayList<String>();

	static int[] coins = { 200, 100, 50, 20, 10, 5, 2, 1};
	static int perms = 0;
	public static void main(String[] args){
		int[] howmany = new int[coins.length];
		coins(200,0,howmany);
		System.out.println("Total permutations : " + perms);

		FileManager.write(write, "p31results.txt");
	}
	
	static void coins(int total, int i, int[] a){
		
		if(total==0){
			printSolution(a);
			perms++;
			return;
		}
		/*If we have gone to 1 cent coins and the total money has not been covered*/
		if(i >= coins.length){
			return;
		}
		int possibilities = total/coins[i];
		for(int l = possibilities; l >= 0; l--){
			int next = total - l*coins[i];
			
			/*int[] howmany = new int[coins.length];
			for(int iter = 0; iter < howmany.length;iter++){
				howmany[iter] = a[iter];
			}*/
			int[] howmany = a.clone();
			howmany[i] = l;
			
			int nexti = i+1;
			coins(next, nexti, howmany);
		}	
	}
	
	static void printSolution(int[] howmany){
		String s = "--------------------------------------------\n";
		s += "New Solution\n";
		for(int i = 0; i < coins.length; i++){
			s += ("# " + coins[i]  + " : " + howmany[i] + "\n");
		}
		s += "--------------------------------------------\n";
				
		write.add(s);
		
		/*
		System.out.println("--------------------------------------------");
		System.out.println("New Solution");
		for(int i = 0; i < coins.length; i++){
			System.out.println("# " + coins[i]  + " : " + howmany[i]);
		}
		
		System.out.println("--------------------------------------------");*/
	}
	
}
