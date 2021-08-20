package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pipe{
	int x;
	int y;
	public Pipe(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class g2_3109 {
	private static int R;
	private static int C;
	private static char arr[][];
	private static ArrayList<Integer[]> go ;
	private static Pipe [] pipe;
	private static int dir[][] = {{-1,1},{0,1},{1,1}};
							//오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선
	private static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		go = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			s = in.readLine();
			arr[i] = s.toCharArray();
		}
		pipe = new Pipe[R];
		for(int i=0; i<R; i++) {
			pipe[i] = new Pipe(i,0);
			
		}
		setting(0);
		System.out.println(cnt);
	}

	private static void setting(int index) {
		if(index == R) {
			//System.out.println("check");
			for (Integer[] check : go) {
				arr[check[0]][check[1]] = 'x';
			}
			go = new ArrayList<>();
			return;
		}
		while(true) {
			if(!isAvailable(index)) {
				//더 나아갈 수 없다면.
				setting(index+1);
				go = new ArrayList<>();
				return;
			}

		}
		
	}

	private static boolean isAvailable(int index) {
		for(int i=0; i<3; i++) {
			int nx = pipe[index].x + dir[i][0];
			int ny = pipe[index].y + dir[i][1];
			if(nx <0 || nx >=R||ny>=C||arr[nx][ny]=='x') continue;
			pipe[index].x = nx;
			pipe[index].y = ny;
			//System.out.println(index+" " + pipe[index].x + " " + pipe[index].y);
			//arr[nx][ny] = 'x';
			go.add(new Integer[] {nx,ny});
			if(pipe[index].y==C-1) cnt++;
			return true;
		}
		return false;
	}
}
