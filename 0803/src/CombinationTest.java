import java.util.Arrays;

//1,2,3 순열
public class CombinationTest {

	static int N=3, R=2;
	static int[] numbers;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		input = new int[] {1,4,7};
		numbers = new int[R];
		
		combination(0,0);
	}
	 
	private static void combination(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		//start 위치의 수부터 가능한 수 모두 고려
		for(int i = start; i<N; i++) {
			
			numbers[cnt] = input[i];
			System.out.println((start+1) + " " +  (i+1) + " " + Arrays.toString(numbers));
			//다음 자리순열 뽑으러 gogo
			combination(cnt+1,i+1);
			
		}
	}
	
}
