import java.util.Arrays;

//1,2,3 순열
public class CombinationTest {

	static int N=6, R=3;
	static int[] numbers;
	static int[] input;
	static int sum;
	
	public static void main(String[] args) {
		input = new int[] {1,2,3,4,5,6};
		numbers = new int[R];
		sum = 0;
		combination(0,0);
		System.out.println(sum);
	}
	 
	private static void combination(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			sum++;
			return;
		}
		//start 위치의 수부터 가능한 수 모두 고려
		for(int i = start; i<N; i++) {
			
			numbers[cnt] = input[i];
			//다음 자리순열 뽑으러 gogo
			combination(cnt+1,i+1);
			
		}
	}
	
}
