import java.util.Scanner;

//같은 행에 두지 않는 방식
//N개의 퀸을 위협적이지 않게 놓는 모든 경우의 수

public class NQueenTest2 {
	static int N;
	static int col[];
	private static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		setQueens(1); //1행부터 놓는 시도
		System.out.println(cnt);
	}
	
	private static void setQueens(int rowNo) {
		// 유망여부 체크 : rowNo - 1행까지 유망한지 체크
		if(!isAvailable(rowNo-1)) return;
		
		if(rowNo>N) {
			//마지막 행까지 다 둔 경우
			cnt++;
			return;
		}
		
		// 현재 퀸 1열부터 N열까지 놓아보기
		// 놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i <=N; i++) {
			col[rowNo] = i; //i열에 높아보기
			setQueens(rowNo+1);
		}
	}
	
	private static boolean isAvailable(int rowNo) {//rowNo : 현재 검사하려는 퀸
		for(int k = 1; k<rowNo; k++) {//k : 이전퀸
			if(col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == rowNo - k) return false; 
			//1. 같은 열에 위치하는지 확인하기
			//2. 대각선에 있을시, 행차이와 열차이가 같다.
		}
		return true;
	}
}
