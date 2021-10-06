package hwalgo30_서울_07반_김보민;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int arr[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(in.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			
			for(int i=0; i<N; i++) {
				if(check(arr[i], X)) {
					ans++;
					//System.out.println(Arrays.toString(arr[i]));
				};
				int cur[] = new int[N];
				for(int j=0; j<N; j++) {
					cur[j] = arr[j][i];
				}
				if(check(cur, X)) {
					ans++;
					//System.out.println(Arrays.toString(cur));
				};
				
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean check(int[] cur , int X) {
		
		//1.앞쪽과 비교해서 커지는순간 작아지는순간 확인
		
		//1-1. 커지는 순간은 앞쪽의 길이를 재고있어야했고,
		//1-2. 작아지는 순간은 지금부터길이를 재야한다.
		
		//2. 잰 길이가 X보다 크거나 같아야한다.
		int cnt = 1;
		int icur = cur[0];
		boolean flag = false;
		for(int i=1; i<N; i++) {
			if(Math.abs(icur-cur[i])>1) return false; //만약 차이가 1이상이라면
			if(icur==cur[i]) {
				cnt++;
				continue;
			}
			else if(icur<cur[i]) {
				if(flag) {//변화가 발생했을때 그전경로가 x를 넘었어야 하는 경우
					if(cnt<2 * X)return false;
					else flag = false;
				}
				
				if(cnt>=X) {//1-1. 커지는 순간은 앞쪽의 길이를 재고있어야했고,
					cnt=1;
				}else {
					return false;
				}
				icur = cur[i];
			}else {
				if(flag) {//변화가 발생했을때 그전경로가 x를 넘었어야 하는 경우
					if(cnt<X) return false;
					else flag = false;
				}//
				
				cnt=1;//1-2. 작아지는 순간은 지금부터길이를 재야한다.
				flag = true;//길이를 잴 필요가 있다.
				icur = cur[i];
			}
		}
		
		if(flag && cnt<X) {//변화가 발생했을때 그전경로가 x를 넘었어야 하는 경우
			return false;
		}
		return true;
		
	}
}