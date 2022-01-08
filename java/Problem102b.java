import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Problem102b {


	static ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	public static void main(String[] args){
		
		readFile("./data/problem0102.txt");
		Point origin = new Point(0,0);
		int counter = 0;
		double ABC = 0,APC = 0,BPC = 0,APB = 0;
		for(Triangle t : triangles){
			ABC = area(t.p1, t.p2,t.p3);
			APB = area(t.p1, t.p2, origin);
			BPC = area(t.p2, t.p3, origin);
			APC = area(t.p1, t.p3, origin);
			if(ABC == APB+APC+BPC){
				counter++;
				System.out.println(true);
			}
			else{
				System.out.println(false);
			}
		}
		System.out.println("# of triangles containing (0,0) : " + counter);
		
	}
	/*This method calculates the area of a triangle given the coordinates
	 * of its points.*/
	static double area(Point A, Point B, Point C){
		
		
		double emvadon = (double) ((A.x-C.x)*(B.y-A.y)-(A.x-B.x)*(C.y-A.y))/2;
		emvadon = Math.abs(emvadon);
		
		return emvadon;
	}
	
	private static void readFile(String filename){
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
		while(line != null){
			try{
				line = br.readLine();
				//After the last line of the file, the variable "line" will have as value null
				if(line != null){

					Point p1 = new Point();
					Point p2 = new Point();
					Point p3 = new Point();
					//System.out.println(line);
					StringTokenizer st = new StringTokenizer(line, ",");
					p1.x = Integer.parseInt(st.nextToken());
					p1.y = Integer.parseInt(st.nextToken());
					p2.x = Integer.parseInt(st.nextToken());
					p2.y = Integer.parseInt(st.nextToken());
					p3.x = Integer.parseInt(st.nextToken());
					p3.y = Integer.parseInt(st.nextToken());
					
					triangles.add(new Triangle(p1,p2,p3));
					
				}
			}

            catch (IOException e) {
                System.err.println("Error reading line .");
            }
		}
	}
	
}


