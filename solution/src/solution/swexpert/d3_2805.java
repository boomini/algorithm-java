package solution.swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new InputStreamReader(new FileInputStream("input_2805.txt")));
		int T = Integer.parseInt(in.readLine());
		StringBuffer sb = new StringBuffer();
		for(int ts = 1; ts<=T; ts++) {
			sb.append("#").append(ts).append(" ");
			int N = Integer.parseInt(in.readLine());
			int farm[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String farmLine = in.readLine();
				char[] forChange = farmLine.toCharArray();
				for(int j=0; j<N; j++) {
					farm[i][j] = forChange[j]-48;
				}
			}
			
			int cnt=1;
			int d =-1;
			int sum = 0;
			int inum = N/2;
			for(int i=0; i<N; i++) {
				
				
				int j=0;
				for(; j<inum;) {
					j++;
				}
				if(inum==0) d *=-1;
				inum = inum + d;
				
				for(int k=0; k<cnt; k++) {
					sum += farm[i][j++];
				}
				cnt += -1*2*d;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
