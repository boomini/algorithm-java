package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g4_17281 {
	private static boolean visited[] = new boolean[9];
	private static int num[] = new int[9];
	private static int arr[][];
	private static int max=0;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][9];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<9; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(0);
		System.out.println(max);
		
	}

	private static void permutation(int cnt) {
		if(cnt==9) {
			int score = game(num);
			max = Math.max(score, max);
			
		}
		if(cnt==3) {
			permutation(cnt+1);
		}
		else {
			for(int i=1; i<9; i++) {
				if(visited[i]) continue;
				num[cnt] = i;
				visited[i] = true;
				permutation(cnt+1);
				visited[i] = false;
			}	
		}
		
		
	}

	private static int game(int[] num) {
		boolean ru[];
		int out = 0;
		int score = 0;
		int j=0;
		for(int i=0;i<N; i++) {
			ru= new boolean[3];
			out = 0;
			while(true) {
				if(j==9) {
					j=0;
				}
				int result = arr[i][num[j]];
				if(result==0) out++;
				if(out==3) {
					j++;
					break;			
				}
				else if(result==1) {//안타
					if(ru[2]) {
						score++;
						ru[2] = false;
					}
					if(ru[1]) {
						ru[1] = false;
						ru[2] = true;
					}
					if(ru[0]) {
						ru[0] = false;
						ru[1] = true;
					}
					ru[0] = true;
				}else if(result==2) {//2루타
					if(ru[2]) {
						score++;
						ru[2] = false;
					}
					if(ru[1]) {
						score++;
						ru[1] = false;
					}
					if(ru[0]) {
						ru[0] = false;
						ru[2] = true;
					}
					ru[1] = true;
				}else if(result==3) {//3루타
					if(ru[2]) {
						score++;
						ru[2] = false;
					}
					if(ru[1]) {
						score++;
						ru[1] = false;
					}
					if(ru[0]) {
						score++;
						ru[0] = false;
					}
					ru[2] = true;
 				}else if(result==4) {
					if(ru[2]) {
						score++;
						ru[2] = false;
					}
					if(ru[1]) {
						score++;
						ru[1] = false;
					}
					if(ru[0]) {
						score++;
						ru[0] = false;
					}
					score++;
				}
				
			j++;
			
			}
		}
		return score;
	}

}
