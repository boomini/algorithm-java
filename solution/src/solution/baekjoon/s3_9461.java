package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_9461 {
	//항상 극단적인 테케 적용해보기
	//long 해줘야한다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int q[] = new int[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			q[i] = Integer.parseInt(in.readLine());
			max = Math.max(max, q[i]);
		}
		long P[];
		if(max<6) {
			P = new long[5];
		}
		P = new long[max+1];
		
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;
		
		for(int i=6; i<=max; i++) {
			P[i] = P[i-1]+P[i-5];
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(P[q[i]]);
		}
		
		
		
	}
}
