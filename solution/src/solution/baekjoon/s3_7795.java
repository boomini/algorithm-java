package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_7795 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[] Aarr = new int[A];
			int[] Barr = new int[B];
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<A; j++) {	
				Aarr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(Aarr);
			//System.out.println(Arrays.toString(Aarr));
			int sum = 0;
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<B; j++) {	
				Barr[j] = Integer.parseInt(st.nextToken());
				for(int k=A-1; k>=0; k--) {
					if(Aarr[k]>Barr[j]) {
						sum++;
					}else {
						break;
					}
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
