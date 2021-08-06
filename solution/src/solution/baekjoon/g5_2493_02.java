package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class g5_2493_02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> top = new Stack<>();
		int[] input = new int[N];
		String s= in.readLine();

		StringTokenizer st = new StringTokenizer(s, " ");
		StringBuilder sb = new StringBuilder();
		int check = Integer.parseInt(st.nextToken());
		int last = 0, compare =0;
		
		input[0]=check;
		for(int i=1; i<N; i++) {
			compare = Integer.parseInt(st.nextToken());
			input[i] = compare;
			if(check>=compare) top.add(check);
			check = compare;
		}
		
		int index = 0;
		int count = 0;
		int j=0;
		while(true) {
			int topNum = top.poll();
			while(true) {
				int num = input[j++];
				System.out.print(index + " ");
				count++;
				if(j==N) break;
				if(topNum == num ) {
					index = count;
					if(top.isEmpty()) continue;
					break;
				}
			}
			if(top.isEmpty()) break;
		}		
	}
}
