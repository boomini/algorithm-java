package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5_3025 {
	private static int R;
	private static int C;
	private static char map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			//map 입력받기
			s = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}	
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(in.readLine());
			//화산탄이 들어오면 해결해주는 함수
			check(0, num-1);
		}
		
		StringBuilder sb = new StringBuilder();
		//화산탄 계산 끝낸 후, map 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}	
		System.out.println(sb.toString());
		

	}

	private static void check(int i, int j) {
		
		for(int k=i; k<R; k++) {
			//#1. 벽에 막혀있으면 멈추고 굳는다.
			if(map[k][j]=='X') {
				//처음들어가자마자 'X'일 경우
				if(k-1<0) return;
				
				map[k-1][j] = 'O';
				return;
			}
			//#2. 아래칸이 굳은 화산일때
			else if(map[k][j]=='O') {
				
				if(k-1>=0 && j-1>=0 && map[k-1][j-1]=='.' && map[k][j-1]=='.' ) {
					//#2-1. 왼쪽 왼쪽아래로 굴러떨어짐
					//현재 위치 위의 왼쪽과  왼쪽아래를 확인 후 갈 수 있으면 왼쪽아래부분을 탐색한다.
					check(k,j-1);
				}else if(k-1>=0 && j+1<C && map[k-1][j+1]=='.' && map[k][j+1]=='.') {
					//#2-2. 오른쪽-오른족아래로 굴러떨어짐
					//현재 위치 위의 오른쪽과  오른쪽아래를 확인 후 갈 수 있으면 오른쪽아래부분을 탐색한다.
					check(k,j+1);
				}else {
					//#2-3. 두 경우다 해당 안되면 화산탄은 자리에 멈추고 굳는다.
					map[k-1][j] = 'O';
					return;
				}
			}
			//#3. 땅이라면 화산탄은 멈추고 굳는다.
			else if(k==R-1){
				map[k][j] = 'O';
				return;
			}
			
		}
		
	}
}
