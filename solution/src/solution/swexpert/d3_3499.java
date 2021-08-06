package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			String[] card = new String[N];
			for(int i=0; i<N; i++) {
				card[i] = st.nextToken();
			}
			
			int C = N/2;
			if(N%2!=0) C+=1;
			for(int i=0; i<C; i++)
			{
				sb.append(card[i]).append(" ");
				if(i+C<N) sb.append(card[i+C]).append(" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
