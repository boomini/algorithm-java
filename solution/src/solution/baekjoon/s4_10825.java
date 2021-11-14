package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class stu implements Comparable<stu>{
	String name;
	int k;
	int m;
	int e;
	
	public stu(String name, int k, int e, int m) {
		super();
		this.name = name;
		this.k = k;
		this.e = e;
		this.m = m;
	}

	@Override
	public int compareTo(stu o) {
		if(this.k==o.k) {
			if(this.e==o.e) {
				if(this.m==o.m) {
					return this.name.compareTo(o.name);
				}else {
					return -(this.m-o.m);
				}
			}else {
				return this.e-o.e;
			}
		}else{
			return -(this.k-o.k);
		}
		
	}
	
}
public class s4_10825 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<stu> arr = new ArrayList<stu>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr.add(new stu(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr);
		for(int i=0; i<N; i++) {
			System.out.println(arr.get(i).name);
			
		}
		
	}
}
