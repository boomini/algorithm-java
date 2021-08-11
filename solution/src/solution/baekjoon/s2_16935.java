package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_16935 {
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr;
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			s = in.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		s = in.readLine();
		st = new StringTokenizer(s, " ");

		for (int i = 0; i < R; i++) {
			int r = Integer.parseInt(st.nextToken());
			if(r==1) {
				array1(arr);
			}else if(r==2) {
				array2(arr);
			}else if(r==3) {
				arr = array3(arr).clone();
				int temp = N;
				N = M;
				M = temp;
			}else if(r==4) {
				arr = array4(arr).clone();
				int temp = N;
				N = M;
				M = temp;
			}else if(r==5) {
				arr = array5(arr).clone();
			}else if(r==6) {
				arr = array6(arr).clone();
			}

		}
		for(int l=0; l<arr.length; l++) {
			for(int j =0; j<arr[l].length; j++) {
				System.out.print(arr[l][j] + " ");
			}
			System.out.println();
		}
	}

	

	private static void array1(int[][] arr) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N / 2; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[N - j - 1][i];
				arr[N - j - 1][i] = temp;
			}
		}

	}

	private static void array2(int[][] arr) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M - j - 1];
				arr[i][M - j - 1] = temp;
			}
		}
	}

	private static int[][] array3(int[][] arr) {
		int arr2[][] = new int[M][N];
		int m = 0;
		for (int i = N - 1; i >= 0; i--) {
			int l = 0;
			for (int j = 0; j < M; j++) {
				int num = arr[i][j];
				arr2[l++][m] = num;
			}
			m++;
		}
		return arr2;

	}

	private static int[][] array4(int[][] arr) {
		int arr2[][] = new int[M][N];
		int l = 0;
		for(int i=0; i<N; i++) {
			int m = M-1;
			for(int j=0; j<M; j++) {
				int num = arr[i][j];
				arr2[m--][l]=num;
			}
			l++;
		}
		return arr2;

	}
	
	private static int[][] array5(int[][] arr) {
		int arr2[][] = new int [N][M];
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				arr2[i][j] = arr[N/2 + i][j];
			}
		}
		for(int i=0; i<N/2; i++) {
			for(int j=M/2; j<M; j++) {
				arr2[i][j] = arr[i][j-M/2];
			}
		}
		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				arr2[i][j] = arr[i][j+M/2];
			}
		}
		for(int i=N/2; i<N; i++) {
			for(int j=M/2; j<M; j++) {
				arr2[i][j] = arr[i-N/2][j];
			}
		}
		return arr2;
		
	}
	
	private static int[][] array6(int[][] arr) {
		int arr2[][] = new int [N][M];
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				arr2[i][j] = arr[i][j + M/2];
			}
		}
		for(int i=0; i<N/2; i++) {
			for(int j=M/2; j<M; j++) {
				arr2[i][j] = arr[N/2 + i][j];
			}
		}
		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				arr2[i][j] = arr[i-N/2][j];
			}
		}
		for(int i=N/2; i<N; i++) {
			for(int j=M/2; j<M; j++) {
				arr2[i][j] = arr[i][j-M/2];
			}
		}
	
		return arr2;	
	}
}
