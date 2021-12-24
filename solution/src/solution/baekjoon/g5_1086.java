package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Nodeee{
	int i;
	int left=-1;
	int right=-1;
	public Nodeee(int i) {
		super();
		this.i = i;
	}
	void fillnode(int i) {
		if(this.left==-1) {
			this.left = i;
		}else {
			this.right = i;
		}
	}
	
}
public class g5_1086 {
	private static int cnt=0;
	private static ArrayList<Nodeee> arr;
	private static int remove=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		 arr = new ArrayList<Nodeee>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr.add(new Nodeee(i));
		}
		for(int i=0; i<N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(cur==-1) continue;
			arr.get(cur).fillnode(i);
		}
		
		remove = Integer.parseInt(in.readLine());
		
		bfs(0);
		System.out.println(cnt);
	}

	private static void bfs(int i) {
		Nodeee cur = arr.get(i);
		if(cur.i==remove) return;
		if((cur.left==-1||cur.left==remove)&&(cur.right==-1||cur.right==remove)) {
			cnt++;
			return;
		}
		if(cur.left!=-1)bfs(cur.left);
		if(cur.right!=-1)bfs(cur.right);
		
	}
}
