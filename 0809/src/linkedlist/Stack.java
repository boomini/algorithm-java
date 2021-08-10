package linkedlist;

public class Stack {
	private Node top;
	
	public void push(String data) {
		Node newNode = new Node(data, top);
		top = newNode;
	}
	public boolean isEmpty() {
		return top==null;//null이면 true를 null이 아니면 false를 준다.
	}
	public String pop() {
		if(isEmpty()) {
			System.out.println("스택이 비어 있어 pop이 불가합니다");
			return null;
		}
		Node popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}
	public String peek() {
		if(isEmpty()) {
			System.out.println("스택이 비어 있어 peek이 불가합니다");
			return null;
		}
		
		return top.data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("S (");
		for(Node currNode = top; currNode != null; currNode = currNode.link) {
				sb.append(currNode.data).append(",");
		}
		if(!isEmpty()) sb.setLength(sb.length()-1);
		sb.append(")");
		
		return sb.toString();
	}
}
