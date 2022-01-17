package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		char c[] = s.toCharArray();
		int dp[] = new int[s.length()+1];
		int ans = 0;
		if(s.length()>=1&&c[0]-'0'!=0) {
			dp[0]=1;
			if((s.length()>=2&&c[1]-'0'!=0)||s.length()==1) {
				dp[1]=1;
			}else{
				dp[1]=0;
			}
			
			for(int i=2; i<=s.length(); i++) {
				int n1 = c[i-2]-'0';
				int n2 = c[i-1]-'0';
				if(n2!=0) {
					dp[i]+=dp[i-1];
				}
				if(n1==0)continue;
				int n = n1*10 + n2;
				if(n<=26&&n>0) {
					dp[i] += dp[i-2];
				}
				dp[i]%=1000000;
			}
			ans = dp[s.length()]%1000000;
		}
		System.out.println(ans);
	}
}
