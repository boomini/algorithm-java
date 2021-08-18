package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_1992 {
	private static StringBuilder sb2 = new StringBuilder();
	private static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String s = in.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
	
		
		forCheck(0,0,N);

		System.out.println(sb2.toString());
	}

	private static void forCheck(int i, int j, int size) {
		if(size==1) {
			sb2.append(arr[i][j]);
			return;
		}
		int flag = arr[i][j];
		outer : for(int l=i; l<i+size; l++) {
			for(int m=j; m<j+size; m++) {
				if(flag==arr[l][m]) continue;
				else {
					flag=-1;
					break outer;
				}
			}
		}
		if(flag!=-1) {
			sb2.append(flag);
		}else {
			sb2.append("(");
			forCheck(i, j, size/2);
			forCheck(i, j+size/2, size/2);
			forCheck(i+size/2, j, size/2);
			forCheck(i+size/2, j+size/2, size/2);
			sb2.append(")");
		}
		

	}
}
