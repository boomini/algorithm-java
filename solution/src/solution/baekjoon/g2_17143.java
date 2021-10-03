package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class shark implements Comparable<shark>{
	int r;//»ó¾î xÁÂÇ¥
	int c;//»ó¾î yÁÂÇ¥
	int s;//¼Ó·Â
	int d;//ÀÌµ¿¹æÇâ
	int z;//Å©±â
	public shark(int r, int c, int s, int d, int z) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
	@Override
	public int compareTo(shark o) {
		// TODO Auto-generated method stub
		return this.z-o.z;
	}
	
}
public class g2_17143 {
	private static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[R][N];
		int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
		ArrayList<shark> sh = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine(), " ");	
			int r = Integer.parseInt(st.nextToken())-1;//xÁÂÇ¥
			int c = Integer.parseInt(st.nextToken())-1;//yÁÂÇ¥
			visited[r][c] = true;
			sh.add(new shark(r,c,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<R; j++) {
				if(visited[j][i]) {
					remove(i,j,sh);
				}
			} 
			Collections.sort(sh);
			visited = new boolean[R][N];
			for(int j=0; j<sh.size(); j++) {
				int nx = dir[sh.get(i).d][0]*sh.get(i).r;
				int ny = dir[sh.get(i).d][1]*sh.get(i).c;
				while(nx>=0 && ny>=0 && nx<R && nx<N) {
					if(nx>=0 && ny>=0 && nx<R && nx<N) {
						if(visited[nx][ny]) remove(nx,ny,sh);
						else visited[nx][ny]=true;
						break;
					}
				}
							
			}
			for(int l=0; l<N; l++) {
				for(int m=0; m<R; m++) {
					
				}
			}
		}
	}

	private static int changedir(int d) {
		if(d==1)return 2;
		else if(d==2)return 1;
		else if(d==3) return 4;
		else if(d==4) return 3;
		return -1;
	}

	private static void remove(int x, int y, ArrayList<shark> sh) {
		for(int i=0; i<sh.size(); i++) {
			if(sh.get(i).r==x && sh.get(i).c==y) sh.remove(i);	
		}
	}
	
	
}
