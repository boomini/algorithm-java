package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class s2_2304 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[][] = new int[N][2];
		int max =  0;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i][1]);
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[]o2) {
				return o1[0]-o2[0];
			}
		});
		//System.out.println(Arrays.deepToString(arr));
		int size = 0;		
		int height = arr[0][1];
		int index = arr[0][0];
		boolean flag = false;
		for(int i=0; i<N; i++) {
			if(max==arr[i][1]) {
				flag = true;
			}
			if(flag) {
				priorityQueue.add(arr[i][1]);
			}
		}
		int num = priorityQueue.poll();
		int i=0;
		for(; i<N; i++) {
			if(height<=arr[i][1]) {
				size+= height*(arr[i][0]-index);
				index = arr[i][0];
				height = arr[i][1];
				if(height==num) {
					break;
				}
			}
		}
		size+=height;
		//가장 높은 기둥을 포함한 부분의 넓이
		
		
		//오른쪽 넓이
		while(true) {	
			if(num==arr[N-1][1]) {
				size+=arr[N-1][1]*(arr[N-1][0]-index);
				System.out.println(size);
				System.exit(0);
			}
			num = priorityQueue.poll();
			if(num==arr[N-1][1]) continue;
			for(i=i+1; i<=N-1; i++) {
				if(num==arr[i][1]) {
					size+=(arr[i][0]-index)*num;
					index = arr[i][0];
					height = arr[i][1];
					break;
				}
			}
		}	
	}
}
