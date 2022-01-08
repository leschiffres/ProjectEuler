import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*The goal is to find the sum of really huge numbers. Every number has
 * 50 digits and we need to sum 100 of them.*/

/*My way to go is to add the aligned columns of those numbers. Add the first digits, then the
 * second ones and so forth. Then you can just see their sum*/

public class Problem13 {
	static ArrayList<String> numbers = new ArrayList<String>();
	static int digits = 50;
	public static void main(String[] args){
		System.out.println("Program");
		readTable();
		//produceRandomNumbers();
		System.out.println("list size : " + numbers.size());
		
		// the following matrix contains the sum for every digit
		int[] sums = new int[digits];
		for(int i = 0; i < sums.length; i++){
			for(String s: numbers){
				sums[i] += Integer.parseInt(s.charAt(i) + "");
				if(i == 48){
					//System.out.println(s.charAt(i));
				}
			}
			System.out.println("i : "  +  i  + "\tsum : " + sums[i]);
		}
		
		int koufontinas = 0;
		String[] result = new String[sums.length];
		for(int i = sums.length-1; i >= 0; i--){
			int sum = sums[i] + koufontinas;
			koufontinas = sum/10;
			//System.out.println(koufontinas);
			result[i] = String.valueOf(sum%10);
		}
		
		
		System.out.print(koufontinas);
		for(int i = 0 ; i < sums.length; i++){
			System.out.print(result[i]);
		}
		
	}
	
	
	public static void readTable(){
		File f = null;
		BufferedReader br = null;
		String str = "";
		try{
			f = new File("./data/problem0013.txt");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		}
		catch(IOException e){
			e.printStackTrace();
		}
        while (str != null ) {
        	
        	try {
                str = br.readLine();
                if(str!=null){
                	numbers.add(str);
                }
            }
            catch (IOException e) {
                System.err.println("Error reading line .");
            }
        }
	
	}
	
	public static void produceRandomNumbers(){
		
		int bound = 1;
		for(int i = 1; i < digits; i++){
			bound *= 10; 
		}
		int lele = 0;
		int added = 0;
		while(added < 10 ){
			double papares = Math.random()*bound*10;
			int number = (int) papares;
			if(number > bound){
				lele += number;
				System.out.println("Number : " + number);
				numbers.add(String.valueOf(number));
				added++;
			}
		}
		System.out.println("Sum : " + lele);
	}
}
