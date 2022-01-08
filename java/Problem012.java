import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Problem12 {
	static int foo = 0;

	public static void main(String[] args) {
		/*
		 * String filename = "./txt files/problem12.txt"; ArrayList<String>
		 * mylist = new ArrayList<String>(); int result = 0; String s = "";
		 * for(int i = 1; i <10000; i++){ result += i; s = findDivisors(result);
		 * mylist.add(result + " :" + s + " NumOfDivisors : " + foo); if(foo >
		 * 500){ System.out.println(result); } } FileManager.write(mylist,
		 * filename);
		 */
		int result = 0;
		String s = "";
		for (int i = 1; i <= 12000; i++) {
			result += i;

		}
		result = 76576500;
		System.out.println(result);
		System.out.println(findDivisorsWithPrimes(result));

	}

	/*
	 * It does not work because it needs to store a large amount of numbers.
	 * Therefore it is nearly impossible to apply an eratosthenis approach in
	 * this case
	 */
	public static String smartFindDivisors(long N) {
		foo = 1;
		String s = "1";
		ArrayList<Boolean> a = new ArrayList<Boolean>();
		for (int i = 1; i <= N / 2; i++) {
			a.add(true);
			// System.out.println(a[i]);
		}

		for (int i = 2; i <= N / 2; i++) {
			if (a.get(i - 1)) {
				if (N % i == 0) {
					s += " " + i;
					foo++;
				} else {
					for (int j = i; j <= N / 2; j += i) {
						a.set(j - 1, false);
					}
				}
			}
		}
		return s;
	}

	// For some reason this works
	public static int findDivisors(int N) {
		int foo = 0;
		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0) {
				foo += 2;
			}
		}
		return foo;
	}

	public static int findDivisorsWithPrimes(int N) {
		int divisors = 0;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int p : MyFunctions.EratosthenisSieve(N / 2)) {
			hmap.put(p, 0);
		}
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		//p is the prime in every iteration
		int p = 0;
		// alpha is the power of the prime which divides exactly N
		int alpha = 0;
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			p = (int)mentry.getKey();
			/*System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());*/
			if(N % p == 0){
				N = N / p;
				alpha++;
				while(N % p == 0){
					N = N / p;
					alpha++;
				}
			}
		}
		return divisors;
		
	}
}
