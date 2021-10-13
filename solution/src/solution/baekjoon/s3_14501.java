package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int day[] = new int[N+1]; //각 날짜에 취할 수 있는 최대이득
		int max = 0;
		for(int i=0; i<N; i++) {
			max=Math.max(day[i],max); //이전까지 날짜중 최대값.
			day[i+1] = Math.max(max, day[i+1]);//현재 날짜에서 상담을 안했을 시 가능한 최대값.
			if(arr[i][0]+i>N) continue;//날짜에 해당하는 상담을 했을 때 퇴사날짜를 넘어가면 continue
			day[arr[i][0]+i] = Math.max(day[arr[i][0]+i], day[i]+arr[i][1]);//상담을 했을때와 안했을때 중 최대값 저장
			
		}
		System.out.println(day[N]);
	}
}
