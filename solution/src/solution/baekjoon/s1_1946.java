package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class people implements Comparable<people>{
	int i;
	int fn;
	int sn;
	public people(int i, int fn, int sn) {
		super();
		this.i = i;
		this.fn = fn;
		this.sn = sn;
	}
	@Override
	public int compareTo(people o) {
		return this.fn-o.fn;
	}
}
public class s1_1946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			ArrayList<people> arr = new ArrayList<people>();
			int p = Integer.parseInt(in.readLine());
			for(int i = 1; i<=p; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				arr.add(new people(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			Collections.sort(arr);
			ArrayList<Integer> pos = new ArrayList<Integer>();
			int interview = arr.get(0).sn;
			int cnt = 1;
			for(int i=1; i<p; i++) {
				people cur = arr.get(i);
				if(interview>cur.sn) {
					cnt++;
					interview=cur.sn;
				}
//				for(int j=0; j<p; j++) {
//					if(pos.contains(arr.get(j).i)) {
//						if(cur.sn>=arr.get(j).sn) continue outer;
//					}
//				}


			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
