package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class s3_14889 {
	private static int N;
	private static int R;
	private static int map[][];
	private static Integer num[];
	private static int min = Integer.MAX_VALUE;
	private static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		R = N/2;
		map = new int[N][N];
		num = new Integer[R];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0,0);
		System.out.println(min);
	}

	private static void combination(int cnt, int start) {
		if(cnt==R) {
			//System.out.println(Arrays.toString(num));
			List<Integer> arr = Arrays.asList(num);
			List<Integer> arr2 = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				if(!arr.contains(i)) {
					arr2.add(i);
				}
			}
			min = Math.min(Math.abs(getsum(arr)-getsum(arr2)), min);
			return;
		}
		
		for(int i=start; i<N; i++) {
			num[cnt] = i;
			combination(cnt+1, i+1);
		}
		
	}

	private static int getsum(List<Integer> arr) {
		int n = N/2;
		int sum=0;
		for(int i=0;i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				sum+=(map[arr.get(i)][arr.get(j)]+map[arr.get(j)][arr.get(i)]);				
			}
		}
		return sum;
		
	}
}
