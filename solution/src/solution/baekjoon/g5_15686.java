package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_15686 {
	private static int M;
	private static int W;
	private static int arr[];
	private static int min=Integer.MAX_VALUE;
	private static ArrayList<int[]> chicken;
	private static ArrayList<int[]> home;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		int index = 0;
		arr = new int[M];
		for (int i = 0; i < N; i++) {
			s=in.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					home.add(new int[]{i,j});
				}else if(num==2) {
					chicken.add(new int[]{i,j});
				}
			}
			
		}
		W=chicken.size();
		combination(0,0);
		System.out.println(min);
	}

	private static void combination(int cnt, int start) {
		if(cnt==M) {
			calcMin();
			return;
		}
		for(int i=start; i<W; i++) {
			arr[cnt] = i;
			combination(cnt+1, i+1);
		}
		
	}
	
	private static void calcMin() {
		int sum = 0;
		for(int i=0; i<home.size(); i++) {
			int minus = Integer.MAX_VALUE;
			for(int j=0; j<arr.length; j++) {
				int minusX = Math.abs(home.get(i)[0]-chicken.get(arr[j])[0]);
				int minusY = Math.abs(home.get(i)[1]-chicken.get(arr[j])[1]);
				int k = minusX + minusY;
				minus = minus>k?k:minus;
				
			}
			sum += minus;
		}
		min = min>sum?sum:min;
	}
}
