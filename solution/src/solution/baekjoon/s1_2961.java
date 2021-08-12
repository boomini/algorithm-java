package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_2961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int sour[] = new int[N];
		int bitter[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = (int) Math.pow(2, N);
		int min = Integer.MAX_VALUE;
		int index = 1;
		for (int i = 1; i < count; i++) {
			int arr[][] = new int[N][2];
			for(int j=0; j<N; j++) {
				if((i & 1<<j)!=0) {
					arr[j][0] = sour[j];
					arr[j][1] = bitter[j];
				}
			}
			int sumSour = 1;
			int sumBitter = 0;
			
			for(int l=0; l<arr.length; l++) {
				sumBitter+=arr[l][1];
				if(arr[l][0]==0) continue;
				sumSour*=arr[l][0];
			}

			int minus = Math.abs(sumBitter-sumSour);
			min = min>minus?minus:min;
		}
		
		System.out.println(min);
	}
}
