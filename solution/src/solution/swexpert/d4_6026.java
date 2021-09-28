package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_6026 {
	private static int modNum = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			//M개의 키에 지문이 묻어있다.
			int N = Integer.parseInt(st.nextToken());
			//N자리 
			M = M+N-1;
			
			for(int i=0; i<N; i++) {
				ncm(N,N-i)
			}
			ncm(M, N);
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static long ncm(int M, int N) {
		long result = factorial(M) * ((power(factorial(M-N),modNum-2,modNum) * power(factorial(N), modNum-2,modNum))%modNum)%modNum;
		return result;
	}

	private static long power(long a, long b, int p) {
		long res = 1L;
		
		while(b>0) {
			if(b%2==1) {
				res = (res * a) %p;
			}
			
			b = b >> 1;
			a = (a*a) %p;
		}
		return res;
	}

	private static long factorial(int n) {
		long tmp = 1L;
		while(n>0) {
			tmp *= n % modNum;
			tmp %= modNum;
			n--;
		}
		return tmp;
	}
}
