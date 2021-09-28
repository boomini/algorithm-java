package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g1_11401 {
	private static int modNum = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		//M개의 키에 지문이 묻어있다.
		int N = Integer.parseInt(st.nextToken());
		//N자리 mCn
		
		long result = factorial(M) * ((power(factorial(M-N),modNum-2,modNum) * power(factorial(N), modNum-2,modNum))%modNum)%modNum;
		System.out.println(result);
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
