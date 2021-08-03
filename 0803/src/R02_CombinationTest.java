
public class R02_CombinationTest {

	private static int comb(int n, int r) {
		//자신을 포함해서 r개를 만드는 경우의 수 + 자신을 포함하지 않고 r개를 만드는 경우의 수
		if(r==0 || n==r) return 1;
		
		return comb(n-1,r-1) + comb(n-1,r);
			
			
	}
	public static void main(String[] args) {
		System.out.println(comb(3,2));
		System.out.println(comb(5,3));
	}
}
