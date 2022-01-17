package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class g4_16938 {
	private static int num[];
	private static int N;
	private static int L;
	private static int R;
	private static int X;
	private static int ans;
	private static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		//문제개수
		L = Integer.parseInt(st.nextToken());
		//문제 난이도의 합은 L보다 크거나 같아야하고
		R = Integer.parseInt(st.nextToken());
		//R보다 작거나 같아야한다.
		X = Integer.parseInt(st.nextToken());
		//가장 어려운 문제와 가장 쉬운 문제의 난이도 차이
		st = new StringTokenizer(in.readLine());
		arr = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		ans=0;
		Collections.sort(arr);
		
		for(int i=2; i<=N; i++) {
			num = new int[i];
			combination(0,0,i);
		}
		System.out.println(ans);
	}

	private static void combination(int cnt,int start, int n) {
		if(cnt==n) {
			int sum = 0;
			for(int j=0; j<n; j++) {
				sum+=num[j];
				//System.out.print(num[j]+" ");
			}
			//System.out.println();
			int temp = num[n-1]-num[0];
			if(sum>=L&&sum<=R&&temp>=X) {
				ans++;
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			num[cnt] = arr.get(i);
			combination(cnt+1,i+1,n);
		}
	}
}
