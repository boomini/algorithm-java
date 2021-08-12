package solution.swexpert;

import java.io.FileInputStream;
import java.util.Scanner;

public class d2_1974 {
	static int[][] a = new int[9][9];

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input_d2_1974.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int check = 1;
			for (int i = 0; i < 9; i++) {
				int sum = 0;
				for (int j = 0; j < 9; j++) {
					sum += arr[i][j];
				}
				if (sum != 45) {
					check = 0;
					break;
				}
			}

			if (check == 1) {
				for (int j = 0; j < 9; j++) {
					int sum = 0;
					for (int i = 0; i < 9; i++) {
						sum += arr[i][j];
					}
					if (sum != 45) {
						check = 0;
						break;
					}
				}
			}
			if (check == 1) {
				
				forcheck: for (int l = 0; l < 3; l++) {
					int starti = l*3;
					
					for (int m = 0; m < 3; m++) {
						int startj = m*3;
						int sum = 0;
						for (int i = 0; i < 3; i++) {
							
							for (int j = 0; j < 3; j++) {
								sum += arr[i+starti][j + startj];
							}
							
						}
						if (sum != 45) {
							check = 0;
							break forcheck;
						}
					}
				}

			}
			System.out.println("#" + tc + " " + check);
			
		}
		sc.close();
	}
}
