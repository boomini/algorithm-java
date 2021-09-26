package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class g5_17471 {
	private static boolean isChecked[]; 
	private static int N ;
	private static ArrayList<Integer> area1;
	private static ArrayList<Integer> area2;
	private static ArrayList<Integer>[] node;
	private static int min = Integer.MAX_VALUE;
	private static int p[] ; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		node = new ArrayList[N+1];
		p = new int[N+1];
		isChecked = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=1; i<=N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			node[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				node[i].add(Integer.parseInt(st.nextToken()));
			}
			
		}	
		subset(1);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
	}

	private static void subset(int cnt) {
		if(cnt==N) {
			area1 = new ArrayList<Integer>();
			area2 = new ArrayList<Integer>();
			for(int i=1; i<=N; i++) {
				if(isChecked[i]) area1.add(i);
				else area2.add(i);
			}
			if(area1.size()==N || area1.size()==0) return;
			else {
				if(BFS(area1)&&BFS(area2)) {
					int p1 = 0, p2 = 0;
					for(int i=0; i<area1.size(); i++) {
						p1 += p[area1.get(i)];
					}
					for(int i=0; i<area2.size(); i++) {
						p2 += p[area2.get(i)];
					}
					
					min = Math.min(min, Math.abs(p1-p2));
				}
				
				
			}
			return;
		}
		
		isChecked[cnt] = true;
		subset(cnt+1);
		
		isChecked[cnt] = false;
		subset(cnt+1);
	}

	private static boolean BFS(ArrayList<Integer> area) {
		Queue<Integer> q = new LinkedList<>();
		q.add(area.get(0));
		int cnt = area.size();
		boolean[] visited = new boolean[N+1];
		visited[area.get(0)] = true;
		while(!q.isEmpty()) {
			int num = q.poll();
			cnt--;
			if(cnt==0) break;
			for(int i=0; i<node[num].size(); i++) {
				int check = node[num].get(i);
				if(!visited[check]&&area.contains(check)){
					q.add(check);
					visited[check] = true;
				}
			}
			
		}
		if(cnt==0) return true;
		return false;
		
		
	}
}
