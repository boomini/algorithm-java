package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g4_17406 {
	private static int count = 0; // 순열결과값개수
	private static int indexarray[];
	private static int R; // 구해야하는 순열개수
	private static boolean[] isSelected;
	private static int N;
	private static int M;
	private static int array[][];
	private static int r[][];
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		isSelected = new boolean[R + 1];
		indexarray = new int[R];
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = in.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		r = new int[R][3];

		for (int i = 0; i < R; i++) {
			s = in.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < 3; j++) {
				r[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permutation(0);
		System.out.println(min);

	}

	public static void permutation(int cnt) {
		if (cnt == R) {
			//System.out.println(Arrays.toString(indexarray));
			rotation(indexarray);
			return;
		}
		for (int i = 1; i <= R; i++) {
			if (isSelected[i])
				continue;

			indexarray[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);

			isSelected[i] = false;

		}

	}

	private static void rotation(int[] indexarray) { // 회전시켜주는 함수
		int[][] arrcopy = new int[array.length][array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				arrcopy[i][j] = array[i][j];
			}
		}
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		for (int k = 0; k < indexarray.length; k++) {
			int x = r[indexarray[k] - 1][0];
			int y = r[indexarray[k] - 1][1];
			int z = r[indexarray[k] - 1][2];
			int startX = x - z - 1;// 시작지점 x
			int startY = y - z - 1;// 시작지점 y
			int endX = x + z - 1;// 시작지점 x
			int endY = y + z - 1;// 시작지점 y

			int circle = Math.min(endX - startX + 1, endY - startY + 1) / 2;
			for (int c = 0; c < circle; c++) {
				int idir = 0;
				int sX = startX + c;
				int sY = startY + c;
				int eX = endX - c;
				int eY = endY - c;
				int i = sX;
				int j = sY;
				int temp = arrcopy[sX][sY];
				while (idir < 4) {
					int nx = i + dir[idir][0];
					int ny = j + dir[idir][1];

					if (nx >= sX && ny >= sY && nx <= eX && ny <= eY) {
						int temp2 = arrcopy[nx][ny];
						arrcopy[nx][ny] = temp;
						temp = temp2;
						i = nx;
						j = ny;
					} else {
						idir++;
					}
					
				}
				
			}
//			for(int l=0; l<arrcopy.length; l++) {
//				for(int n=0; n<arrcopy[l].length; n++) {
//					System.out.print(arrcopy[l][n] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		for (int i = 0; i < arrcopy.length; i++) {
			int sum = 0;
			for (int j = 0; j < arrcopy[i].length; j++) {
				sum += arrcopy[i][j];
			}
			if (sum < min)
				min = sum;
		}

	}
}
