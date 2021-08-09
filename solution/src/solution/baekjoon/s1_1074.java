package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//완전탐색으로 풀었더니 시간초과 발생.

public class s1_1074 {
	private static int count = 0;
	private static int N;
	private static int r;
	private static int c;
	private static int[][] value;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int num = (int)(Math.pow(2, N));
		int i=0;
		int j=0;
		
		//해당되지 않아 리턴되었을때, 다음재귀값으로 행해지기 위해
		search(i,j,num/2);
		search(i,j+num/2,num/2);
		search(i+num/2,j,num/2);
		search(i+num/2,j+num/2,num/2);
		
	}
	
	private static void search(int i,int j, int cnt) {
		if(cnt==1) {
			if(i==r && j==c) {
				System.out.println(count);
				System.exit(0);
			}
			//System.out.println(i+" " + j + " " + count);
			count++;
			return;
		}
		if(!((r>=i && (i+cnt>r)) && (c>=j && (j+cnt>c)))) {
			count+=cnt*cnt;
			return;
		}// count값을 먼저 계산해서 행과 열이 그 안에 속하면 재귀를 돌리고 아니면 count에 행과 열 개수만큼 더해주고 리턴한다.
		
		
		search(i,j,cnt/2);
		search(i,j+cnt/2,cnt/2);
		search(i+cnt/2,j,cnt/2);
		search(i+cnt/2,j+cnt/2,cnt/2);	

	}
}
