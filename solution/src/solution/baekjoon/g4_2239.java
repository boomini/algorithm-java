package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_2239 {
	private static int arr[][];
	private static ArrayList<int[]> list = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		
		for(int i=0; i<9; i++) {
			String s = in.readLine();
			for(int j=0; j<9; j++) {
				arr[i][j] = s.charAt(j)-'0';
				if(arr[i][j]==0) list.add(new int[] {i,j});
			}
			
		}
		
		check(0);
	}

	private static void check(int index) {
		int i = list.get(index)[0];
		int j = list.get(index)[1];
		boolean row[] = new boolean[9];
		boolean col[] = new boolean[9];
		boolean squ[] = new boolean[9];
		
		for(int k=0; k<9; k++) {
			int cr = arr[i][k];
			int cc = arr[k][j];
			int cs = arr[i+k/3][j+k%3];
			
			if(row[cr] || col[cc] || squ[cs])return;

			row[cr] = true;
			col[cc] = true;
			squ[cs] = true;
		}
		
		
	}
	
	
}
