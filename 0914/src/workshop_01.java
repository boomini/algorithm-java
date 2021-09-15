import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class workshop_01 {
	private static int N;
	private static int R = 2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][2];//[0] => 노란색 개수 [1] => 파란색 개수
		arr[0][0] = 1;
		arr[0][1] = 1;
		for(int i=1; i<n; i++) {
				arr[i][0] = arr[i-1][0] + arr[i-1][1]; //노란색 개수
				arr[i][1] = arr[i-1][0]; //파란색 개수
		}
		System.out.println(arr[n-1][0]+arr[n-1][1]);
	}
}
