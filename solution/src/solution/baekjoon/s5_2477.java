package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		boolean flag[] = new boolean[5];
		int num[][] = new int[6][2];
		int big=1;
		int small = 1;
		int indexnum1 = 0;
		int indexnum2 = 0;
		int index = 0;
		for(int i=0; i<6; i++) {
			StringTokenizer st= new StringTokenizer(in.readLine()," ");
			
			int num1 = Integer.parseInt(st.nextToken());
			
			int num2 = Integer.parseInt(st.nextToken());
			num[i][0] = num1;
			num[i][1] = num2;
			if(!flag[num1])flag[num1] = true;
			else {
				if(indexnum1==0) {
					indexnum1 = num1;
				}else {
					indexnum2 = num1;
				}
				
			}
		}
		
		for(int i=0; i<6; i++) {
			if(num[i][0]!=indexnum1 && num[i][0]!=indexnum2) {
				big*=num[i][1];
			}
			else {
				int check1 =i-1<0?5:i-1;
				int check2 = i+1>5?0:i+1;
				if((num[check1][0]==indexnum1&&num[check2][0]==indexnum1)||(num[check1][0]==indexnum2&&num[check2][0]==indexnum2)){
					small*=num[i][1];
				}else {
					continue;
				}
			}
		}
		System.out.println(N*(big-small));
		
	}
}
