
public class Problem28 {
	/*Dimension of the squared matrix*/
	static int N = 1001; 
	static int[][] a = new int[N][N];
	public static void main(String[] args){
		String[] direction = {"right" , "bot", "left", "up"};
		
		int i = (N-1)/2, j = (N-1)/2,  number = 1;
		a[i][j] = number++;
		a[i][++j] = number++;
		int dir = 1;
		while(a[0][N-1] == 0 ||a[N-1][0]==0){
			if(direction[dir].equals("right")){
				while(j < N-1){
					j++;
					//System.out.println("i : " + i);
					//System.out.println("j : " + j);
					if(a[i+1][j-1]!=0){
						a[i][j] = number++;
						//System.out.println("a["  +i + "," + j + "] : " + (number-1));
					}
					else{
						j--;
						break;
					}
				}
				dir = (dir+1) % direction.length;
			
			}
			else if(direction[dir].equals("bot")){
				while(i < N-1){
					i++;
					if(a[i-1][j-1]!=0){
						a[i][j] = number++;
						//System.out.println("a["  +i + "," + j + "] : " + (number-1));
					}
					else{
						i--;
						break;
					}
				}
				dir = (dir+1) % direction.length;
				
			}
			else if(direction[dir].equals("left")){
				while(j > 0){
					j--;
					if(a[i-1][j+1]!=0){
						a[i][j] = number++;
						//System.out.println("a["  +i + "," + j + "] : " + (number-1));
					}
					else{
						j++;
						break;
					}
				}
				dir = (dir+1) % direction.length;
			}
			else if(direction[dir].equals("up")){
				while(i > 0){
					i--;
					if(a[i+1][j+1]!=0){
						a[i][j] = number++;
						//System.out.println("a["  +i + "," + j + "] : " + (number-1));
					}
					else{
						i++;
						break;
					}
				}
				dir = (dir+1) % direction.length;
			}
			
		}
		System.out.println("Sum in diagonals : " + sumDiagonals());
	}
	
	static void printMatrix(){
		for(int i = 0; i < N;i++){
			System.out.print(i + " : ");
			for(int j = 0; j< N; j++ ){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
			
		}
	}
	static int sumDiagonals(){
		int sum = 0;
		int i = 0;
		int j = 0;
		while(i <= N-1 && j <= N-1){
			sum += a[i++][j++];
			//System.out.println("Adding (" + i + "," + j + ") : " + a[i-1][j-1] );
		}
		
		i = N-1;
		j = 0;
		while(i >=0 && j <= N-1){
			sum += a[i--][j++];
		}
		sum--;
		return sum;
	}
}
