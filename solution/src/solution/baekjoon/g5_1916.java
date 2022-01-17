package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_1916 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		//도시의 개수
		int M = Integer.parseInt(in.readLine());
		//버스의 개수
		int arr[][] = new int[N+1][N+1];
		int distance[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			//첫번째는 출발도시의 번호, 도착지의 도시번호, 버스비용
			if(arr[start][end]!=-1) {
				arr[start][end] = Math.min(arr[start][end], val);
				//출발점과 도착점이 같은 버스가 여러대일경우 최소값을 받는다.
			}else {
				arr[start][end] = val;
			}
		}
		StringTokenizer st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		//초기값 설정
		int min = Integer.MAX_VALUE;
		int current = 0;
		outer : for(int i=1; i<=N; i++) {
			min = Integer.MAX_VALUE;
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			for(int j=1; j<=N; j++) {
				if(!visited[j]&&distance[j]<min) {
					min = distance[j];
					current = j; 
				}
			}
			
			visited[current] = true;
			if(current==end) {
				break outer;
			}
			//b단계 : current정점을 경유지로 하여 갈 수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int k=1; k<=N; k++) {
				if(!visited[k] && arr[current][k] != -1 && distance[k] > min+arr[current][k]) {
					distance[k] = min + arr[current][k];
 				}
			}
		}
		
		
		System.out.println(distance[end]);
		
	}
}
