package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_3234 {
	private static int R;
	private static int arr[];
	private static int arr2[];
	private static int h[];
	private static int count;
	private static boolean isSelected[];
	private static boolean isSelected2[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			R = Integer.parseInt(in.readLine());
			arr = new int[R];
			arr2 = new int[R];
			count = 0;
			String s = in.readLine();
			h = new int[R];
			int remain = 0;
			StringTokenizer st = new StringTokenizer(s, " ");
			for (int i = 0; i < R; i++) {
				h[i] = Integer.parseInt(st.nextToken());
				remain += h[i];
			}
			isSelected = new boolean[R];
			isSelected2 = new boolean[R];
			permutation(0);
			//dfs(0,left,right);
			sb.append(count).append("\n");


		}
		System.out.println(sb.toString());
	}

	private static void permutation(int cnt) {
		if(cnt==R) {
			dfs(0,0,0);
			return;
		}
		for(int i=0; i<R; i++) {
			if(isSelected2[i]) continue;
			isSelected2[i] = true;
			arr2[cnt] = h[i];
			permutation(cnt+1);
			isSelected2[i] = false;
			
		}
		
	}
	private static void dfs(int cnt,int left, int right) {
		if(right>left) return;
		if(cnt==R) {
			if(left>=right) {
				count++;
			}
			return;
		}
		isSelected[cnt] = true;
		left += arr2[cnt]; 
		arr[cnt] = arr2[cnt];
		dfs(cnt+1, left, right);
		
		isSelected[cnt] = false;
		left -= arr2[cnt];
		right += arr2[cnt];
		arr[cnt] = 0;
		dfs(cnt+1,left,right);
		
	}

	
}
