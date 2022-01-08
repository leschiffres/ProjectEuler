import java.util.ArrayList;

/*Vertex.java is created in order to solve problem 15.*/

public class Vertex {
	private int ID;
	private ArrayList<Vertex> predecessors;
	
	public Vertex(int ID, Vertex u, Vertex v){
		this.predecessors = new ArrayList<Vertex>();
		this.ID = ID;
		if(u!= null){
			this.predecessors.add(u);
		}
		if(v!= null){
			this.predecessors.add(v);
		}
	}
	
	public int getID(){
		return ID;
	}
	
	public ArrayList<Vertex> getPredecessors(){
		return predecessors;
	}
	public String toString(){
		return String.valueOf(ID);
	}
}
