package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d2_1954_02 {
	static int d = 1;
	static int count = 1;
	static int dal[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.valueOf(in.readLine());
		for(int t=1; t<=tc; t++) {
			int num = Integer.valueOf(in.readLine());
			dal = new int[num][num];
			int len = dal.length;
			int d = 1;
			int i=0, j=-1;
			dal(i,j,len,d);
			System.out.println("#" + t);
			for(int l=0; l<num; l++) {
				for(int m=0; m<num; m++) {
					System.out.print(dal[l][m] + " ");
				}
				System.out.println();
			}
				
		}	
	}
	
	public static void dal(int i, int j, int len, int d) {
		for(int l =0; l<len; l++) {
			j+=d;
			
			dal[i][j] = count++;				
		}
		len = len-1;
		if(len <=0) {
			count = 1;
			return;
		}
		for(int m=0; m<len; m++) {
			i+=d;
			dal[i][j] = count++;
		}
		
		dal(i,j,len,d*-1);
	}
	
}
