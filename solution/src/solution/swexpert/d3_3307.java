package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_3307 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb =new StringBuilder();
		for(int tc =1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(in.readLine());
			
			int arr[] = new int[n];
			int LIS[] = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			for(int i=0; i<n; i++) {
				LIS[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[i]>arr[j] && LIS[i]<LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
				max = Math.max(max, LIS[i]);
			}
			
			
			sb.append(max).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
