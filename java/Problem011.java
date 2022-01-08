import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem11 {
	private static int[][] array;
	public static void main(String[] args){
		
			readTable();
			int best = 0;
			String index = "";
			/*Horizontal Computation*/
			for(int i = 0 ; i < 20; i++){
				for(int j = 0; j < 17; j++){
					int product = array[i][j]*array[i][j+1]*array[i][j+2]*array[i][j+3];
					if(best < product){
						best = product;
						index = "(" + i + "," + j + ")";
					}
				}
			}
			
			System.out.println("Best product Horizontally : " + best);
			System.out.println(index);
			
			best = 0;
			/*Vertical Computation*/
			for(int j = 0 ; j < 20; j++){
				for(int i = 0; i < 17; i++){
					int product = array[i][j]*array[i+1][j]*array[i+2][j]*array[i+3][j];
					
					if(best < product){
						best = product;
						index = "(" + i + "," + j + ")";
					}
				}
			}
			
			System.out.println("Best product Vertically : " + best);
			System.out.println(index);
			
			/*Diagonal Computation NorthEast to SouthWest*/
			best = 0;
			for(int col = 0; col < 17; col++){
				int i = 0;
				int j = col;
				while(i <17 && j < 17){
					int product = array[i][j]*array[i+1][j+1]*array[i+2][j+2]*array[i+3][j+3];
					
					
					if(best < product){
						best = product;
						index = "(" + i + "," + j + ")";
					}
					i++;
					j++;
				}
			}
			
			for(int row = 0; row < 17; row++){
				int j = 0;
				int i = row;
				while(i <17 && j < 17){
					int product = array[i][j]*array[i+1][j+1]*array[i+2][j+2]*array[i+3][j+3];
					
					
					if(best < product){
						best = product;
						index = "(" + i + "," + j + ")";
					}
					i++;
					j++;
				}
			}
			
			System.out.println("Best product Diagonally NorthEast to SouthWest : " + best);
			System.out.println(index);
			
			
			/*Diagonal Computation SouthEast to NorthWest*/
			best = 0;
			
			for(int row = 3; row < 20; row++){
				int j = 0;
				int i = row;
				while(i >2 && j < 20){
					int product = array[i][j]*array[i-1][j+1]*array[i-2][j+2]*array[i-3][j+3];
					
					if(best < product){
						best = product;
						index = "(" + i + "," + j + ")";
					}
					i--;
					j++;
				}
			}
			
			for(int col = 1; col < 20; col++){
				int j = col;
				int i = 19;
				while(i >2 && j < 17){
					int product = array[i][j]*array[i-1][j+1]*array[i-2][j+2]*array[i-3][j+3];
					
					
					if(best < product){
						best = product;
						index = "(" + i + "," + j + ")";
					}
					i--;
					j++;
				}
			}
			
			System.out.println("Best product Diagonally SouthEast to NorthWest : " + best);
			System.out.println(index);
			
		}
		public static void readTable(){
			File f = null;
			BufferedReader br = null;
			String str = "";
			array = new int[20][20];
			try{
				f = new File("./data/problem0011.txt");
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
	        try {
	            str = br.readLine();
	            }
	        catch (IOException e) {
	            System.err.println("Error reading line .");
	        }
	        int lineCounter = 0;
	        //counter for each character that enters the table
	        StringTokenizer st;
	        while (str != null ) {
	        	st = new StringTokenizer(str);
	        	int column = 0;
	        	while(st.hasMoreTokens()){
	        		array[lineCounter][column] = Integer.parseInt(st.nextToken());
	        		column++;
	        	}
	        	lineCounter++;
	        	//array[][] = Integer.parseInt(String.valueOf(str.charAt(i)) );
	        	
	        	try {
	                str = br.readLine();
	               // System.out.println(str);
	            }
	            catch (IOException e) {
	                System.err.println("Error reading line .");
	            }
	        }
		
	}
}
