import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem81 {
	
	static int M[][] = new int[80][80];
	static int A[][] = new int[80][80];
	public static void main(String[] args){
		load("./data/problem0081.txt");
		
		for(int i = 0; i < 80; i++){
			for(int j = 0; j < 80; j++){
				dynamicProgramming(i,j);
			}
		}
		System.out.println(A[79][79]);
	}
	
	static void dynamicProgramming(int i, int j){
		
		if(i > 0){
			if(j > 0){
				A[i][j] = min(A[i-1][j], A[i][j-1]) + M[i][j];
			}
			else{
				A[i][j] = A[i-1][j] + M[i][j];
			}
		}
		else{
			if(j > 0){
				A[i][j] = A[i][j-1] + M[i][j];
			}
			else{
				A[i][j] = M[i][j];
			}
		}
	}
	
	static int min(int a , int b){
		if(a < b){
			return a;
		}
		else{
			return b;
		}
	}
	static void load(String filename){
		BufferedReader br = null;
		File f = null;
		String line = "";
		
		try{
			f = new File(filename);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		}
        catch (FileNotFoundException e) {
            System.err.println("Error opening file for reading!");
        }
		int i = 0;
		while(line != null){
			try{
				line = br.readLine();
				//After the last line of the file, the variable "line" will have as value null
				if(line != null){
					int j = 0;
					StringTokenizer tzer = new StringTokenizer(line, ",");
					while(tzer.hasMoreElements()){
						M[i][j] = Integer.parseInt(tzer.nextToken());
						//System.out.println(tzer.nextToken());
						j++;
					}
					
				}
				i++;
			}

            catch (IOException e) {
                System.err.println("Error reading line .");
            }
		}
	}
	
}
