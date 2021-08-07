package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
// 내가 행했던 오류
// '.'가 전체 종료조건
// 문장 끝이 .가아니여도 길이 끝나면 출력

public class s4_4949 {
//
//	static String ch = "So when I die (the [first] I will see in (heaven) is a score list).\r\n"
//			+ "[ first in ] ( first out ).\r\n" + "Half Moon tonight (At least it is better than no Moon at all].\r\n"
//			+ "A rope may form )( a trail in a maze.\r\n"
//			+ "Help( I[m being held prisoner in a fortune cookie factory)].\r\n" + "([ (([( [ ] ) ( ) (( ))] )) ]).\r\n"
//			+ " .\r\n" + ".";
//	static String ch2 = "Half Moon tonight (At least it is better than no Moon at all].\r\n";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new StringReader(ch));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = in.readLine();
			if (s.equals("."))
				break;
			Stack<Character> stack = new Stack<Character>();
			int i = 0;
			while (true) {
				if (i >= s.length()) {
					if (stack.isEmpty())
						sb.append("yes").append("\n");
					else
						sb.append("no").append("\n");

					break;
				}
				char cur = s.charAt(i++);
				if (cur == '(' || cur == '[') {
					stack.add(cur);
				} else if (cur == ')' || cur == ']') {
					if (!stack.isEmpty()
							&& ((stack.peek() == '(' && cur == ')') || (stack.peek() == '[' && cur == ']')))
						stack.pop();

					else {
						sb.append("no").append("\n");
						break;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
