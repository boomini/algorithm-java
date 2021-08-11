package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class d3_5215 {
	private static int[][] input;
	private static int R = 1;
	private static int N = 0, L = 0;
	private static int max = 0;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			max = 0;
			sb.append("#").append(tc).append(" ");
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			input = new int[N][N]; // 왼쪽엔 점수, 오른쪽엔 칼로리
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				s = in.readLine();
				st = new StringTokenizer(s, " ");
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			generateSubset(0);
			sb.append(max).append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void generateSubset(int cnt) {
		int calSum = 0;
		int scoreSum = 0;
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					calSum += input[i][1];
					if(calSum>L) return;
					scoreSum += input[i][0];
				}
			}
			
			if(calSum<=L && scoreSum >max) {
				max = scoreSum;
			}
			return;

		}

		isSelected[cnt] = true;
		generateSubset(cnt + 1);

		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
}
