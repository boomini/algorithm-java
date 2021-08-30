package solution.swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution
{
 public static void main(String args[]) throws Exception
 {
	Scanner scanner = new Scanner(System.in);
   //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   
  // int T = Integer.parseInt(in.readLine());
	int T = scanner.nextInt();
   StringBuilder sb = new StringBuilder();
   for(int tc=1; tc<=T; tc++) {
	   //StringTokenizer st = new StringTokenizer(in.readLine(), " ");
	   sb.append("#").append(tc).append(" ");
	   
	   int N = scanner.nextInt();
	   
	   int arr[] = new int[N+1];
	   //StringTokenizer st = new StringTokenizer(in.readLine(), " ");
	   for(int i=1; i<=N; i++) {
		   arr[i] = scanner.nextInt();
	   }
	   
	   int value[] = new int[N+1];
	   int cnt = 0;
	   for(int i=1; i<=N; i++) {
		   if(arr[i]==1) {
			   if(value[i]==1) continue;
			   else {
				   cnt++;
				   int num = i;
				   for(int j=i; j<=N;) {
					   if(value[j]==0) {
						   value[j]=1;
					   }else if(value[j]==1) {
						   value[j]=0;
					   }
					   j+=num;
				   }
			   }
		   }else if(arr[i]==0) {
			   if(value[i]==0) continue;
			   else {
				   cnt++;
				   int num = i;
				   for(int j=i; j<=N;) {
					   if(value[j]==0) {
						   value[j]=1;
					   }else if(value[j]==1) {
						   value[j]=0;
					   }
					   j+=num;
				   }
			   }
		   }
	   }
	   sb.append(cnt).append("\n");
   }
   System.out.println(sb.toString());
 }
}
