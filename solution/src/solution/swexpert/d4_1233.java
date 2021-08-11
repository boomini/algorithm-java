package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class d4_1233 {
	private static int lastIndex;
	private static String nodes[];
	private static Stack<String> stack;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 1; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			stack = new Stack<String>();
			nodes = new String[N + 1];
			lastIndex = N;
			int num = 0;
			for (int i = 1; i <= N; i++) {
				String s = in.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				num = Integer.parseInt(st.nextToken());
				nodes[num] = st.nextToken();
			}
			dfsByInOrder();
			System.out.println(stack);
			boolean flag = true;
			while (!stack.isEmpty()) {
				if (stack.size() == 1) {
					if (!check(stack.peek())) {
						sb.append(0).append("\n");
						flag = false;
						break;
					} else
						break;
				}
				if (check(stack.peek())) {
					sb.append(0).append("\n");
					flag = false;
					break;
				}
				stack.pop();
				if (!check(stack.peek())) {
					sb.append(0).append("\n");
					flag = false;
					break;
				}
				stack.pop();
			}

			if (flag == true) {
				sb.append(1).append("\n");
			}
		}

		sb.toString();
	}

	public static void dfsByInOrder() {
		System.out.println("Preorder: ");
		dfsByInOrder(1);
		System.out.println();
	}

	private static void dfsByInOrder(int current) {
		// 왼쪽자식 노드 방문
		if (current * 2 <= lastIndex)
			dfsByInOrder(current * 2);
		// 현재노드처리
		System.out.print(nodes[current]);
		stack.add(nodes[current]);

		// 오른쪽자식노드방문
		if (current * 2 + 1 <= lastIndex)
			dfsByInOrder(current * 2 + 1);

	}

	private static Boolean check(String s) {
		return (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-"));
	}

}
