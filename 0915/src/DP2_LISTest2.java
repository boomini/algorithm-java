import java.util.Arrays;
import java.util.Scanner;

public class DP2_LISTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N]; //모든 원소의 값은 다르다.
		int[] LIS = new int[N]; //해당 길이를 증가수열 중 맨 끝을 최솟값으로 유지.
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0; //LIS에 채워진 원소 수
		for(int i=0; i<N ; i++) {
			// 중복값이 없으므로 탐색 실패. 음수값 ==> 삽입위치로 환산
			int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]))-1;
			LIS[temp] = arr[i];
			
			if(temp == size) {
				size++;
			}
		}
		
		System.out.println(size);
	}
}
