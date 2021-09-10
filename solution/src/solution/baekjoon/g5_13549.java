package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
     원래 이 문제는 단순한 BFS를 요구하는 문제가 아닙니다. 왜냐하면, BFS를 하기 위해서는 모든 간선의 가중치가 동일해야 한다는 전제 조건이 필요하기 때문입니다. 이 문제는 가중치가 0인 간선이 있기 때문에 일반적으로는 단순한 BFS를 쓸 수 없으나, 문제의 특성 때문에 방문 순서에 따라서 단순 BFS로도 우연히도 항상 정답을 찾을 수 있을 뿐입니다. 왜 하필 이 순서로 하면 항상 정답이 나오는가를 증명하는 건 매우 복잡한 일입니다.

     이 문제를 보다 일반화된 경우 (가중치가 0인 간선이 있는 경우)에 대해 해결하려면, 즉, 이 문제의 의도대로 풀려면 다음과 같은 방법들을 사용할 수 있습니다.

* 다익스트라 알고리즘
* 0-1 BFS: 가중치가 0인 간선에 연결된 정점은 큐의 맨 뒤가 아닌 맨 앞에 넣는 방법
* 2를 별도의 간선으로 생각하지 않고, +1이나 -1에 의한 좌표를 큐에 넣을 때 그 좌표의 2의 거듭제곱 배인 좌표들을 전부 큐에 넣는 방법
 */
public class g5_13549 {
	private static boolean isVisited[]= new boolean[100001];
	private static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(bfs(N));
	}

	private static int bfs(int index) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{index,0});
		
		while(!queue.isEmpty()) {
			int x;
			int weight;
			
			x = queue.peek()[0];
			weight = queue.peek()[1];
			queue.poll();
			
			if(x==K) {
				return weight;
			}
			isVisited[x] = true;
			int n1 = x*2;
			int n2 = x+1;
			int n3 = x-1;
			if(n1<=100000&&!isVisited[n1]) {
				queue.add(new int[] {n1,weight});
			}
			if(n3>=0&&!isVisited[n3]) {
				queue.add(new int[] {n3,weight+1});
			}
			if(n2<=100000&&!isVisited[n2]) {
				queue.add(new int[] {n2,weight+1});
			}
			
					
		}
		return 0;
	}
}
