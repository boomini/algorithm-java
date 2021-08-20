package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_3234_02 {
	public static int remainWeight;
	public static int resultCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int caseNum = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= caseNum; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] weightAry = new int[N];
			resultCnt = 0;
			remainWeight = 0;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N; j++) {
				weightAry[j] = Integer.parseInt(st.nextToken());
				remainWeight += weightAry[j];
			}
			
			calc(N, weightAry, 0, 0, 0, 0, remainWeight);
			sb.append("#" + i + " " + resultCnt + "\n");
		}
		
		System.out.print(sb);
	}
	
	
	public static void calc(int N, int[] weightAry, int rightSum, int leftSum, int cnt, int flag, int remain) {
		
		if(leftSum >= rightSum + remain) {
			int tmp = (int)Math.pow(2, N-cnt);

			for(int i = 0; i < N - cnt; i++) {
				tmp *= i+1;
			}
			
			resultCnt += tmp;
			return;
		}
		
		if(cnt == N) {
			resultCnt++;
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			if((flag & 1 << i) != 0) continue;

			if(rightSum + weightAry[i] <= leftSum) calc(N, weightAry, rightSum+ weightAry[i], leftSum, cnt+1, (flag | 1 << i), remain - weightAry[i]);
			calc(N, weightAry, rightSum, leftSum+ weightAry[i], cnt+1, (flag | 1 << i), remain - weightAry[i]);
			
		}
		
	}
}
