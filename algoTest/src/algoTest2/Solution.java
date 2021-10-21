package algoTest2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
	int i;
	int j;


	public Node(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
}


class Solution
{
	 private static int exit[][];	
	 private static ArrayList<Node> arr;
	 private static int N;
	 private static boolean visited[][];
	 private static int pcnt;
	 private static int answer;
	 public static void main(String args[]) throws Exception
	 {
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   int T = Integer.parseInt(in.readLine());
	   StringBuilder sb = new StringBuilder();
	   for(int tc = 1; tc<=T; tc++) {
		   sb.append("#").append(tc).append(" ");
		   N = Integer.parseInt(in.readLine());
		   exit= new int[2][2];// 출구 배열
		   visited=new boolean[2][(N*N)+1];
		   arr = new ArrayList<Node>();
		   answer = Integer.MAX_VALUE;
		   int index = 0;
		   pcnt = 0;
		   for(int i=0; i<N; i++) {
			   StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			   for(int j=0; j<N; j++) {
				   int n = Integer.parseInt(st.nextToken());
				   if(n==1) {
					   pcnt++;//탈출시켜야 하는 사람수 			   
					   arr.add(new Node(i,j));
				   }
				   else if(n==2) {
					   exit[index][0] = i;
					   exit[index][1] = j;
					   index++;
				   }
			   }
		 
		   }	   
		   dfs(0,visited);

		   sb.append(answer+1).append("\n");
	   }
	   System.out.println(sb.toString());
	 }
	
	private static void dfs(int index, boolean[][] visited) {
		if(index==pcnt) {
			int val = 0;
			for(int i=0; i<N*N; i++) {
				if(visited[0][i] || visited[1][i]) val = i;
			}
			answer = Math.min(val, answer);
			return;
		}
		int n1 = Math.abs(arr.get(index).i-exit[0][0]) + Math.abs(arr.get(index).j-exit[0][1]);
		while(visited[0][n1]) {
				n1++;
		}

		visited[0][n1] = true;
		dfs(index+1, visited);	
		visited[0][n1] = false;

		int n2 = Math.abs(arr.get(index).i-exit[1][0]) + Math.abs(arr.get(index).j-exit[1][1]);
		while(visited[1][n2]) {
				n2++;
		}

		visited[1][n2] = true;
		dfs(index+1, visited);	
		visited[1][n2] = false;
	}
	
}