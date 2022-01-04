package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Nodeee{
	int i;
	ArrayList<Integer> arr;
	public Nodeee(int i) {
		super();
		this.i = i;
		this.arr=new ArrayList<Integer>();
	}
	void fillnode(int i) {
		this.arr.add(i);
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
		int parent=0;
		for(int i=0; i<N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(cur==-1) {
				parent=i;
				continue;
			}
			arr.get(cur).fillnode(i);
		}
		
		remove = Integer.parseInt(in.readLine());
		
		bfs(parent);
		System.out.println(cnt);
	}

	private static void bfs(int i) {
		Nodeee cur = arr.get(i);
		if(cur.i==remove) return;
		int size = cur.arr.size();
		int cnt2 = 0;
		for(int a=0; a<size; a++) {
			if(cur.arr.get(a)==-1||cur.arr.get(a)==remove)cnt2++;
		}
		if(cnt2==size) {
			cnt++;
			return;
		}
		for(int a=0; a<size; a++) {
			bfs(cur.arr.get(a));
		}
	}
}
