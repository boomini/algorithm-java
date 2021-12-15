package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class go{
	int x;
	int y;
	int d;
	int g;
	public go(int x, int y, int d, int g) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
		this.g = g;
	}
	
}
public class g4_15685 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<go> arr = new ArrayList<go>();
		boolean check[][] = new boolean[101][101];
		int dir[][] = {{0,1},{-1,0},{0,-1},{1,0}};
		//0,1,2,3(©Л,╩С,аб,го)
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			go cur = new go(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			ArrayList<int[]> curar = new ArrayList<>();
			curar.add(new int[] {cur.y+dir[cur.d][0], cur.x+dir[cur.d][1], cur.d});
			check[cur.y][cur.x] = true;
			check[cur.y+dir[cur.d][0]][cur.x+dir[cur.d][1]]=true;
			int ni = cur.y+dir[cur.d][0];
			int nj = cur.x+dir[cur.d][1];
			for(int j=1; j<=cur.g; j++) {
				int size = curar.size();
				
				for(int l=size-1; l>=0; l--) {
					int[] curi = curar.get(l);
					int nd = (curi[2]+1)%4;
					ni = ni+dir[nd][0];
					nj = nj+dir[nd][1];
					curar.add(new int[] {ni,nj,nd});
					
					check[ni][nj] = true;
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(check[i][j]&&check[i+1][j]&&check[i][j+1]&&check[i+1][j+1]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
