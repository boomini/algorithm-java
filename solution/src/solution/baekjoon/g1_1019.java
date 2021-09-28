package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class g1_1019 {
	private static int arr[] = new int[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = 1;
		int k = 1;
		
		outer : while(true) {
			while(true) {				
				if(M%10==0) {
					break;
				}
				calc(M,k);
				if(M==N) break outer;
				M++;
			}
			
			while(M<=N) {
				if(N%10==9) {
					break;
				}
				
				calc(N,k);
				if(M==N) break outer;
				N--;
			}
			for(int i=0; i<=9; i++) {
				arr[i]+=((N/10-M/10)+1)*k;
			}
			
			N=N/10;
			M=M/10;
			k*=10;
			
		}
		for(int i=0; i<10; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

	private static void calc(int i, int k) {
		while(true) {
		arr[i%10]+=k;
			i=i/10;
			if(i/10==0&&i%10==0) {
				break;
			}
		}
	}
}
