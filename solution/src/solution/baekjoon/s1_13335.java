package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class car{
	int w;//¹«°Ô
	int c;//index
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public car(int w, int c) {
		super();
		this.w = w;
		this.c = c;
	}
	
}
public class s1_13335 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			arr.add( Integer.parseInt(st.nextToken()));
		}
		int time = 0;
		int sum = 0;
		int index = 0;
		ArrayList<car> cur = new ArrayList<car>();
		while(true) {
			if(cur.size()==0 && arr.size()==0) break;

			time++;
			for(int i=cur.size()-1; i>=0; i--) {
				cur.get(i).c++;
				if(cur.get(i).c>w) {
					sum-=cur.get(i).w;
					cur.remove(cur.get(i));					
				}
			}

			if(arr.size()!=0 && cur.size()<=w&&L>=sum+arr.get(0)) {
				cur.add(new car(arr.get(0),1));
				sum+=arr.get(0);
				arr.remove(0);
			}

			
		}
		
		System.out.println(time);
	}
}
