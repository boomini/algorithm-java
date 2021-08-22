package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class d4_1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			String s = in.readLine();
			char[] c = s.toCharArray();
			char[] arr = new char[N];
			int index = 0;
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<N; i++) {
				if(c[i]=='+') {
					while(!stack.isEmpty()) arr[index++] = stack.pop();
					stack.push(c[i]);					
				}else if(c[i]=='*'){
					stack.push(c[i]);
				}else {
					arr[index++] = c[i];
				}
			}
			while(!stack.isEmpty())arr[index++] = stack.pop();
			
			
			stack.clear();
			Stack<Integer> stack2 = new Stack<>();
			int num1=0, num2=0;
		
			for(int i=0; i<N; i++) {
				char sel = arr[i];
				if(sel=='*') {
					num1 = stack2.pop();
					num2 = stack2.pop();
					stack2.push(num1*num2);
				}else if(sel=='+') {
					num1 = stack2.pop();
					num2 = stack2.pop();
					stack2.push(num1+num2);
				}else {
					stack2.push(sel-'0');
				}
			}
			
			int answer = stack2.pop();
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
