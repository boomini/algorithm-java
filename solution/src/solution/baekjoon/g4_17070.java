package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P{
	int x;
	int y;
	int type;
	public P(int x, int y, int type) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
		//0: 가로, 1: 세로, 2: 대각선
	}
}
public class g4_17070 {
	
	private static int cnt; 
	private static int N;
	private static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr= new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(arr[N-1][N-1]==1) {
			cnt=0;
			// 목적지가 1인 경우  cnt불가;
			// 이거 안해서 시간초과남..ㅠ
		}else {
			BFS();
		}
		
		System.out.println(cnt);
	}

	private static void BFS() {
		Queue<P> q = new LinkedList<P>();
		q.add(new P(0,1,0));
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int type = q.peek().type;
			q.poll();
			if(x==N-1&&y==N-1) {
				cnt++;
				continue;
			}

			if(type==0) {//가로
				//가로
				if(check(x, y+1)) {
					q.add(new P(x,y+1,0));
				};
				//대각선
				if(check(x,y+1)&&check(x+1,y)&&check(x+1,y+1)) {
					q.add(new P(x+1,y+1,2));
				}
				
			}else if(type==1) {//세로
				//세로
				if(check(x+1,y)) {
					q.add(new P(x+1,y,1));
				}
				//대각선
				if(check(x,y+1)&&check(x+1,y)&&check(x+1,y+1)) {
					q.add(new P(x+1,y+1,2));
				}
			}else {//대각선
				//가로
				if(check(x, y+1)) {
					q.add(new P(x,y+1,0));
				};
				//세로
				if(check(x+1,y)) {
					q.add(new P(x+1,y,1));
				}
				//대각선
				if(check(x,y+1)&&check(x+1,y)&&check(x+1,y+1)) {
					q.add(new P(x+1,y+1,2));
				}
			}
		}
		
	}

	private static boolean check(int x, int y) {
		if(x>=0 && y >= 0 && y<N && x<N && arr[x][y]==0) {
			
			return true;
		}
		return false;
	}
}
