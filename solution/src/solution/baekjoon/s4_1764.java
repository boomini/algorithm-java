package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class s4_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> arr = new HashSet<String>();
		ArrayList<String> ans = new ArrayList<String>();
		for(int i=0; i<N; i++) {
			arr.add(in.readLine());
		}
		
		for(int i=0; i<M; i++) {
			String s = in.readLine();
			if(arr.contains(s)) {
				ans.add(s);
			}
		}
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		for(int i=0; i<ans.size(); i++) {
			sb.append(ans.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
