package permutation;

import java.util.Arrays;

public class permutationBit {
	private static int N;
	private static int R;
	private static int count=0;
	private static int sol[];
	private static int arr[];
	public static void main(String[] args) {
		N = 4;
		R = 3;
		
		arr = new int[] {5,7,9,2};
		sol= new int[R];
		permutation(0,0);
		System.out.println(count);
		
	}

	private static void permutation(int cnt, int flag) {
		if(cnt==R) {
			System.out.println(Arrays.toString(sol));
			count++;
			return;
		}
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0) continue;
			sol[cnt] = arr[i];
			
			permutation(cnt+1,flag | 1<<i);
				
		}
		
	}
}
