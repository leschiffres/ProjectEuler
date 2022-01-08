import java.io.*;
public class problem8 {
	private static long[] array;
	public static void main(String[] args){
		readTable();
		long[] maxmult = new long[1000];
		maxmult[0] = array[0];
		System.out.println("\n" + maxmult[0]);
		for(int i = 1; i < 13; i++){
			maxmult[i] = maxmult[i-1]*array[i];
			System.out.print(" "+maxmult[i]);
		}
		System.out.println();
		long multnow = 1;
		for(int i = 13; i < array.length; i++){
			multnow = 1;
			for(int j = i-12; j <= i;j++){
				multnow = multnow*array[j];
			}
			maxmult[i] = max(maxmult[i-1], multnow);
			if(maxmult[i] == multnow){System.out.println("It changed at position " + i);}
			System.out.println(maxmult[i]);
		}
		
		
	}
	public static long max(long a, long b){
		if(a>b) return a;
		else return b;
	}
	public static void readTable(){
		File f = null;
		BufferedReader br = null;
		String str = "";
		array = new long[1000];
		try{
			f = new File("problem008.txt");
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
        //counter for each character that enters the table
        int counter = 0;
        while (str != null ) {
        	for(int i = 0; i < str.length(); i++){
        		System.out.print(str.charAt(i) + "");
        		array[counter + i] = Integer.parseInt(str.charAt(i) + "");
        		
        	}
        	counter += str.length();
        	try {
                str = br.readLine();
                }
            catch (IOException e) {
                System.err.println("Error reading line .");
            }
        }
	}
	
}
