package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s5_2578 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dir[][] = { { 1, 0 }, { 0, 1 }, { 1, -1 }, { 1, 1 } };// 하,우,대각선왼아래,대각선우아래
		int index = 0;
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());

				outer: for (int l = 0; l < 5; l++) {
					for (int m = 0; m < 5; m++) {
						if (arr[l][m] == num) {
							arr[l][m] = 0;
							index++;
							break outer;
						}
					}
				}
				if (index >= 5) {
					int bingcnt = 0;
					for (int l = 0; l < 5; l++) {
						int checki = -1;
						int checkj = -1;
						for (int m = 0; m < 5; m++) {
							if (arr[l][m] == 0) {
								checki = l;
								checkj = m;
								for (int d = 0; d < 4; d++) {
									int checkcnt = 1;
									int ni = checki + dir[d][0];
									int nj = checkj + dir[d][1];

									while (ni >= 0 && nj >= 0 && ni < 5 && nj < 5 && arr[ni][nj] == 0) {
										checkcnt++;
										ni += dir[d][0];
										nj += dir[d][1];
									}

									if (checkcnt == 5) {
										//System.out.println(checki+" " + checkj);
										bingcnt++;
									}
								}

								if (bingcnt == 3) {
									System.out.println(index);
									System.exit(0);

								}
							}
						}
					}

				}
			}
		}

	}

}
