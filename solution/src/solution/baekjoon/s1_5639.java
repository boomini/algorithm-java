package solution.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
	int node;
	Node left;
	Node right;
	public Node(int node) {
		this.node = node;
	}
	
	public void insert(int n) {
		if(n<this.node) {
			if(this.left == null) this.left = new Node(n);
		}
	}
	
	
}
public class s1_5639 {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(in.readLine()));
		while(true) {
			String s = in.readLine();
			
		}
	}
}
