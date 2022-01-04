package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g5_5014 {
	   public static void main(String[] args) throws IOException {
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   
	      StringTokenizer st = new StringTokenizer(in.readLine());
	      int F = Integer.parseInt(st.nextToken());
	      //°Ç¹°Ãþ
	      int S = Integer.parseInt(st.nextToken());
	      //½ÃÀÛ
	      int G = Integer.parseInt(st.nextToken());
	      //µµÂøÃþ
	      int U = Integer.parseInt(st.nextToken());
	      //À§·Î
	      int D = Integer.parseInt(st.nextToken());
	      //¾Æ·¡·Î
	      boolean visited[] = new boolean[10000001];
	      Queue<Integer> q = new LinkedList<Integer>();
	      
	      q.add(S);
	      visited[S] = true;
	      int ans = -1;
	      int cnt = 0;
	      outer : while(!q.isEmpty()) {
	         int size = q.size();
	         
	         for(int i=0; i<size; i++) {
	            int a = q.poll();
	            if(a==G) {
	               ans = cnt;
	               break outer;
	            }
	            
	            int up = a+U;
	            int down = a-D;
	            if(up<=F && !visited[up]) {
	               q.add(up);
	               visited[up] = true;
	            }
	            if(down>=1 && !visited[down]) {
	               q.add(down);
	               visited[down] = true;
	            }

	         }
	         cnt++;
	      }
	      
	      if(ans==-1) {
	         System.out.println("use the stairs");
	      }else {
	         System.out.println(ans);
	      }
	   }
	}	