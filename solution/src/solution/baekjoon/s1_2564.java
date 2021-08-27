package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_2564 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(in.readLine());
		int arr[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		int dir = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		int full = (x+y)*2;
		//1:ºÏ, 2:³², 3:¼­, 4:µ¿
		int sum = 0;
		for(int i=0; i<N; i++) {
			int storedir = arr[i][0];
			int storelen = arr[i][1];
			
			if(storedir==dir) {
				sum+= Math.abs(storelen-len);
			}else if(storedir==1&&dir==2||storedir==2&&dir==1){
				int value = storelen+len+y;
				sum+=Math.min(value, full-value);
			}else if(storedir==3&&dir==4||storedir==4&&dir==3) {
				int value = storelen+len+x;
				sum+=Math.min(value, full-value);
			}else if(dir==1&&storedir==3||dir==3&&storedir==1){
				sum+= len+storelen;
			}else if(dir==1&&storedir==4) {
				sum+= (x-len)+storelen;
			}else if(dir==2&&storedir==3) {
				sum+=len+(y-storelen);
			}else if(dir==2&&storedir==4) {
				sum+=(x-len)+(y-storelen);
			}else if(dir==3&&storedir==2) {
				sum+=(y-len)+storelen;
			}else if(dir==4&&storedir==1) {
				sum+=(x-storelen)+len;
			}else if(dir==4&&storedir==2) {
				sum+=(y-len)+(x-storelen);
			}
			
		}
		System.out.println(sum);
	}
}
