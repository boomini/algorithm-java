package solution.more;

import java.io.*;
import java.util.*;

public class samsung_intermediate {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_im_±âÁö±¹.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.valueOf(in.readLine());
		int dx[] = new int[] { -1, 1, 0, 0 };
		int dy[] = new int[] { 0, 0, -1, 1 };
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.valueOf(in.readLine());
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int location = 0;
					char check = map[i][j];

					if (check == 'A' || map[i][j] == 'B' || map[i][j] == 'C') {
						if (check == 'A')
							location = 1;
						else if (check == 'B')
							location = 2;
						else
							location = 3;
						int num = 0;
						while (num++<location) {
							for (int d = 0; d < 4; d++) {
								int nx = i + dx[d]*num;
								int ny = j + dy[d]*num;
								if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
									if (map[nx][ny] == 'H')
										map[nx][ny] = 'X';
								}
							}
						}
					}
				}
			}
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H')
						cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}

	}
}
