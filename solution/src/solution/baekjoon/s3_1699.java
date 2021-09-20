package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		while(true) {
			if(N==1) break;
			else {
				int num = (int) Math.floor(Math.sqrt(N));
				N-=num*num;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
