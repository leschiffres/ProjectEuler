import java.util.HashSet;
import java.util.ArrayList;
/*We are going to pick iteratively the problems and not store them all directly into memory
 * because we will need a list that will keep 2-dimensional arrays which is complex and not 
 * the goal of this problem.*/


public class Problem96 {
	static int x = 0,y = 0;
	//int[][] sudoku = new int[9][9];
	static int[][] sudoku = {{0,0,3,0,2,0,6,0,0},
						{9,0,0,3,0,5,0,0,1},
						{0,0,1,8,0,6,4,0,0},
						{0,0,8,1,0,2,9,0,0},
						{7,0,0,0,0,0,0,0,8},
						{0,0,6,7,0,8,2,0,0},
						{0,0,2,6,0,9,5,0,0},
						{8,0,0,2,0,3,0,0,9},
						{0,0,5,0,1,0,3,0,0}};
	/*We keep an arraylist that contains a set of excluded numbers for every position in the sudoku. This means 
	 * that if there are 50 possible squares the excluded list would keep 50 hashets that contain the possible 
	 * numbers that are excluded.*/
	static ArrayList<HashSet<Integer>> excluded = new ArrayList<HashSet<Integer>>();
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	public static void main(String[] args){
		
		/*for(int i = 0; i < sudoku.length;i++){
			for(int j = 0; j< sudoku.length;j++){
				excluded.add(new HashSet<Integer>());
				numbers.add(sudoku[i][j]);
				System.out.print(sudoku[i][j] + ",");
			}
			System.out.println();
		}
		
		System.out.println(getNumber(1,5));
		sendCoordinates(1*9+5);
		System.out.println(sudoku[x][y]);
		*/
		
		for(int i = 0; i < sudoku.length;i++){
			for(int j = 0; j< sudoku.length;j++){
				excluded.add(new HashSet<Integer>());
				numbers.add(sudoku[i][j]);
			}
		}
		
		for(int i = 0; i < sudoku.length;i++){
			for(int j = 0; j< sudoku.length;j++){
				if(sudoku[i][j]==0){
					System.out.println("------------------------------");
					computeExcluded(i, j);
					printCandidates(i,j);
					System.out.println("\n------------------------------");
				}
			}
		}
	
	}
	
	static void printCandidates(int x,int y){
		int arraylistpos = x*9+y;
		HashSet<Integer> s;
		s = excluded.get(arraylistpos);
		System.out.println("Candidates : ");
		for(int i = 1; i <= 9; i++){
			if(!s.contains(i)){
				System.out.print(i + ",");
			}
		}
	}
	/*Computes the excluded numbers for the sudoku position (x,y)*/
	static void computeExcluded(int x, int y){
		int arraylistpos = x*9+y;
		HashSet<Integer> s;
		s = excluded.get(arraylistpos);
		
		/*Every element in the same line with the position is excluded*/
		for(int j = 0; j<9;j++){
			if(sudoku[x][j] != 0){
				s.add(sudoku[x][j]);
			}
		}
		/*Every element in the same column with the position is excluded*/
		for(int i = 0; i < 9; i++){
			if(sudoku[i][y]!=0){
				s.add(sudoku[i][y]);
			}
		}
		/*Every element in the same rectangle is excluded*/
		int square = getSquare(x,y);
		int xstart = 0,xend = 0,ystart = 0,yend = 0;
		System.out.println("Square : " + square);
		switch (square) {
			case 1: xstart=0;xend=2;ystart=0;yend=2;
					break;
			case 2:	xstart=0;xend=2;ystart=3;yend=5;
					break;
			case 3:	xstart=0;xend=2;ystart=6;yend=8;
					break;
			case 4:	xstart=3;xend=5;ystart=0;yend=2;
					break;
			case 5:	xstart=3;xend=5;ystart=3;yend=5;
					break;
			case 6: xstart=3;xend=5;ystart=6;yend=8;
					break;
			case 7: xstart=6;xend=8;ystart=0;yend=2;
					break;
			case 8: xstart=6;xend=8;ystart=3;yend=5;
					break;
			case 9: xstart=6;xend=8;ystart=6;yend=8;
					break;
			default: System.out.println("Olo vlakeies les");
					break;
		}
		
		for(int i = xstart; i <=xend; i++){
			for(int j = ystart; j <= yend; j++){
				if(sudoku[i][j]!=0){
					s.add(sudoku[i][j]);
				}
			}
		}
		System.out.println("Excluded numbers for position (" +x + "," + y + ")");
		System.out.println(s);
	}
	
	/*This method returns the right element from the arraylist numbers that contains the elements
	 * of a two dimensional matrix in a single one-dimensional matrix. If we want the element (3,6) 
	 * which is 6 int the above example matrix we just calculate 3*9+6 and we get what we wanted. The
	 * method considers that matrix indexes start from 0 until 8 but it gets coordinates that start from
	 * 1 and end at 9. */
	static int getNumber(int i,int j){
		int position = i*9+j;
		return numbers.get(position);
	}
	/*However the method getNubmer just sends a number from the list. How can we know the coordinates of a
	 * specific number? In this case we do exactly the oposite suppose that we are in he position 11 of the
	 * arraylist (index starts from 0) this means that we are in the second line at the fourth element (=3). 
	 * We can easily induce that just by considering i = n/9, j = n%i + 1. It returns coordinates from 0 to 8.*/
	
	static void sendCoordinates(int n){
		x = n/9;
		y = n%9;
		System.out.println("("+x + "," + y + ")");
	}
	
	/*Next we need to create a method that finds the square that every number in the sudoku belongs
	 * the method considers that the given coordinates start from 0 and end at 8.*/
	
	static int getSquare(int i,int j){
		
		if(i<=2){
			if(j<=2){
				return 1;
			}
			else if(j<=5){
				return 2;
			}
			else{
				return 3;
			}
		}
		else if(i<=5){
			if(j<=2){
				return 4;
			}
			else if(j<=5){
				return 5;
			}
			else{
				return 6;
			}
		}
		else{
			if(j<=2){
				return 7;
			}
			else if(j<=5){
				return 8;
			}
			else{
				return 9;
			}
		}
		
	}
	static void printSquare(int x,int y){
		int square = getSquare(x,y);
		int xstart = 0,xend = 0,ystart = 0,yend = 0;
		System.out.println("\nSquare : " + square);
		switch (square) {
			case 1: xstart=0;xend=2;ystart=0;yend=2;
					break;
			case 2:	xstart=0;xend=2;ystart=3;yend=5;
					break;
			case 3:	xstart=0;xend=2;ystart=6;yend=8;
					break;
			case 4:	xstart=3;xend=5;ystart=0;yend=2;
					break;
			case 5:	xstart=3;xend=5;ystart=3;yend=5;
					break;
			case 6: xstart=3;xend=5;ystart=6;yend=8;
					break;
			case 7: xstart=6;xend=8;ystart=0;yend=2;
					break;
			case 8: xstart=6;xend=8;ystart=3;yend=5;
					break;
			case 9: xstart=6;xend=8;ystart=6;yend=8;
					break;
			default: System.out.println("Olo vlakeies les");
					break;
		}
		
		for(int i = xstart; i <=xend; i++){
			for(int j = ystart; j <= yend; j++){
				System.out.print(sudoku[i][j]+",");
			}
			System.out.println();
		}
	}

}
