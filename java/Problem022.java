import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem22 {

	static Map<String, Integer> letters = new HashMap<String, Integer>();
	public static void main(String[] args) {
		loadLetters();
		int sum = 0;
		 ArrayList<String> names = sortFile("./data/problem0022.txt");
		 for(int i = 0; i < names.size(); i++){ 
			 sum += (i+1) * getValue(names.get(i));
		 } 
		 System.out.println(sum);
		 	
	}
	
	public static int getValue(String s){
		int sum = 0;
		for(int i = 0; i < s.length(); i++){
			sum += letters.get(s.charAt(i) + "");
		}
		return sum;
	}
	
	public static void loadLetters(){
		
		letters.put("A", 1);
		letters.put("B", 2);
		letters.put("C", 3);
		letters.put("D", 4);
		letters.put("E", 5);
		letters.put("F", 6);
		letters.put("G", 7);
		letters.put("H", 8);
		letters.put("I", 9);
		letters.put("J", 10);
		letters.put("K", 11);
		letters.put("L", 12);
		letters.put("M", 13);
		letters.put("N", 14);
		letters.put("O", 15);
		letters.put("P", 16);
		letters.put("Q", 17);
		letters.put("R", 18);
		letters.put("S", 19);
		letters.put("T", 20);
		letters.put("U", 21);
		letters.put("V", 22);
		letters.put("W", 23);
		letters.put("X", 24);
		letters.put("Y", 25);
		letters.put("Z", 26);
	}

	public static ArrayList<String> sortFile(String filename) {
		BufferedReader br = null;
		File f = null;
		String line = "";
		ArrayList<String> names = new ArrayList<String>();

		try {
			f = new File(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file for writing!");
		}
		while (line != null) {
			try {
				line = br.readLine();
				// After the last line of the file, the variable "line" will
				// have as value null
			} catch (IOException e) {
				System.err.println("Error reading line .");
			}
			if (line != null) {
				StringTokenizer st = new StringTokenizer(line, "\",\"");
				while (st.hasMoreTokens()) {
					names.add(st.nextToken());
				}
			}

		}
		
		// Sort the arraylist
		for (int j = 0; j < names.size(); j++) {
			for (int i = j + 1; i < names.size(); i++) {
				if (names.get(i).compareTo(names.get(j)) < 0) {
					String temp = names.get(j);
					names.set(j, names.get(i));
					names.set(i, temp);
				}
			}
		}
		return names;
	}

}
