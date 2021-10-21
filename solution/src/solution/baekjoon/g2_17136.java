package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//완탐문제
//뭔지 모르겠을땐 완탐도 시도해보자!
public class g2_17136 {
	private static int min = Integer.MAX_VALUE;
	private static int paper[];
	private static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10][10];
		int cnt = 0;//1의 개수
		paper = new int[6];
		Arrays.fill(paper, 5);
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) cnt+=1;
			}
		}
		
		int [] num;
		if(cnt==0) {
			min = 0;
		}else {
			num = findone(0,0);
			dfs(num[0],num[1],cnt,0,paper);
			
		}
		if(min==Integer.MAX_VALUE) min = -1;
		System.out.println(min);
		
		
		
	}

	private static int[] findone(int i, int j) {
		if(j>=10) {
			i=i+1;
			j=0;
		}
		for(int l=i; l<10; l++) {
			for(int m=j; m<10; m++) {
				if(arr[l][m]==1) {
					return new int[] {l,m};
				}
				if(m==9)j=0;
			}
		}
		return new int[] {-1,0};
	}

	private static void dfs(int i, int j, int cnt,int answer, int[] paper) {
		if(cnt==0) min = Math.min(min, answer);
		if(i<0 || j<0) return;
		outer : for(int p=1; p<=5; p++) {
			for(int l=i; l<i+p; l++) {
				for(int m=j; m<j+p;m++) {
					if(l<0||m<0||l>=10||m>=10||arr[l][m]!=1) continue outer;
				}
			}		
			if(paper[p]==0) continue outer; //종이 개수가능한지 확인하기
			for(int l=i; l<i+p; l++) {
				Arrays.fill(arr[l],j,j+p,0);
			}

			paper[p]--;//종이 줄여주고
			int num[] = findone(i,j+p); //다음 1이 들어가있는 i,j를 찾아준다.
			//만약에 cnt==0이라면
			dfs(num[0],num[1],cnt-(p*p),answer+1,paper);
			for(int l=i; l<i+p; l++) {
				Arrays.fill(arr[l],j,j+p,1);
			}
			paper[p]++;
		}
		
	}

	
}
