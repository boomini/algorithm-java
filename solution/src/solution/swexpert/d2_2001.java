package solution.swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d2_2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new InputStreamReader(new FileInputStream("input_2001.txt")));
		int T = Integer.parseInt(in.readLine());
		StringBuffer sb = new StringBuffer();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int boardN[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					
					boardN[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxSum = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;

					int plusi = i;
					for (int l = 0; l < M; l++) {
						int plusj = j;
						for (int m = 0; m < M; m++) {
							sum += boardN[plusi][plusj++];
						}
						plusi++;

					}
					if (maxSum < sum)
						maxSum = sum;
				}

			}
			sb.append(maxSum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
