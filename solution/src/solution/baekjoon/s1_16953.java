package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int answer = 0;
		int cnt = 1;
		while(true) {
			if(B<A) {
				answer = -1;
				break;
			}
			else if(B==A) {
				answer = cnt;
				break;
			}
			else if(B%2==0)B/=2;
			else if(B%10==1) B/=10;
			else {
				answer = -1;
				break;
			}
			cnt++;
		}
		System.out.println(answer);
	}
}
