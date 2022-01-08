import java.util.ArrayList;

/*The goal of this problem is to find the total number of paths of the top-left corner to the downright 
 * in a grid 20 x 20. The directions we can take is either down or right. 
 * 
 * In order to solve this we create a graph of this grid and starting from the bottom right corner,
 * we go backwards going always to previous neighbours.*/
public class Problem15 {
	static ArrayList<Vertex> vertices; 
	static long totalPaths;
	static long start = System.currentTimeMillis();
	public static void main(String[] args){
		constructGraph(2);
		RecursionPath(vertices.get(vertices.size()-1), "");
		System.out.println("Total paths : " + totalPaths);
		System.out.println( (double)(System.currentTimeMillis() - start)/1000 + " seconds");
	}
	
	public static void RecursionPath(Vertex v, String s){
		if(v.getID() == 1){
			totalPaths++;
			s += String.valueOf(v.getID());
			System.out.println(s);
			return;
		}
		s += String.valueOf(v.getID()) + " ";
		ArrayList<Vertex> pred = v.getPredecessors();
		for(Vertex u : pred){
			RecursionPath(u, s);
		}
	}
	
	public static void constructGraph(int N){
		vertices = new ArrayList<Vertex> ();
		int totalNumberOfVertices = (N+1)*(N+1);
		vertices.add(new Vertex(1, null, null));
		for(int i = 2; i <= N+1; i++){
			/*The first row of vertices has exactly one neighbour, the one
			 * with ID = i - 1. Of course, in order to access it in the matrix
			 * (where the first vertex starts in position 0) we have to decrease
			 * by one.*/
			vertices.add(new Vertex(i, vertices.get(i-1-1), null));
		}
		
		for(int i = N+2; i <= totalNumberOfVertices; i++){
			if(i % (N+1)== 1){
				vertices.add(new Vertex(i, vertices.get(i - (N+1) - 1), null));
			}
			else{
				vertices.add(new Vertex(i, vertices.get(i - (N+1) - 1),  vertices.get(i-1-1)));
			}
		}
	}
}
