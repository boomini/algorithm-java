
public class R01_FactorialTest {
	private static int factorial0(int n) {
		int res = 1;
		for(int i=n; i>0; i--) {
			res *= i;
		}
		return res;
	}
	private static int res = 1;
	private static void factorial0_2(int i) {
		if(i==0) return;
		res *= i;
		factorial0_2(i-1);
	}
	
	private static int factorial(int n) {
		if (n<=1) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}
	public static void main(String[] args) {
		int answer = factorial0(5);
		System.out.println(answer);
		factorial0_2(5);
		System.out.println(res);
	}
}
