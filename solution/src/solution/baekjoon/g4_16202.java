package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_16202 {

	//97% 실패
	//
	static class Node implements Comparable<Node>{
		int n;
		int weight;
		Node node;

		public Node(int n, int weight, Node node) {
			super();
			this.n = n;
			this.weight = weight;
			this.node = node;
		}

		@Override
		public String toString() {
			return "Node [n=" + n + ", weight=" + weight + ", node=" + node + "]";
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}
 
		private static Node[] adjlist;
		private static boolean[] isVisited;
		private static int N;
		public static void main(String[] args) throws IOException {
			// 주어진대로 가중치를 의미한다.(가중치가 작은것부터 자르기때문에 앞에서부터 자른다)
			// 프림 알고리즘
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			adjlist = new Node[N];
			int list[][] = new int[M][2];
			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				list[i-1][0] = from;
				list[i-1][1] = to;
				//다음 턴을 위한 간선 저장
				
				adjlist[to] = new Node(from, i, adjlist[to]);
				adjlist[from] = new Node(to, i, adjlist[from]);
			}

			//System.out.println(Arrays.deepToString(adjlist));
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<k; i++) {
				//System.out.println(Arrays.deepToString(adjlist));
				int num = prim(0);
				if(num==0) {
					while(i<k) {
						sb.append(num).append(" ");
						i++;
					}
					break;
				}
				sb.append(num).append(" ");
				deletenode(list[i][0], list[i][1]);
			}
			
			System.out.println(sb.toString());
		}

		private static void deletenode(int from , int to) {
			int index=0;
			for(Node node = adjlist[to]; node!=null ; node= node.node){
				if(node.n==from) {
					Node beforenode = adjlist[to];
					if(index == 0) {
						node = node.node;
						break;
					}else {
						for(int i=0; i<index-1; i++) {
							beforenode = beforenode.node;
						}
						if(beforenode.node.node==null) {
							beforenode.node=null;
						}else {
							beforenode.node = beforenode.node.node;
						}
						break;
					}
					
					
				}
				index++;
			}
			
			index = 0;
			for(Node node = adjlist[from]; node!=null ; node= node.node){
				if(node.n==to) {
					Node beforenode = adjlist[from];
					if(index == 0) {
						node = node.node;
						break;
					}else {
						for(int i=0; i<index-1; i++) {
							beforenode = beforenode.node;
						}
						if(beforenode.node.node==null) {
							beforenode.node=null;
						}else {
							beforenode.node = beforenode.node.node;
						}
						break;
					}
					
					
				}
				index++;
			}
		}

		private static int prim(int index) {
			PriorityQueue<Node> queue =  new PriorityQueue<Node>();
			isVisited = new boolean[N];
			int sum = 0;
			
			queue.add(new Node(index, 0, adjlist[index]));

			
			while(!queue.isEmpty()) {
				Node check = queue.poll();
				if(isVisited[check.n]) continue;
				isVisited[check.n] = true;
				sum+=check.weight;
				for(Node node = adjlist[check.n]; node!=null; node=node.node) {
					if(!isVisited[node.n]) {
						queue.add(node);
					}
				}
				
			}
			for(int i=0; i<N; i++) {
				if(!isVisited[i]) return 0;
			}
			return sum;
		}
	}

