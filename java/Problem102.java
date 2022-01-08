import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
/*This class computes the number of triangles in the corresponding file 
 * that contain the point (0,0). The way it does so is by calculating if the point
 * is left from the line AC, top from BC and right from AB*/
public class Problem102 {

	static HashSet<Integer> notCapturedTriangles = new HashSet<Integer>();
	
	static ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	static int leftRight = 0;
	static int topDown = 0;
	static int normal = 0;
	public static void main(String[] args) {
		notCapturedTriangles.add(45);
		notCapturedTriangles.add(59);

		notCapturedTriangles.add(94);
		notCapturedTriangles.add(146);
		
		notCapturedTriangles.add(208);
		notCapturedTriangles.add(267);

		notCapturedTriangles.add(301);
		notCapturedTriangles.add(308);
		
		notCapturedTriangles.add(456);
		notCapturedTriangles.add(458);

		notCapturedTriangles.add(468);
		notCapturedTriangles.add(498);
		
		notCapturedTriangles.add(539);
		notCapturedTriangles.add(546);

		notCapturedTriangles.add(579);
		notCapturedTriangles.add(600);

		notCapturedTriangles.add(626);
		notCapturedTriangles.add(628);

		notCapturedTriangles.add(637);
		notCapturedTriangles.add(653);

		notCapturedTriangles.add(680);
		notCapturedTriangles.add(739);

		notCapturedTriangles.add(839);
		notCapturedTriangles.add(857);

		notCapturedTriangles.add(897);
		notCapturedTriangles.add(900);

		notCapturedTriangles.add(910);
		

		//-340,495,-153,-910,835,-947
		/*Triangle t = new Triangle(new Point(-2,1),new Point(2,-3), new Point(1,2));
		System.out.println(containsOrigin(t));
		t = new Triangle(new Point(-1,0),new Point(1,0), new Point(0,1));
		System.out.println(containsOrigin(t));*/
		readFile("./data/problem0102.txt");
		int counter = 0;
		for(Triangle t : triangles){
			if(containsOrigin(t)){
				System.out.println("true");
				counter++;
			}
			else{
				System.out.println("false");
			}
		}
		
		System.out.println("Total number of triangles containing origin : " + counter);
		System.out.println("On line AC or BC : " + leftRight);
		System.out.println("On line BC : " + topDown);
		System.out.println("In the triangle ABC : " + normal);
		
		/*This code calculates whether there is a vertical line (lambda equals infinity), 
		 * or horizontal line (lambda equals 0)
		 * in any of the triangles
		
		for(Triangle t: triangles){
			if(t.p1.x == t.p2.x || t.p1.x == t.p2.x || t.p2.x == t.p3.x){
				System.out.println("We found a vertical line");
			}
			if(t.p1.y == t.p2.y || t.p1.y == t.p2.y || t.p2.y == t.p3.y){
				System.out.println("We found a vertical line");
			}
			
		}*/
		
		
	}
	
	static boolean containsOrigin(Triangle t){
		//Find northest point
		int northest = -1000;
		if(t.p1.y > northest) northest = t.p1.y;
		if(t.p2.y > northest) northest = t.p2.y;
		if(t.p3.y > northest) northest = t.p3.y;
		
		//Find left and right according to the norhtest and call the proper function
		if(northest == t.p1.y){
			if(t.p2.x < t.p3.x){
				return isInTriangle(t.p1,t.p2,t.p3);
			}
			else if(t.p3.x < t.p2.x){
				return isInTriangle(t.p1,t.p3,t.p2);
			}
			else{
				System.out.println("Investigate this case : " + t);
				return false;
			}
			
		}
		else if(northest == t.p2.y){
			if(t.p1.x < t.p3.x){
				return isInTriangle(t.p2, t.p1, t.p3);
			}
			else if(t.p3.x < t.p1.x){
				return isInTriangle(t.p2, t.p3, t.p1);
			}
			else{
				System.out.println("Investigate this case : " + t);
				return false;
			}
		}
		else{
			if(t.p1.x < t.p2.x){
				return isInTriangle(t.p3, t.p1,t.p2);
			}
			else if (t.p2.x < t.p1.x) {
				return isInTriangle(t.p3, t.p2,t.p1);
			}

			else{
				System.out.println("Investigate this case : " + t);
				return false;
			}
		}
	}
	/*This function considers that the northest point is A the left is B and the right is C.*/
	static boolean isInTriangle(Point A, Point B, Point C){
		
		int AC = leftRightSideFromLine(A, C);
		if(AC == 0){
			leftRight++;
			return true;
		}
		else if( AC == 1) {
			return false;
		}
		else{
			int AB = leftRightSideFromLine(A, B);
			if(AB == 0){
				leftRight++;
				return true;
			}
			else if(AB == -1){
				return false;
			}
			else{
				int BC = topDownSideFromLine(B, C);
				if(BC == 0){
					topDown++;
					return true;
				}
				else if(BC == -1){
					return false; 
				}
				else{
					normal++;
					return true;
				}
			}
		}
		
		
	}
	
	/*This function returns a value that determines if the point(0,0) is top or bottom
	 * from the line passing by the points A,B. In fact if we get a positive (resp. negative)
	 *  value this means that the origin is souther (resp. norther) than the line.
	 *  
	 *  This function returns -1 if the origin is down from the line, 1 if it is top from the line
	 *  0 if it is on the line.*/
	static int topDownSideFromLine(Point A, Point B){
		double lambda = 0;
		if(A.x-B.x != 0){
			lambda = (double) (A.y-B.y)/(A.x-B.x);
		}
		else{
			System.out.println("We got a problem here");
			/*Generally this else statement should not be reached since BC cannot
			 * be a vertical line.() normally unless A is the northest point and B
			 * corner is > 90.*/
		}
		double y = A.y-lambda*A.x;
		if(y > 0){
			return -1;
		}
		if(y == 0){
			return 0;
		}
		else{
			return 1;
		}
	}
	/*Suppose we have two points A(x1,y1), B(x2,y2). First we need to determine which is left
	 * which is right. Then we compute the value d = (x-x1)(y2-y1)-(y-y1)(x2-x1). Since (x,y)= (0,0)
	 * we get d = (x1y1-x1y2)-(x1y1-x2y1)= (x2y1-x1y2). Now if d!=0 then we know for sure that 
	 * (0,0) does not lie on the line (otherwise it does lie).
	 * 
	 * In order to find in which side the point is, we calculate d value for a point known to be 
	 * left or right (like (x1-1,y1) is certainly on the left side) and if both d values have the 
	 * same sign then the origin lies on this side of the line.
	 * 
	 * 
	 * For the point (x1-1,y1) the d value is:
	 * d = (x1-1-x1)(y2-y1)-(y1-y1)(x2-x1)= y1-y2*/
	
	//The function returns 0 if the origin is on the line, -1 if the origin is left from the line
	// and 1 if it is right from the line
	static int leftRightSideFromLine(Point A,Point B){
		Point left, right;
		if(A.x <= B.x){
			left = A;
			right = B;
		}
		else{
			left = B;
			right = A;
		}
		//d = (x2y1-x1y2)
		int dOrigin = right.x*left.y - right.y*left.x;
		//d = (y1-y2)
		int dLeftPoint = left.y-right.y;
		if(dOrigin == 0){
			return 0;
		}
		else{
			if(Math.signum(dOrigin) == Math.signum(dLeftPoint)){
				return -1;
			}
			else{
				return 1;
			}
		}
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
		int i = 1;
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
					if(notCapturedTriangles.contains(i)){
						System.out.println("------------------------------- " + i + "------------------------------- ");
						System.out.println("Ax = [ " + p1.x + ", " + p2.x + ", " + p3.x + ", " + p1.x + "];");
						System.out.println("Ay = [ " + p1.y + ", " + p2.y + ", " + p3.y + ", " + p1.y + "];");
					}
					
					i++;
				}
			}

            catch (IOException e) {
                System.err.println("Error reading line .");
            }
		}
	}
	
}
class Triangle {
	Point p1, p2, p3;

	Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	public String toString(){
		return "Point A : " + p1 + "Point B : " + p2 + "Point C : " + p3;
	}
}

class Point {
	int x;
	int y;
	Point(){
		x = 0;
		y = 0;
	}
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "\nx : " + x + "\ty : " + y + "\n";
	}
}