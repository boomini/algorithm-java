package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class g4_1715 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			q.add(Integer.parseInt(in.readLine()));
		}
		int sum = 0;
		while(q.size()!=1) {
			
			int num1 = q.poll();
			int num2 = q.poll();
			sum+=num1+num2;
			q.add(num1+num2);
		}
		
		System.out.println(sum);
	}
}
