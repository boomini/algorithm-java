package linkedlist;

public class Node {

	//데이터 필드
	public String data;
	//링크 필드
	public Node link;
	public Node(String data) {
		super();
		this.data = data;
	}
	public Node(String data, Node link) {
		this(data);
		this.link = link;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	
}
