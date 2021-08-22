package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_2110 {
	private static int N;
	private static int C;
	private static int X[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		X = new int[N];
		for(int i=0; i<N; i++) {
			X[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(X);
		
		if(C==2) System.out.println(Math.abs(X[0] - X[N-1]));
		else {
			//System.out.println(getValue(0,mid, N-1));
		}
		int mid = N/2;
		int start = 0;
		int last = N-1;
		for(int cnt = 2; cnt<C; cnt++) {
			int midValue =getValue(start,mid, last);
			cnt++;
			int leftValue = getValue(start, (start+midValue)/2, midValue);
			int rightValue = getValue(midValue, (last+midValue)/2, last);
		}
		
	}

	private static int getValue(int start, int mid, int last) {
	
		int max = -1;
		int check = mid;
		do {
			int front = distance(X[mid] ,X[start]);
			int end =distance(X[last] ,X[mid]); 
			int num= Math.min(front, end);
			
			if(num<=max) {
				break;
			}
			else {
				check = mid;
				max = num;
			}
			if(front<end) {
				if(mid+1<last)mid++;
				else break;
			}
			else if(front>end) {
				if(mid-1>start) mid--;
				else break;
			}
			else if(front==end) break;
		}while(true);
		// mid Ã£±â
		
		return max;	
	}
	
	private static int distance(int x, int y) {
		return Math.abs(x-y);
	}
}
