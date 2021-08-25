package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_16236 {
	/*아기상어 초기크기 = 2
	자신보다 작은 물고기만 먹을 수 있다.
	물고기를 자신의 크기만큼 먹으면 크기+1
	자신과 크기가 같은 물고기는 먹을 수 없지만 지나갈 수 있다.
	더이상 먹을 수 있는 물고기가 공간에 없으면 엄마 상어에게 도움요청.
	먹을 수 있는 물고기중 거리가 가장 가까운 물고기, 그중 가장 위에 있는 물고기, 그중 가장 왼쪽에 있는 물고기 
	아기상어는 이동시 1초
	물고기를 먹으면 빈칸이 된다.
	몇초안에 가능한 물고기를 잡아먹을 수 있나
	
	1. 들어오는 물고기 sorting하고
	2. 현재 가능한 물고기 계속 체크
	*/ 
	private static int N;
	private static int arr[][];
	private static int babyI;
	private static int babyJ;
	private static int result;
	private static int babySize;
	private static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		babyI = 0;
		babyJ = 0;
		babySize = 2;
		result = 0;
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==9) {
					babyI = i;
					babyJ = j;
				}
				arr[i][j] = num;
			}
		}
		int cnt = 0;
		while(true) {
			if(BFS()) {
				//System.out.println(babyI + " " + babyJ + " " + babySize + " " + result);
				cnt++;
				if(cnt==babySize) {
					babySize+=1;
					cnt=0;
				}
				continue;
			}
			break;
		}
		System.out.println(result);
		
	}

	private static boolean BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {babyI, babyJ, 0});
		arr[babyI][babyJ] = 0;
		int minSecond = Integer.MAX_VALUE;
		int minI = Integer.MAX_VALUE;
		int minJ = Integer.MAX_VALUE;
		int dx[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		boolean flag = false;
		visited= new boolean[N][N];
		while(!queue.isEmpty()) {
			int currentI = queue.peek()[0];
			int currentJ = queue.peek()[1];
			int currentSecond = queue.peek()[2];
			if(currentSecond>minSecond) break;
			queue.poll();
			
			
			int fishSize = arr[currentI][currentJ];
			if(fishSize!=0&&fishSize<babySize) {
				flag = true;
				if(minSecond>currentSecond) {
					minSecond = currentSecond;
					minI = currentI;
					minJ = currentJ;
				}else if(minSecond==currentSecond) {
					if(minI>currentI) {
						minI = currentI;
						minJ = currentJ;
					}else if(minI==currentI) {
						if(minJ>currentJ) {
							minJ = currentJ;
						}
					}
				}
			}
			for(int i=0; i<4; i++) {
				int ni = currentI + dx[i][0];
				int nj = currentJ + dx[i][1];
				if(ni>=0 && nj >=0 && ni <N && nj<N && !visited[ni][nj] && arr[ni][nj]<=babySize) {
					visited[ni][nj] = true;
					//!!!!중요!!!!! 꼭 들어갈때 방문처리해주자!
					queue.add(new int[] {ni, nj, currentSecond+1});
				}
			}
			
		}
		
		if(flag) {
			babyI = minI;
			babyJ = minJ;
			result+=minSecond;
		}
		
		
		return flag;
		
	}
}
