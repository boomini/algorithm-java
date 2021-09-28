package ct02hw_¼­¿ï_07¹Ý_±èº¸¹Î;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N  = Integer.parseInt(in.readLine());		
			long max = 0;
			int flag = 0;
			long time = 0;
			 for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				long sum = Math.abs(Integer.parseInt(st.nextToken()))+Math.abs(Integer.parseInt(st.nextToken())) ;
				
				if(i==0) {
					flag = (int) (sum%2);//È¦¼ö¸é1, Â¦¼ö¸é 0
				}else {
					if(sum%2!=flag) {
						time=-1;
					}
				}
				
				max = Math.max(sum , max);
			}
			if(time!=-1) {
				long sum = time;
				while(true) {
					long n = max-sum;
					if(n<=0) {
						if(Math.abs(n)%2==0) {
							break;
						}
					}
					time++;
					sum+=time;
				}
			}		
			sb.append(time).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
