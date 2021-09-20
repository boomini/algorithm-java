import java.util.Scanner;

public class DP1_KnapsackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		} 
		
		int[] D = new int[W+1];
		//1차원 배열 활용하는 방법
		for(int i=1; i<=N; i++) {
			for(int w = W; w>=weights[i]; w--) {
				//해당 물건을 가방에 넣을 수 있다.
				D[w] = Math.max(D[w], profits[i] + D[w-weights[i]]);

			}
		}
		System.out.println(D[W]);
	}
}
