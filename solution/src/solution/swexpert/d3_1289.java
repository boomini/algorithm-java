package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class d3_1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sol = Integer.parseInt(in.readLine());
		int solnum=1;
		while(sol-->0) {
			int count = 0;
			char checknum = '0';
			String bit = in.readLine();
			char ch[] = bit.toCharArray();
			for(char check : ch) {
				if(check!=checknum) {
					count++;
					if(checknum=='0') checknum = '1';
					else checknum = '0';
				}
			}
			System.out.println("#"+ solnum++ + " " + count);
		}
	}
}
