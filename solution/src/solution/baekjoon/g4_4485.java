package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g4_4485  {
	static class Vertex implements Comparable<Vertex>{
		int i;
		int dis;
		public Vertex(int i, int dis) {
			super();
			this.i = i;
			this.dis = dis;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.dis-o.dis;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int problem = 1;
		while(true) {		
			int N = Integer.parseInt(in.readLine());
			if(N==0) break;
			sb.append("Problem ").append(problem).append(": ");
			int start = 0;
			int end = N*N - 1;
			int a[][] = new int[N][N];
			int distance[] = new int[N*N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int j=0; j<N; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
			
			distance[start] = 0;
			pq.add(new Vertex(start, a[start][start]));
			int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};//╩С,го,©Л,аб
			while(!pq.isEmpty()) {
				Vertex cur = pq.poll();
				int index = cur.i;
				if(index==end) break;
				int indexi = index/N;
				int indexj = index%N;
				for(int i =0; i<4; i++) {
					int ni = indexi + dir[i][0];
					int nj = indexj + dir[i][1];
					if(ni>=0 && nj>= 0 && ni <N && nj < N) {
						int num = cur.dis+a[ni][nj];
						if(num<distance[ni*N + nj]) {
							distance[ni*N + nj]=num;
							pq.add(new Vertex(ni*N+nj,num));
						}
					}
					else continue;
				}
			}
			sb.append(distance[end]).append("\n");
			problem++;
		}
		
		System.out.println(sb.toString());
		
	}
}
