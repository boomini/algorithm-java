package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_2615 {
	private static int[][] arr;
	private static int ans;
	private static int flag;
	private static boolean check = false;
	private static int dir[][] = {{0,1},{1,1},{-1,1},{1,0}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[19][19];
		for(int i=0; i<19; i++) {
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			for(int j=0; j<19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		outer : for(int i=0; i<19; i++) {	
			for(int j=0; j<19; j++) {
				flag = arr[i][j];
				if(flag==1 || flag==2) {
					for(int d=0; d<4; d++) {
						dfs(1,i,j,flag,d);
						if(check) {
							//앞으로 나오는 육목
							int nx = i - dir[d][0];
							int ny = j - dir[d][1];
							if(nx>=0 && ny >=0 && nx<=18 & ny <=18&&arr[nx][ny]==flag) {
								check = false;
								
							}else {
								System.out.println(flag);
								System.out.println((i+1)+ " " + (j+1));
								break outer;
							}

						}
					}
				}
			}
		}
		
		if(!check) {
			System.out.println(0);
		}
		
		
	}

	private static void dfs(int cnt, int i, int j, int flag, int d) {
		if(flag!=arr[i][j]) {
			return;
		}
		if(cnt==5) {
			check = true;
		}
		if(cnt==6) {//뒤로 나오는 육목
			check = false;
			return;
		}
		int nx = i+dir[d][0];
		int ny = j+dir[d][1];
		if(nx>=0 && ny >=0 && nx<=18 & ny <=18) {
			dfs(cnt+1,nx,ny,flag,d);
		}
		
	}
}
