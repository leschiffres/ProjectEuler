import java.util.ArrayList;

/*This class serves the purpose of problem 50*/
public class PrimeNumber {
	private int number;
	private ArrayList<Integer> terms;

	public PrimeNumber(int i) {
		number = i;
		terms = new ArrayList<Integer>();
	}

	public int getNumber() {
		return number;
	}

	public void addTerm(int i) {
		terms.add(i);
	}

	public int getTermSize() {
		return terms.size();
	}
	public String toString(){
		String s = String.valueOf(number) + " : ";
		for(Integer i : terms){
			s += i + " ";
		}
		return s;
	} 
}
