import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.serializer.ToHTMLSAXHandler;

public class S1_SubSetTest {
	static int N;
	static int[] input;
	static boolean[] isSelected;
	static int totalCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		totalCnt = 0;
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println("경우의 수 : " + totalCnt);
	}
	
	private static void generateSubset(int cnt) {
		
		if(cnt == N) {
			totalCnt++;
			for(int i=0; i<N; i++) {
				System.out.print((isSelected[i]?input[i]:"X") + " ");
			}
			System.out.println();
			return;
		}
		//현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		
		//현재 원소를 부분집합에 넣지않기
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}
