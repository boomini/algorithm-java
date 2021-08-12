import java.util.Arrays;

//N개의 서로 다른 수에서 뽑는 순열
public class PermutationTest {

	static int N=3, R=2;
	static int[] numbers;
	static int[] input;
	
	public static void main(String[] args) {
		input = new int[] {1,4,7};
		numbers = new int[R];
		
		permutation(0,0);
	}
	 
	private static void permutation(int cnt, int flag) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		//가능한 모든 수들이 들어있는 배열모든 원소에 대해 시도
		for(int i = 0; i<N; i++) {//i : 인덱스
			if((flag & 1<<i)!=0) continue; //인덱스에 해당하는 수가 사용 중인 수면 다음 수로
			
			numbers[cnt] = input[i];
			
			//다음 자리순열 뽑으러 gogo
			permutation(cnt+1,flag | 1<<i);
		}
	}
	
}
