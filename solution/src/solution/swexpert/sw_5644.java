package solution.swexpert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class BC {
	int x;
	int y;
	int C;
	int P;
	int distanceA;
	int distanceB;

	public BC(int i, int j, int c, int p) {
		super();
		this.x = j;
		this.y = i;
		C = c;
		P = p;
	}

}

public class sw_5644 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("res/input_5644.txt"));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int M = Integer.parseInt(st.nextToken());// 총 이동시간
			int A = Integer.parseInt(st.nextToken());// BC의 개수
			String personA = in.readLine();
			String personB = in.readLine();
			int person[][] = { { 0, 0 }, { 9, 9 } };
			int ap = 0;//a의 총 충전량
			int bp = 0;//b의 총 충전량
			
			
			StringTokenizer a = new StringTokenizer(personA, " ");
			StringTokenizer b = new StringTokenizer(personB, " ");
			BC[] bc = new BC[A];
			int dir[][] = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
			for (int i = 0; i < A; i++) {
				s = in.readLine();
				st = new StringTokenizer(s, " ");
				bc[i] = new BC(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				//System.out.println(bc[i]);
			}

			for (int i = 0; i <= M; i++) {
				int plusap = 0;
				int plusbp = 0;
				int[][] accessA = new int[A][2];
				int[][] accessB = new int[A][2];
				for (int k = 0; k < A; k++) {
					bc[k].distanceA = Math.abs(bc[k].x - person[0][0]) + Math.abs(bc[k].y - person[0][1]);
					bc[k].distanceB = Math.abs(bc[k].x - person[1][0]) + Math.abs(bc[k].y - person[1][1]);
					if (bc[k].distanceA <= bc[k].C) {
						accessA[k][0] = bc[k].P;
						accessA[k][1] = k+1;
					}
					if (bc[k].distanceB <= bc[k].C) {
						accessB[k][0] = bc[k].P;
						accessB[k][1] = k+1;
					}
				}
				
				Arrays.sort(accessA,new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						return o2[0]-o1[0];
					}
				});
				Arrays.sort(accessB,new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						return o2[0]-o1[0];
					}
				});
				
				if(accessA[0][1]!=accessB[0][1]) {
					plusap = accessA[0][0];
					plusbp = accessB[0][0];
				}else {
					if(A==1||(accessA[1][0]==0 && accessB[1][0] ==0)) {
						plusap = accessA[0][0]/2;
						plusbp = accessA[0][0]/2;
					}else if(accessA[1][0]>accessB[1][0]) {
						plusap = accessA[1][0];
						plusbp = accessB[0][0];
					}else {
						plusap = accessA[0][0];
						plusbp = accessB[1][0];
					}
				}
				
				ap += plusap;
				bp += plusbp;
				
				if(i==M) break;
				int adir = Integer.parseInt(a.nextToken());
				int bdir = Integer.parseInt(b.nextToken());
				person[0][0] += dir[adir][0];
				person[0][1] += dir[adir][1];
				person[1][0] += dir[bdir][0];
				person[1][1] += dir[bdir][1];
				
				
			}
			
			sb.append(ap+bp).append("\n");
		}
		System.out.println(sb.toString());
	}
}
