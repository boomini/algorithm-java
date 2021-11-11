package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class jew implements Comparable<jew>{
	int m;
	int v;
	public jew(int m, int v) {
		super();
		this.m = m;
		this.v = v;
	}
	@Override
	public int compareTo(jew o) {
		return o.v-this.v;
	}
	
}
public class g2_1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer> bag = new ArrayList<Integer>();
		PriorityQueue<jew> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			pq.add(new jew(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(int i=0; i<K; i++) {
			bag.add(Integer.parseInt(in.readLine()));
		}
		Collections.sort(bag);
		long answer = 0;
		outer: while(!pq.isEmpty()&&bag.size()!=0) {
			jew cur = pq.poll();
			
			for(int i=0; i<bag.size(); i++) {
				if(cur.m <= bag.get(i)) {
					answer+=cur.v;
					bag.remove(i);
					continue outer;
				}
			}
		}
		System.out.println(answer);
	}
}
