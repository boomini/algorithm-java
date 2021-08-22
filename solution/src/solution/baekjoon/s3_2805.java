package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_2805 {
	//1. 목재절단기에 높이 H를 지정해야 한다.
	//2. 높이를 지정하면 H미터 나무들이 잘린다.
	//3. H보다 큰 나무는 H위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다.
	//4. 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.
	//5. 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값.
	//6. 1<=N<=1000000, 1<=M<=2000000000
	//7. 이분탐색 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		s = in.readLine();
		st = new StringTokenizer(s, " ");
		int[] tree = new int[N];
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		int start = 0;
		int last = tree[N-1];
		int mid = 0;
		long sum = 0;
		//M의 단위가 크기 때문에 sum을 했을 때 오버플로우가 발생할 수 있다.
		while(true) {
			mid = (start + last)/2;
			sum = 0;
			for(int i=0; i<N; i++) {
				int piece = tree[i]-mid;
				sum += piece<0?0:piece;
			}
			
			if(start>=last && sum > M) {
				//start가 last보다 커지거나 같아지는데 잘려진 나무피스의 sum이 원하는 값보다 커지면 그 값 출력
				break;
			}else if(start>=last && sum < M) {
				//start가 last보다 커지거나 같아지는데 잘려진 나무피스의 sum이 원하는 값보다 작아지면 그 값보다 한칸 아래값을 출력
				mid -=1;
				break;
			}
			
			if(sum>M) {
				start = mid+1;
			}else if(sum<M) {
				last = mid-1;
						
			}else break;
			
		}
		System.out.println(mid);
		//System.out.println(start + " " + last + " " + sum + " " + mid);
		
	}
}
