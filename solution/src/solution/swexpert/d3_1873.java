package solution.swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_1873 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new InputStreamReader(new FileInputStream("input_1873.txt")));
		int T = Integer.parseInt(in.readLine());// 테스트 케이스
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int fi = Integer.parseInt(st.nextToken());
			int fj = Integer.parseInt(st.nextToken());
			String[][] board = new String[fi][fj];

			int useri = 0;
			int userj = 0;
			int userdir = 0;

			String[][] dir = new String[][] { { "U", "^" }, { "D", "v" }, { "L", "<" }, { "R", ">" } };
			for (int i = 0; i < fi; i++) {
				String line = in.readLine();
				board[i] = line.split("");
				for (int j = 0; j < fj; j++) {
					// board[i][j] = check.nextToken();
					//System.out.println(i+ " " + j + " " + board[i][j]);
					if (board[i][j].equals(".") || board[i][j].equals("*") || board[i][j].equals("#") || board[i][j].equals("-"))
						continue;

					for (int k = 0; k < dir.length; k++) {
						if (board[i][j].equals(dir[k][1])) {
							useri = i;
							userj = j;
							userdir = k;
						}
					}

				}
			}
			// 보드입력

			// 유저움직임 입력
			int count = Integer.parseInt(in.readLine());
			String check = in.readLine();
			String[] user = new String[count];
			for (int i = 0; i < count; i++) {
				user = check.split("");
			}

			int dir_xy[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
			// 보드 설정
			for (int i = 0; i < count; i++) {
				String man = user[i];
				int ni = useri;
				int nj = userj;
				switch (man) {

				case "S":
					while (true) {

						ni = ni + dir_xy[userdir][0];
						nj = nj + dir_xy[userdir][1];
						if (ni < 0 || nj < 0 || ni >= fi || nj >= fj)
							break;
						else if (board[ni][nj].equals("*")) {
							board[ni][nj] = ".";
							break;
						} else if (board[ni][nj].equals("#"))
							break;

					}
					break;

				case "U":
					userdir = 0;
					ni = ni + dir_xy[userdir][0];
					nj = nj + dir_xy[userdir][1];
					board[useri][userj] = dir[userdir][1];
					if (ni < 0 || nj < 0 || ni >= fi || nj >= fj) {
						
						break;
					}
					else if (board[ni][nj].equals(".")) {
						board[useri][userj] = ".";
						useri = ni;
						userj = nj;
						board[useri][userj] = dir[userdir][1];
						break;
					}
					break;
				case "D":
					userdir = 1;
					ni = ni + dir_xy[userdir][0];
					nj = nj + dir_xy[userdir][1];
					board[useri][userj] = dir[userdir][1];
					if (ni < 0 || nj < 0 || ni >= fi || nj >= fj) {
						
						break;
					}
					else if (board[ni][nj].equals(".")) {
						board[useri][userj] = ".";
						useri = ni;
						userj = nj;
						board[useri][userj] = dir[userdir][1];
						String chekchek = board[useri][userj];
						break;
					}
					break;
				case "L":
					userdir = 2;
					ni = ni + dir_xy[userdir][0];
					nj = nj + dir_xy[userdir][1];
					board[useri][userj] = dir[userdir][1];
					if (ni < 0 || nj < 0 || ni >= fi || nj >= fj) {
						
						
						break;
					}
					else if (board[ni][nj].equals(".")) {
						board[useri][userj] = ".";
						useri = ni;
						userj = nj;
						
						board[useri][userj] = dir[userdir][1];
						break;
					}
					break;
				case "R":
					userdir = 3;
					ni = ni + dir_xy[userdir][0];
					nj = nj + dir_xy[userdir][1];
					board[useri][userj] = dir[userdir][1];
					if (ni < 0 || nj < 0 || ni >= fi || nj >= fj) {
						
						break;
					}
					else if (board[ni][nj].equals(".")) {
						board[useri][userj] = ".";
						useri = ni;
						userj = nj;
						board[useri][userj] = dir[userdir][1];
						break;
					}
					break;
				}

				
				 
				

			}
			System.out.print("#" + tc + " ");
			for (int m = 0; m < fi; m++) {
				for (int l = 0; l < fj; l++) {
					System.out.print(board[m][l]);
				}
				System.out.println();
			}
		}

	}
}
