package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int index;
	ArrayList<Integer> node;
	public Node(int index,int num) {
		super();
		this.index = index;
		node = new ArrayList<Integer>();
		node.add(num);
	}
	
	public void add(int num) {
		node.add(num);
	}
		
}
public class d4_1238 {
	private static int N;
	private static int start;
	private static ArrayList<Node> arr;
	private static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			arr = new ArrayList<>();
			s = in.readLine();
			max = 0;
			st = new StringTokenizer(s, " ");
			outer : for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int num = Math.max(from, to);
				max = Math.max(max, num);
				for(int j=0; j<arr.size(); j++) {
					if(arr.get(j).index==from) {
						arr.get(j).add(to);
						continue outer;
					}
				}
				arr.add(new Node(from, to));
				
			}
			sb.append(bfs()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int bfs() {

		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		boolean[] visited = new boolean[max+1];
		queue.offer(new Integer[] {start,1});
		visited[start] = true;
		int hier = 1;
		int max2 = 0;
		//System.out.println(max);
		while(!queue.isEmpty()) {
			Integer [] currentvertex = queue.poll();
			int current = currentvertex[0];
			int cnt = currentvertex[1];

			Node curnode = null;
			for(int i=0; i<arr.size(); i++) {
				if(current == arr.get(i).index) {
					curnode = arr.get(i); 
				}

			}
			if(curnode == null) continue;
			for(int i=0; i<curnode.node.size(); i++){
				int num = curnode.node.get(i);
				if(!visited[num]) {
					if(cnt!=hier) {
						hier = cnt;
						max2 = 0;
						
					}
					queue.offer(new Integer[] {num, cnt+1});
					max2 = Math.max(max2, num);
					
					visited[num] = true;
				}
			}
		}
		return max2;
	}
}
