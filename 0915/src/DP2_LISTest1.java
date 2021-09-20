import java.util.Scanner;

public class DP2_LISTest1 {
	//O(n^2)
	//Bruteforce보다는 효율적이지만 n이커지면 안좋다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N]; //각 원소를 끝으로 하는 최장길이
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;//전체중의 최대길이
		for(int i=0; i<N; i++) {
			LIS[i] = 1;
			for(int j = 0; j<i; j++) {//j : i의 앞쪽 원소
				if(arr[j]<arr[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
			}//i를 끝으로 하는 최장길이 값 계산 완료
			max = Math.max(max, LIS[i]);
		} 
		System.out.println(max);
	}

}
