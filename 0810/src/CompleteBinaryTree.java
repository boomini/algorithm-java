import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private final int SIZE;
	private int lastIndex; //마지막에 추가할 노드의 인덱스
	
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[size+1];
		
	}
	
	public void add(char c) {
		if(lastIndex==SIZE) return;
		nodes[++lastIndex] = c;
	}
	
	public void bfs() {
		// 탐색을 기다리는 노드들이 저장됨
		// 배열로 관리하므로 탐색할 노드를 관리하는 인덱스를 저장
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); //루트노드 인덱스 저장
		
		int current = 0;
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(nodes[current]);
			//왼쪽자식이 있다면
			if(current*2<=lastIndex) {
				queue.offer(current*2);
			}
			//오른쪽 자식이 있다면
			if(current*2 + 1 <= lastIndex) {
				queue.offer(current*2 + 1);
			}
		}
	}
	
	public void bfs2() {
		// 탐색을 기다리는 노드들이 저장됨
		// 배열로 관리하므로 탐색할 노드를 관리하는 인덱스를 저장
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); //루트노드 인덱스 저장
				
		int current = 0, level = 0, size = 0;
				
		while(!queue.isEmpty()) {
			size = queue.size();
			
			System.out.println("level" + level+ ":");
			while(--size>=0) {
				current = queue.poll();
				System.out.print(nodes[current] + " ");
				//왼쪽자식이 있다면
				if(current*2<=lastIndex) {
					queue.offer(current*2);
				}
				//오른쪽 자식이 있다면
				if(current*2 + 1 <= lastIndex) {
					queue.offer(current*2 + 1);
				}
			}
			System.out.println();
			++level;
		}
	}
	
	public void dfsByPreOrder() {
		System.out.println("Preorder: ");
		dfsByPreOrder(1);
		System.out.println();
	}
	private void dfsByPreOrder(int current) {
		//현재노드처리
		System.out.print(nodes[current] + " ");
		//왼쪽자식 노드 방문
		if(current*2<=lastIndex) dfsByPreOrder(current*2);
		//오른쪽 자식 노드 방문
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
	}
	
	public void dfsByInOrder() {
		System.out.println("Preorder: ");
		dfsByInOrder(1);
		System.out.println();
	}
	private void dfsByInOrder(int current) {
		//왼쪽자식 노드 방문
		if(current*2<=lastIndex) dfsByInOrder(current*2);
		
		//현재노드처리
		System.out.print(nodes[current] + " ");
		
		//오른쪽 자식 노드 방문
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1);
	}
}
