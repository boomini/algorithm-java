package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int bigcnt = 1;
		int smallcnt = 1;
		int bigresult = 0;
		int smallresult = 0;
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int before = Integer.parseInt(st.nextToken());
		for(int i=0; i<N-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>=before) {
				bigcnt++;
				bigresult = Math.max(bigcnt, bigresult);
			}else {
				
				bigcnt=1;
			}
			
			if(num<=before) {
				smallcnt++;
				smallresult = Math.max(smallcnt, smallresult);
			}else {
				
				smallcnt=1;
			}
			before = num;
		}
		System.out.println(Math.max(bigresult, smallresult));
	}
}
