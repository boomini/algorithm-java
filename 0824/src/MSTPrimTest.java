import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MSTPrimTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); 
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		
		int[] minEdge = new int[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0; //최소신장트리비용
		minEdge[0] = 0; //임의의 시작점 0의 간선비용을 0으로 세팅.
		
		for(int i=0; i<N; i++) {
			//1. 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기.
			int min = Integer.MAX_VALUE;
			int minVertex = -1; //최소간선비용의 정점 번호
			for(int j=0; j<N; j++) {
				if(!visited[j]&&min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
				
			}
			visited[minVertex] = true; //신장트리에 포함시킴
			result += min;
			//2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
			for(int j=0; j<N;j++) {
				if(!visited[j]&&adjMatrix[minVertex][j]!=0&&adjMatrix[minVertex][j]<minEdge[j]) {
					minEdge[j]= adjMatrix[minVertex][j];
				}
				
			}
		}
		System.out.println(result);
	}
}
