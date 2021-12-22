package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Nodee implements Comparable<Nodee>{
	int i;
	int j;
	int dis;
	public Nodee(int i, int j, int dis) {
		super();
		this.i = i;
		this.j = j;
		this.dis = dis;
	}
	@Override
	public int compareTo(Nodee o) {
		return this.dis - o.dis;
	}
	
}
public class s1_2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = in.readLine();
			char[] c = s.toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = c[j];
			}
		}
		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		PriorityQueue<Nodee> pq = new PriorityQueue<Nodee>();
		Nodee n = new Nodee(0,0,1);
		pq.add(n);
		int answer=0;
		while(!pq.isEmpty()) {
			Nodee cur = pq.poll();
			if(cur.i==N-1&&cur.j==M-1) {
				answer = cur.dis;
				break;
			}
			for(int d=0; d<4; d++) {
				int ni = cur.i+dir[d][0];
				int nj = cur.j+dir[d][1];
				if(ni>=0 && nj>=0 && ni<N && nj<M && arr[ni][nj]=='1') {
					pq.add(new Nodee(ni,nj,cur.dis+1));
					arr[ni][nj]='0';
				}
				
			}
		}
		System.out.println(answer);
		
	}
}
