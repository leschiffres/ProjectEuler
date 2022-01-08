/*If p is the perimeter of a right angle triangle () with integral length sides, {a,b,c}, 
 * there are exactly three solutions for p = 120.
{20,48,52}, {24,45,51}, {30,40,50}

*for which p is the number of solutions maximized?
*
*Everything depends on the triangle inequality*/
public class Problem39 {

	public static void main(String[] args){
		int maxTriangles = 0;
		int maxP = 0;
		for(int p  = 3; p <= 1000; p++){
			int triangles = 0;
			for(int a = 1; a < p-1; a++){
				for(int b = 1; b < a; b++){
					int c = p - a - b;
					if(c < a || c < b){
						break;
					}
					if(isRightAngleTriangle(a,b,c)){
						triangles++;
						//System.out.println(a + " " + b + " " + c);
					}
				}
			}
			if(triangles > maxTriangles){
				maxTriangles = triangles;
				maxP = p;
			}
		}
		System.out.println("Max perimeter : " +  maxP + " with triangles " + maxTriangles);
	}
	static boolean isRightAngleTriangle(int a, int b, int c){
		a = a*a;
		b = b*b;
		c = c*c;
		if(c == a+b){
			return true;
		}
		else{
			return false;
		}
	}
}
