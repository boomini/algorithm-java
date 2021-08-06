package solution.swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class d3_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_1225.txt")));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			Queue<Integer> q = new LinkedList<Integer>();
			String s = in.readLine();
			s= in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			for(int i=0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));	
			}
			int num = -1;
			while(true) {
				for(int i=1; i<=5; i++) {
					
					num = q.poll();
					num=num-i;
					if(num<=0) {
						num=0;
						q.add(num);
						break;
					}
					q.add(num);
				}
				if(num==0) break;
			}
			for(int i=0; i<8; i++) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
