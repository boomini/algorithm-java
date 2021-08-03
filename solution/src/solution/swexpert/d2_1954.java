package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d2_1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.valueOf(in.readLine());
		for(int t=1; t<=tc; t++) {
			int num = Integer.valueOf(in.readLine());
			int dal[][] = new int[num][num];
			int len = dal.length;
			int d = 1;
			int i=0, j=-1;
			int count = 1;
			int k =0;
			while(true) {
	
				for(int l =0; l<len; l++) {
					j+=d;
					dal[i][j] = count++;
					
				}
				len = len-1;
				if(len <=0) break;
				for(int m=0; m<len; m++) {
					i+=d;
					dal[i][j] = count++;
				}
				d *= -1;
			}
			
			System.out.println("#" + t);
			for(int l=0; l<num; l++) {
				for(int m=0; m<num; m++) {
					System.out.print(dal[l][m] + " ");
				}
				System.out.println();
			}
		
			
		}
		
	}
}
