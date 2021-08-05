package solution.swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_1873_02 {

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
			char[][] board = new char[fi][fj];

			int useri = 0;
			int userj = 0;
			int userdir = 0;

			char[][] dir = new char[][] { { 'U', '^' }, { 'D', 'v' }, { 'L', '<' }, { 'R', '>' } };
			for (int i = 0; i < fi; i++) {
				String line = in.readLine();
				for (int j = 0; j < fj; j++) {
					board[i][j] = line.charAt(j);
					if (board[i][j]=='.' || board[i][j]=='*' || board[i][j]=='#' || board[i][j]=='-' )
						continue;

					for (int k = 0; k < dir.length; k++) {
						if (board[i][j]==dir[k][1]) {
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

			int dir_xy[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
			// 보드 설정
			for (int i = 0; i < count; i++) {
				char man = check.charAt(i);
				
				int ni = useri;
				int nj = userj;
				if (man=='S') {
					while (true) {

						ni = ni + dir_xy[userdir][0];
						nj = nj + dir_xy[userdir][1];
						if (ni < 0 || nj < 0 || ni >= fi || nj >= fj)
							break;
						else if (board[ni][nj]=='*') {
							board[ni][nj] = '.';
							break;
						} else if (board[ni][nj]=='#')
							break;
					}
				}else {
					for(int m=0; m<dir.length; m++) {
						if(man==dir[m][0]) userdir = m;
					}
					ni = ni + dir_xy[userdir][0];
					nj = nj + dir_xy[userdir][1];
					board[useri][userj] = dir[userdir][1];
					if (ni < 0 || nj < 0 || ni >= fi || nj >= fj) {
					}
					else if  (board[ni][nj]=='.') {
						board[useri][userj] = '.';
						useri = ni;
						userj = nj;
						
						board[useri][userj] = dir[userdir][1];
					}				
				}		
			}
			for (int m = 0; m < fi; m++) {
				for (int l = 0; l < fj; l++) {
					sb.append(board[m][l]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());

	}
}
