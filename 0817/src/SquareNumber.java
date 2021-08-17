import java.util.Scanner;

public class SquareNumber {
	static int callCnt;
	static long exp1(long x, long y) {
		callCnt++;
		if(y==1) return x;
		return x * exp1(x, y-1);
	}
	
	// 분할정복
	static long exp2(long x, long y) {
		callCnt++;
		if(y==1) return x;
		long r = exp2(x, y/2);
		long res = r * r;
		
		if(y%2==1) res *= x; //홀수일 떄
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
//		System.out.println(exp1(x,y));
//		System.out.println(callCnt);
		
		System.out.println(exp2(x,y));
		System.out.println(callCnt);
	}
}
