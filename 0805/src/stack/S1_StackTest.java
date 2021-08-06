package stack;

import java.util.Stack;

public class S1_StackTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		System.out.println(stack.isEmpty() + "/" + stack.size());
		
		stack.push("이석훈");
		stack.push("김연경");
		stack.push("여서정");
		stack.push("박우진");
		
		System.out.println(stack.isEmpty() + "/" + stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		
	}
}
