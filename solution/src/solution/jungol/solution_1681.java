package solution.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solution_1681 {
	private static int N;
	private static int num[];
	private static boolean visited[];
	private static int arr[][];
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					arr[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		num = new int[N];
		visited = new boolean[N];
		
		permutation(1,0);
		System.out.println(min);
}

	private static void permutation(int cnt,int sum) {
		if(cnt==N) {
			//System.out.println(Arrays.toString(num));
			sum+=arr[num[N-1]][0];
			min = Math.min(sum, min);
			//System.out.println(sum);
			return;
		}	
		if(sum>min) return;
		for(int i=1; i<N; i++) {
			if(visited[i]) continue;
			num[cnt] = i;
			visited[i] = true;
			
			permutation(cnt+1,sum+arr[num[cnt-1]][num[cnt]]);
			visited[i] = false;		
		}		
	}
}