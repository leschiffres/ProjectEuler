
public class Problem21 {

	public static void main(String[] args){
		long start = System.currentTimeMillis();
		int[] divisorsSum = new int[10000];
		for(int N = 1; N < 10000; N++){
			boolean[] div = new boolean[N/2 + 1];
			for(int i = 2; i < div.length;i++){
				div[i] = true;
			}
			divisorsSum[N]++;
			for(int i = 2; i <= N/2;i++){
				if(div[i]){
					if(N % i == 0){
						divisorsSum[N] += i;
						//System.out.println(i);
					}
					else{
						int index = i;
						while(index < div.length){
							div[index] = false;
							index += i;
						}
					}
				}
			}
			//System.out.println(N + " : " + sum);
		}	

		int sumOfFriendNumbers = 0;
		for(int i = 1; i < divisorsSum.length; i++){
			if(divisorsSum[i] < divisorsSum.length && divisorsSum[divisorsSum[i]] < divisorsSum.length){
				if(i == divisorsSum[divisorsSum[i]] && divisorsSum[i] != i && i < divisorsSum[i] ){
					sumOfFriendNumbers += i + divisorsSum[i];
					System.out.println(i + " and " + divisorsSum[i] + " are friend numbers!");
				}
			}
		}
		System.out.println(sumOfFriendNumbers);
		System.out.println((double)(System.currentTimeMillis() - start)/1000 + " sec");
	}
	
}
