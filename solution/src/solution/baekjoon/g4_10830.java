package solution.baekjoon;

import java.util.Scanner;

public class g4_10830 {
	static int T = 1000;
	static int[][] m;
	static int N;
	static long B;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		B = scanner.nextLong();
		m = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				m[i][j] = scanner.nextInt()%T;
			}
		}
		
		//·ÎÁ÷
		int[][] mm = matrxi(B);
		for(int i=0; i<N; i++) {
			for(int j =0;j<N; j++) {
				System.out.print(mm[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] matrxi(long y) {
		int[][] res = new int[N][N];
		for(int i=0; i<N; i++) {
			res[i][i] = 1;
		}
		while(y>0L) {
			if(y%2==1L) {
				res=mul(res,m);
			}
			y/=2L;
			m = mul(m,m);
		}
		return res;
	}

	private static int[][] mul(int[][] r, int[][] x) {
		int[][] res = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int t=0;
				for(int k=0; k<N; k++) {
					t= (t%T + (r[i][k] * x[k][j])%T)%T;
				}
				res[i][j] = t%T;
			}
		}
		return res;
	}
}
