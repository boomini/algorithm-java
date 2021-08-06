package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_1861 {
	private static int cnt[][];
	private static int N;
	private static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	private static int num[][];
	private static int max, index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {

			sb.append("#").append(tc).append(" ");
			max = 0;
			index = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			num = new int[N][N];
			cnt = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = in.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				for (int j = 0; j < N; j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cnt[i][j] != 0)
						continue;
					check(i, j, 1);
				}
			}
			sb.append(index).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int check(int i, int j, int count) {
		
		if(cnt[i][j] != 0) {
			return cnt[i][j];
		}
		for (int d = 0; d < 4; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			if (ni < 0 || ni >= N || nj < 0 || nj >= N)
				continue;
			if (num[ni][nj] == num[i][j] + 1) {
				count = check(ni, nj, count);
				count++;
			}
		}
		if (count != 1) {
			if (max < count) {
				max = count;
				index = num[i][j];
			} else if (max == count && index > num[i][j]) {
				index = num[i][j];
			}
			
		}
		cnt[i][j] = count;
		return count;
	}
}
