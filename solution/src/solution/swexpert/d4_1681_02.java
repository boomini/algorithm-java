package solution.swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_1681_02 {

	   static int arr[][];
	   static boolean visited[][];
	   static int n;
	   static int ans;
	   static int num;
	   
	   public static void main(String[] args) throws NumberFormatException, IOException {
	      System.setIn(new FileInputStream("src\\input1861.txt"));
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int T = Integer.parseInt(br.readLine());
	      
	      for (int tc=1; tc<=T; tc++) {
	         n = Integer.parseInt(br.readLine());
	         arr = new int[n][n];
	         visited = new boolean[n][n]; 
	         
	         for (int i=0; i<n; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	            for (int j=0; j<n; j++) {
	               arr[i][j] = Integer.parseInt(st.nextToken());
	            }
	         }
	         int ans = n*n+1;
	         int max=0; 
	         for (int i=0; i<n; i++) {
	            for (int j=0; j<n; j++) {
	               int temp = 1;
	               int up = find(i, j, 1);      // 커지는 방향
	               visited[i][j] = false;
	               int down = find(i, j, -1);   // 작아지는 방향
	               temp = up+down-1;         // 더함
	                  if (max == temp && ans > arr[i][j]) {   // 최소번호
	                     ans = num;
	                  } else if (max < temp) {
	                     ans = num;
	                     max = temp;
	                  }
	            }
	         }
	         System.out.println("#"+tc+" "+ans+" "+max);
	      }
	   }


	   private static int find(int i, int j, int p) {
	      int dr[] = {-1, 1, 0, 0};   // 상하좌우
	      int dc[] = {0, 0, -1, 1};
	      
	      int temp = 1;
	      int cr = i;      // 현재 위치
	      int cc = j;
	      int k=0, nr=0, nc=0;
	      
	      while(!(visited[cr][cc])) {      // 안간곳만
	         visited[cr][cc] = true;
	         for (k=0; k<4; k++) {
	            nr = dr[k]+cr;
	            nc = dc[k]+cc;
	            if (nr>=0 && nr<n && nc>=0 && nc<n && arr[cr][cc]+p==arr[nr][nc]) {
	               temp++;
	               cr = nr;
	               cc = nc;
	               break;
	            }
	         }
	         
	      }
	      if (p == -1) {
	         num = arr[cr][cc];
	      } 
	      return temp;
	   }

}
