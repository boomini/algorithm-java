package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Node15{
	char i;
	char left;
	char right;
	public Node15(char i) {
		this.i = i;
	}
	public Node15(char i, char left, char right) {
		super();
		this.i = i;
		this.left = left;
		this.right = right;
	}

}
public class s1_1991 {
	private static StringBuilder sb;
	private static Node15 arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		arr = new Node15[26];
		for(int i=0; i<26; i++) {
			arr[i] = new Node15((char)(i+65));
		}
		for(int i=0; i<N; i++) {
			String[] line = in.readLine().split(" ");
			char cur = line[0].charAt(0);
			arr[cur-65].left = line[1].charAt(0);
			arr[cur-65].right = line[2].charAt(0);
		}
		sb = new StringBuilder();
		//전위순회
		preorder(0);
		sb.append("\n");
		//중위순회
		inorder(0);
		sb.append("\n");
		//후위순회
		postorder(0);
		System.out.println(sb.toString());
	}

	private static void postorder(int i) {
		if(i==-19) return;
		postorder(arr[i].left-65);
		postorder(arr[i].right-65);
		sb.append(arr[i].i);
	
	}

	private static void inorder(int i) {
		if(i==-19) return;
		inorder(arr[i].left-65);
		sb.append(arr[i].i);
		inorder(arr[i].right-65);
	}

	private static void preorder(int i) {
		if(i==-19) return;
		sb.append(arr[i].i);
		preorder(arr[i].left-65);
		preorder(arr[i].right-65);

	}
}
