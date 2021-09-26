package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		Queue<Long> q = new LinkedList<Long>();
		long cnt = 0;
		long answer = 0;
		for(int i=0; i<B; i++) {
			A=A*A;
			A=A%C;
			if(!q.isEmpty()) {
				if(A==q.peek()) {
					cnt = q.size();
					answer = B/cnt;
					for(long j=cnt; cnt>0; cnt--) {
						answer = q.peek();
					}
					break;
				}
			}
			q.add(A);
		}
		System.out.println(answer);
	}
}
