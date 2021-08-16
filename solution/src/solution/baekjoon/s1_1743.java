package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_1743 {
	private static int[][] arr;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];// 0으로 초기화

		int count = 0;
		int max = 0;
		for (int i = 0; i < K; i++) {
			s = in.readLine();
			st = new StringTokenizer(s, " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			arr[num1 - 1][num2 - 1] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					int num = check(i, j, 1);
					max = max < num ? num : max;
				}

			}
		}
		System.out.println(max);

	}

	private static int check(int i, int j, int cnt) {
		int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int d = 0; d < 4; d++) {
			arr[i][j]=0;
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			if (ni < 0 || nj < 0 || ni >= N || nj >= M)
				continue;
			if (arr[ni][nj] == 1) {
				cnt = check(ni, nj, cnt + 1);
			}
		}

		return cnt;
	}
}
