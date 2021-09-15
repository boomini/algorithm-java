package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g5_2636 {
	private static int N;
	private static int R;
	private static int arr[][];
	private static Queue<int[]> queue;
	private static int dx[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][R];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<R; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		queue = new LinkedList<>();
		
		for(int i=0; i<R; i++) {
			queue.add(new int[] {0,i});
			arr[0][i] = -1;
			queue.add(new int[] {N-1,i});
			arr[N-1][i] = -1;
			cnt+=2;
		}
		for(int i=1; i<N-1; i++) {
			queue.add(new int[] {i,0});
			arr[i][0] = -1;
			queue.add(new int[] {i,R-1});
			arr[i][R-1] = -1;
			cnt+=2;
		}
		int answer=0;
		int pc = 0;
		outer : while(true) {
			BFS();
			//System.out.println(cnt);
			if(cnt==R*N) break;
			boolean chk = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<R; j++) {
					if(arr[i][j]==1) {
						if(!chk) pc = 0;
						chk = true;
						for(int d=0; d<4; d++) {
							int nx = i+dx[d][0];
							int ny = j+dx[d][1];
							if( nx>=0&& nx<N&& ny>=0&&ny <R && arr[nx][ny] ==-1) {
								//arr[i][j] = -1;
								queue.add(new int[] {i,j});
								pc++;
								break;
							}
						}
					}
					
				}
			}
			if(cnt==R*N) break outer;
			answer++;
		}
		
		System.out.println(answer);
		System.out.println(pc);
		
		
	}

	private static void BFS() {
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			queue.poll();
			if(arr[x][y]!=-1) {
				arr[x][y] = -1;
				cnt++;
			}
			for(int i=0; i<4; i++) {
				int nx = x+dx[i][0];
				int ny = y+dx[i][1];
				if( nx>=0&& nx<N&& ny>=0&&ny <R && arr[nx][ny] ==0) {
					queue.add(new int[] {nx, ny});
					arr[nx][ny] = -1;
					cnt++;
				}
			}
			
		}
		
	}
}
