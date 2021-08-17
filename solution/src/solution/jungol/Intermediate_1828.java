package solution.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Test implements Comparable<Test>{
	public int low ;
	public int high;
	public Test(int low, int high) {
		super();
		this.low = low;
		this.high = high;
	}
	@Override
	public int compareTo(Test o) {
		if(this.low<o.low) {
			return -1;
		}else if(this.low>o.low) {
			return 1;
		}
		return 0;
	}
	
	
}
public class Intermediate_1828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Test[] arr= new Test[N];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			arr[i] = new Test(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		} 
		
		Arrays.sort(arr);
		int key = arr[0].high;
		int count = 0;
		for(int i=1; i<N; i++) {
			 if(arr[i].low < key) {
				 if(arr[i].high<key) {
					 key = arr[i].high;
				 }
			 }else {
				 count++;
				 key = arr[i].high;
			 }
		}
		count++;
		System.out.println(count);
		
		
	}
	
}
