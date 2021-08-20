import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.serializer.ToHTMLSAXHandler;

public class S2_SubSetSumTest2 {
	static int N, totalCnt2, totalCnt3, S;
	static int[] input;
	static boolean[] isSelected;
	static int callCnt2, callCnt3;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		callCnt3 = callCnt2 = totalCnt2 = totalCnt3 = 0;
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset2(0,0);
		//가지치기 안한경우
		System.out.println("경우의 수 : " + totalCnt2 + "호출횟수" + callCnt2) ;
		generateSubset3(0,0);
		//가지치기 한경우
		System.out.println("경우의 수 : " + totalCnt3 + "호출횟수" + callCnt3) ;
	}

	private static void generateSubset2(int cnt, int sum) {
		//cnt : 부분집합을 처리하기 위해 고려된 원소수
		//sum : 기존까지 부분집합 구성원소들의 합.
		callCnt2++;
		if (cnt == N) {
			// 부분집합 완성


			// 부분집합의 합 == 목표합 체크
			if (sum == S) {
				totalCnt2++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i] + " ");
				}
				System.out.println();
			}

			return;
		}
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset2(cnt + 1, sum+input[cnt]);

		// 현재 원소를 부분집합에 넣지않기
		isSelected[cnt] = false;
		generateSubset2(cnt + 1, sum);
	}
	private static void generateSubset3(int cnt, int sum) {
		//cnt : 부분집합을 처리하기 위해 고려된 원소수
		//sum : 기존까지 부분집합 구성원소들의 합.
		
		callCnt3++;
		// 부분집합의 합 == 목표합 체크
		if (sum == S) {
			totalCnt3++;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}
		if(sum>S || cnt==N) return;
			//목표로 하는 값을 넘어버렸을 때. or // 부분집합 완성
			
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset3(cnt + 1, sum+input[cnt]);
		
		// 현재 원소를 부분집합에 넣지않기
		isSelected[cnt] = false;
		generateSubset3(cnt + 1, sum);
	}
}
