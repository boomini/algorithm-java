package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_4013 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int K = Integer.parseInt(in.readLine());
			int check[] = new int[4];
			for(int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(),  " ");
				for(int j=0; j<8; j++) {
					if(Integer.parseInt(st.nextToken())==1) check[i]=check[i] | 1<<j;
				}
			}
			for(int i=0; i<K; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int num = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				int rotat[] = new int[4];
				rotat[num] = dir;
				int index = num;
				int n = 1;
				int d = dir;
				int left=2;
				int right = 6;
				
				for(int c=0; c<3; ) {
					int next = index+n;
					
					if(next==4) {
						index = num;
						n*=-1;
						d = dir; 
						left=6;
						right=2;
						continue;
					}
					if(((check[index] & 1<<left) == 0&&(check[next]&1<<right)==0)||((check[index] & 1<<left) != 0&&(check[next]&1<<right)!=0)) {
						rotat[next] = 0;
						c+=3-c;
						index+=n;
						continue;
					}else{
						d = d*-1;
						rotat[next]=d;
					};

					index+=n;
					c++;
				}
				for(int r=0; r<4; r++) {
					if(rotat[r]==0) {
						check(check[r]);
						continue;
					}
					check[r]=rota(check[r],rotat[r]);
					check(check[r]);
				}	
			}
			int answer = 0;
			for(int i=0; i<4; i++) {
				int c = check[i]&1;
				if(c==1) answer+=Math.pow(2, i);
			}
			
			System.out.println(answer);
		}
	}

	private static int rota(int cur, int dir) {
		int answer = 0;
		if(dir==1) {
			if(cur>=128) {
				cur = ((cur<<1)&255) | 1; 
			}else {
				cur = ((cur<<1)&255); 
			}
			
		}else {
			if(cur%2==1) {
				cur = cur>>1 | 1<<7;
			}
			else {
				cur = cur>>1;
			}	
		}
		return cur;
	}
	
	private static void check(int n) {
		System.out.println(Integer.toBinaryString(n));
	}
}
