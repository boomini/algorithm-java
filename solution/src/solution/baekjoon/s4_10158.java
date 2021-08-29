package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_10158 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(in.readLine());
		int resultx = (x+N)%(2*w);
		int resulty = (y+N)%(2*h);
		resultx = resultx>w?w-(resultx-w):resultx;
		resulty = resulty>h?h-(resulty-h):resulty;
		StringBuilder sb = new StringBuilder();
		sb.append(resultx).append(" ").append(resulty);
		System.out.println(sb.toString());
	}
}
