package solution.programmers;

import java.util.ArrayList;
import java.util.List;



class Solution10{
	class Node implements Comparable<Node>{
		int me;
		ArrayList<Integer> node;
		
		Node(int me){
			this.me = me;
			node = new ArrayList<Integer>();
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.me - o.me;
			//무조건 양 먼저
			//우선순위큐내에서
		}	
	}

	private static Node[] nodes;
	public int solution(int[] info, int[][] edges) {
        int answer = 0;
        nodes = new Node[info.length];
        for(int i=0; i<info.length; i++) {
        	nodes[i] = (new Node(info[i]));
        }     
        for(int i=0; i<edges.length; i++) {
        	int node1 = edges[i][0];
        	int node2 = edges[i][1];
        	if(node1<node2) {
        		nodes[node1].node.add(node2); 
        	}else {
        		nodes[node2].node.add(node1);
        	}
        }
        int x = 0;
        int y = 0;
        dfs(0,1,0);
        //0번째 노드, 양의개수, 늑대의개수
       
        return answer;
    }
	public void dfs(int index, int x, int y) {
		for(int i=0; i<nodes[i].node.size(); i++) {
			
		}
	}
}
public class ka_05 {
	public static void main(String[] args) {
		Solution10 sol = new Solution10();
		System.out.println(sol.solution(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,1},{9,11},{4,3},{6,5},{4,6},{8,9}}));
		//5
		System.out.println(sol.solution(new int[] {0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}));
		//5
	}
}
