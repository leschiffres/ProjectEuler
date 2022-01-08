import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class FileManager {
	public static ArrayList<String> load(String filename){
		BufferedReader br = null;
		File f = null;
		String line = "";
		ArrayList<String> mySet = new ArrayList<String>();
		
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
		while(line != null){
			try{
				line = br.readLine();
				//After the last line of the file, the variable "line" will have as value null
				if(line != null){
					mySet.add(line);
				}
			}

            catch (IOException e) {
                System.err.println("Error reading line .");
            }
		}
		return mySet;
	}

	public static void write(ArrayList<String> mylist, String filename){
		// Enter name of the file on which you want to write.
		BufferedWriter bw = null;
		File f = null;
        try{
			f = new File(filename);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
            bw = new BufferedWriter ( new OutputStreamWriter ( new FileOutputStream(f)));
        }
        catch (FileNotFoundException e) {
            System.err.println("Error opening file for writing!");
        }
        //write word str into file
        for(String str : mylist){
			try {
	            bw.write( str +"\n");
	            bw.flush();
	        } catch (IOException e) {
	            System.err.println("Write error!");
	        }
        }
        
	}
}
